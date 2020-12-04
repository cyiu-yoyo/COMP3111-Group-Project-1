package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

/** 
 *Task2 Program
 *@author     <a href=mailto:blanaa@connect.ust.hk>Lan Bo</a>
 *@version    1.0
 */
public class PopularityofName {
	/**
	 * read the csv files of the given period of time
	 * @param year1 the starting year
	 * @param year2 the ending year
	 */
	public static CSVParser[] getFileParsers(int year1, int year2) {
		CSVParser parsers[] = new CSVParser[year2-year1+1];
		FileResource fr;
		for(int year=year1; year<=year2; year++) {
			fr = new FileResource(String.format("dataset/yob%s.csv", year));
			parsers[year-year1]=fr.getCSVParser(false);
		}
		return parsers;
	}
	
	/**
	 * get the rank and count of the given gender of name
	 * @param year1 the starting year
	 * @param year2 the ending year
	 * @param name the name which you want get the rank
	 * @param gender gender of the name
	 */
	public static int[][] getRCP(int year1, int year2, String name, String gender) {
		int output[][] = new int[year2-year1+1][3];
		boolean found=false;
		int totalcount=0;
		int rank=1;
		CSVParser[] parsers=getFileParsers(year1,year2);
		for(int i=0; i<parsers.length; i++)
		{
			found=false;
			totalcount=0;
			rank=1;
			for(CSVRecord rec : parsers[i]) {
				if (rec.get(1).equals(gender)) {
		             // Return rank if name matches param
		             if (rec.get(0).equals(name)) {
		             	found = true;
		             	output[i][0] = rank;
		             	output[i][1] = Integer.parseInt(rec.get(2));
		             }
		             rank++;
		             totalcount+=Integer.parseInt(rec.get(2));
				}
			}
			if(!found){
				output[i][0]=-1;
				output[i][1]=0;
				output[i][2]=1;
			}
			else {
				//output[i][2]=(output[i][1]*100)/totalcount;
				output[i][2]=totalcount;
				//System.out.println(totalcount);
			}
		}
		return output;
	}
	
	/**
	 * generate the report about the popularity of name
	 * @param year1 the starting year
	 * @param year2 the ending year
	 * @param name the name which you want get the rank
	 * @param gender gender of the name
	 */
	public static String getReport(int year1, int year2, String name, String gender) {
		String report="";
		if(year1<1880 || year2<1880 || year1>2019 || year2>2019)
		{
			report="Input year out of range!!\nPlease check your input";
			return report;
		}
		if(year1>year2)
		{
			report="Invalid input time peroid!!\nPlease check your input";
			return report;
		}
		int RCP[][]=getRCP(year1,year2,name,gender);
		int mostpopularyear=0;
		float maxpercentage=0;
		for(int i=0; i<RCP.length; i++)
		{
			if(RCP[i][2]>maxpercentage)
			{
				maxpercentage=(float)RCP[i][1]*100/(float)RCP[i][2];
				mostpopularyear=year1+i;
			}
		}
		report+=String.format("In the year %s, the number of birth with name \" %s \" is %,d, "
				+ "which represents %f percent of total %s births in %s. "
				+ "The year when the name \"%s\" was most popular in %s. "
				+ "In that year, the number of birth is %,d, which represents %f percent of total %s births in %s.\n\n"
				, year2, name, RCP[year2-year1][1], (float)RCP[year2-year1][1]*100/(float)RCP[year2-year1][2], gender, year2, name, 
				mostpopularyear, RCP[mostpopularyear-year1][1], maxpercentage, gender, mostpopularyear);
		report+=String.format("Year \t Rank \t Count \t Percentage\n");
		for(int year=year1; year<=year2; year++)
		{
			report+=String.format("%s \t %d \t\t %d \t %f\n",year,RCP[year-year1][0],RCP[year-year1][1],(float)RCP[year-year1][1]*100/(float)RCP[year-year1][2]);
		}
		return report;
	}
}
