package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;
/** 
 *Task1 Program
 *This is the main class for the Report1 that can generate the top N popular names
 *in specific period.
 *@author     <a href=mailto:yzhanghf@connect.ust.hk>Yao ZHANG</a>
 *@version    1.0
 */
public class TopNamesForBirth {
	/**
     *getFileParsers
     *This function will get parameters "year1" & "year2" from the UI and use them to get the corresponding
     *data.
     *@param year1 the start year
     *@param year2 the end year
     *@return CSVParser the data files
    */ 
	public static CSVParser[] getFileParsers(int year1, int year2) { //get the report
		CSVParser parsers[] = new CSVParser[year2-year1+1];
		FileResource fr;
		for(int year=year1; year<=year2; year++) {
			fr = new FileResource(String.format("dataset/yob%s.csv", year));
			parsers[year-year1]=fr.getCSVParser(false);
		}
		return parsers;
	}
	/**
     *getFileParsers:
     *This function  get the corresponding data.
     *@param year year to retrive the data file
     *@return CSVParser the data file
    */ 
	public static CSVParser getFileParser(int year) {
	     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
	     return fr.getCSVParser(false);
		}
	/**
     *getNames
     *This function  get the name list for the inRange year data.
     *@param year1 the start year
     *@param year2 the end year
     *@param num the TopN 
     *@param gender gender of interest
     *@return namearray the 2D array for names
    */ 
	public static String[][] getNames(int year1, int year2, int num, String gender){
		//asume n is in range(n<1 or n is too large)
		// can use the total babys in task0; uniqueGirls & uniqueBoys
		int range = year2-year1+1;
		String output[][] = new String[range][num];
		CSVParser[] parsers=getFileParsers(year1,year2);
		for(int i=0; i<parsers.length; i++) {//for every year
			int currentRank = 0;
			for(CSVRecord rec : parsers[i]) {// for every row
				if(rec.get(1).equals(gender)) {
					output[i][currentRank] = rec.get(0);
					currentRank ++;
					if(currentRank == num) {
						break;
					}
				}
			}
		}
		
		return output;
	}
	/**
     *checkInRange
     *This function will check whether the range is legal or it is out of bound.
     *@param year1 start year
     *@param year2 end year
     *@param num TopN user input
     *@param gender gender of user
     *@return inRange whether it is inRange or not
    */ 
	public static boolean checkInRange(int year1, int year2, int num, String gender) {
		boolean inRange = true;
		int maxNum = getMaxnum(year1,gender);
		int range = year2 - year1 +1;
		for(int i = 0; i < range; ++i) {
			int currentNum = getMaxnum(year1+i,gender);
			if(currentNum < maxNum){
				maxNum = currentNum;
			}
		}
		if(num >= 1 && num <= maxNum) {
			inRange = true;
		}
		else {
			inRange = false;
		}
		return inRange;

	}
	/**
     *getMaxnum
     *A helper function to retrive the maximum number of names of a certain gender for a certain year;
     *@param year
     *@param gender
     *@return Maximum maximum number of distinct names
    */ 
	public static int getMaxnum(int year, String gender) {
		int Maxnum = 0;
		for (CSVRecord rec : getFileParser(year)) {
			if (rec.get(1).equals(gender)) {
				Maxnum++;
			}
		}
		return Maxnum;
	}
	/**
     *getReport1
     *A function that will detect some of the illegal situations and generate corresponding reports 
     *@param year1 start year
     *@param year2 end year
     *@param num TopN that the user interested in
     *@param gender the gender that the user interested in
     *@return report conlusion and report about N most popular names.
    */ 
	public static String getReport1(int year1, int year2, int num, String gender) {
		int range = year2 - year1 + 1;
		if(range < 1 || year1 < 1880 || year2 > 2019) {
			return "the range is illegal, please type again!";
		}
		boolean inrange = checkInRange(year1,year2,num,gender);
		if(inrange == false) {
			return "The parameter Top N is illegal(<1 or > the number of total distinct names in the period), please type again!";
		}
		String report="";
		String Names[][]=getNames(year1,year2,num,gender);
		int times = 0;
		String TopName = "";
		int arr[] = new int[range];
		for(int i = 0; i < range; ++i) {
			arr[i] = 1;
		}
		for(int i = 0; i < range; ++i) {
			if(arr[i] == 0) {continue;}
			for(int j = i+1; j < range; ++j) {
				if(arr[j] == 0) {continue;}
				if(Names[j][0].equals(Names[i][0])) {
					arr[i] +=1;
					arr[j] = 0;
				}
			}
		}
		times = arr[0];
		TopName = Names[0][0];
		for(int i = 0; i < range; ++i) {
			if(arr[i] > times) {
				TopName = Names[i][0];
				times = arr[i];
			}
		}
		String Gender = "";
		if(gender == "M") {Gender = "male";}
		else {Gender = "female";}
		report+=String.format("Over the period %s to %s, the name \"%s\" for %s has hold the top spot most often for a total of %d times. \n\n"
				, year1, year2, TopName,  Gender, times);
		report+=String.format("%4s"," YEAR");
		for(int i = 1; i <= num; ++i) {
	
			String cur_rank = String.format("Rank%d",i);
			int lengtha = cur_rank.length();
			report += String.format("%" + 26 +"s", cur_rank);
			if(i == 1) {report +=" ";}
		}
		report += "\n";
		for(int i = 0; i<range; i++){
			report += String.format("%6d",year1+i);
			if((year1+i) % 10 == 1) {report += " ";}
			for(int j = 0; j < num; ++j) {
				int lengthb = Names[i][j].length();
				report += String.format("%" + 26 + "s", Names[i][j]);
			}
			report += "\n";
		}
		return report;
	}
}

