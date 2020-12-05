package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;
/** 
 *Task1 Program
 *@author     <a href=mailto:yzhanghf@connect.ust.hk>Yao ZHANG</a>
 *@version    1.0
 */
public class TopNamesForBirth {
	/**
     *getFileParsers:
     *@Description This function will get parameters "year1" & "year2" from the UI and use them to get the corresponding
     *data.
     *@params int year1; int year2
     *@return parsers: the data files
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
     *@Description This function  get the corresponding
     *data.
     *@params int year;
     *@return parsers: the data file
    */ 
	public static CSVParser getFileParser(int year) {
	     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
	     return fr.getCSVParser(false);
		}
	/**
     *getNames:
     *@Description This function  get the name list for the inRange year
     *data.
     *@params int year1, int year2, int num, String gender
     *@return name array
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
     *checkInRange:
     *@Description This function will check whether the range is legal or it is out of bound.
     *@params int year1; int year2; int num; String gender
     *@return boolean inRange;
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
     *getMaxnum:
     *@Description A helper function to retrive the maximum number of names of a certain gender for a certain year;
     *@params int year, String gender
     *@return int Maximum;
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
     *getReport1:
     *@Description A function that will detect some of the illegal situations and generate corresponding reports 
     *@params int year1, int year2, int num, String gender
     *@return String report.
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

