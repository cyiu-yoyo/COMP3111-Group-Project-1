package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

import java.util.*;

/**
 * Task3 Program
 * @author	<a href=mailto:ychengaw@connect.ust.hk>Yih CHENG</a>
 * @version	1.0
 *
 */

public class NameTrend {
	// same as in task0
	/**
	 * getFileParser:
	 * @Description This function will get a "year "parameter from the UI and use it to get the corresponding
	 * data.
	 * @param int year;
	 * @return parser: a data file
	 */
	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}
	
	/**
	 * getFileParsers:
	 * @Description This function will get year parameters "year1" & "year2" from the UI and use it to get the corresponding
	 * data.
	 * @param int year1; int year2;
	 * @return parsers: the data files
	 */
	public static CSVParser [] getFileParsers(int year1, int year2) {  // get data
	     CSVParser parsers [] = new CSVParser[year2 - year1 + 1];
	     FileResource fr;
	     for (int year = year1; year <= year2; year++) {
	    	 fr = new FileResource(String.format("dataset/yob%s.csv", year));
	    	 parsers[year - year1] = fr.getCSVParser(false);
	     }
	     return parsers;
	}
	
	/**
	 * getNameList:
	 * @Description This function will get year parameters "year1" & "year2" and the gender and use it to get a list of every 
	 * person's names within "year1" & "year2" and of gender "gender"
	 * @param int year1; int year2; String gender;
	 * @return Vector<String>: a list of all names
	 */
	public static Vector<String> getNameList(int year1, int year2, String gender) {
		
		Vector<String> output = new Vector<String>();
		if (year2 <= year1) {
			output.add("Wrong input! Please make sure the second year is larger than the first year!");
			return output;
		}
		else if (year1 < 1880 || year2 > 2019) {
			output.add("Wrong input! Please make sure both years are in range 1880 to 2019!");
			return output; 
		}
		CSVParser[] parsers=getFileParsers(year1,year2);
		for (int i = 0; i < parsers.length; i++) {  // iterate through every year
			for (CSVRecord rec : parsers[i]) {  // iterate through every row
				if (rec.get(1).equals(gender)) {
					if (output.indexOf(rec.get(0)) == -1) {
						output.add(rec.get(0));
					}
				}
			}
		}
		return output;
	}
	
	// same as in task0
	/**
	 * getRank:
	 * @Description This function will get a year parameter "year" and a String name and a String gender and use it to get 
	 * the rank of name "name", gender "gender" in year "year".
	 * @param int year; String name; String gender
	 * @return int: rank
	 */
	public static int getRank(int year, String name, String gender) {
		if (year < 1880 || year > 2019) {
			return -1;
		}
		
		boolean found = false;
		int oRank = 0;
		int rank = 1;
		for (CSVRecord rec : getFileParser(year)) {
			// Increment rank if gender matches param
			if (rec.get(1).equals(gender)) {
				// Return rank if name matches param
				if (rec.get(0).equals(name)) {
					found = true;
					oRank = rank;
					break;
				}
				rank++;
			}
		}
		if (found)
			return oRank;
		else
			return -1;
	}
	
	/**
	 * getAllRanks:
	 * @Description This function will get two year parameters "year1" & "year2", a String gender, and a Vector<String>  
	 * nameList from the UI and get the rank of every name in nameList within every year "year1" & "year2".
	 * @param int year1; int year2; String gender; Vector<String> nameList
	 * @return 2D array: all rank arrays
	 */
	public static int[][] getAllRanks(int year1, int year2, String gender, Vector<String> nameList) {
		int rankArray[][] = new int[nameList.size()][year2 - year1 + 1];
		for (int i = 0; i < nameList.size(); i++) {
			//System.out.println(i);
			for (int year = 0; year < year2 - year1 + 1; year++) {
				rankArray[i][year] = getRank(year + year1, nameList.get(i), gender);
			}
		}
		return rankArray;
	}
	
	/**
	 * getDifference:
	 * @Description This function will get two year parameters "year1" & "year2", a String gender, and an int[][] allRanks  
	 * from the UI and get the rank difference of every rank with respect to each valid ranks in allRanks.
	 * @param int year1; int year2; String gender; int[][] allRanks;
	 * @return 2D array: rank difference array
	 */
	public static int[][] getDifference(int year1, int year2, String gender, int[][] allRanks) {
		int diffArray[][] = new int[allRanks.length][allRanks[0].length];
		for (int i = 0; i < allRanks.length; i++) {
			for (int year = 0; year < year2 - year1 + 1; year++) {
				if (year == 0) {
					diffArray[i][year] = 0;
				}
				else {
					boolean found = false;
					for (int j = year-1; j >= 0; j--) {
						if (allRanks[i][j] > 0 && allRanks[i][year] > 0) {
							diffArray[i][year] = allRanks[i][year] - allRanks[i][j];
							found =  true;
							break;
						}
					}
					if (found == false) { diffArray[i][year] = 0; }
				}
			}
		}
		return diffArray;
	}
	
	/**
	 * getFallName:
	 * @Description This function will get two parameters Vector<String> nameList and int[][] allDiff and find out the name 
	 * that has fallen the most in ranks according to allDiff array.
	 * @param Vector<String> nameList; int[][] allDiff
	 * @return String: nameFall
	 */
	public static String getFallName(Vector<String> nameList, int[][] allDiff) {
		int rankFall = 0;
		String nameFall = "";
		for (int i = 0; i < allDiff.length; i++) {
			for (int j = 0; j < allDiff[0].length; j++) {
				if (allDiff[i][j] > rankFall) {
					rankFall = allDiff[i][j];
					nameFall = nameList.get(i);
				}
			}
		}
		return nameFall;
	}
	
	/**
	 * getRiseName:
	 * @Description This function will get two parameters Vector<String> nameList and int[][] allDiff and find out the name 
	 * that has risen the most in ranks according to allDiff array.
	 * @param Vector<String> nameList; int[][] allDiff
	 * @return String: nameRise
	 */
	
	public static String getRiseName(Vector<String> nameList, int[][] allDiff) {
		int rankRise = 0;
		String nameRise = "";
		for (int i = 0; i < allDiff.length; i++) {
			for (int j = 0; j < allDiff[0].length; j++) {
				if (allDiff[i][j] < rankRise) {
					rankRise = allDiff[i][j];
					nameRise = nameList.get(i);
				}
			}
		}
		return nameRise;
	}
	
	/**
	 * getFall:
	 * @Description This function will get a "year" parameter, an int[][] allRank parameter, and an int[][] allDiff parameter to 
	 * find out the data of the year_fall1 and year_fall2 and rank_fall1 and rank_fall2 
	 * @param int year1, int[][] allRanks, int[][] allDiff
	 * @return int[]: all the essential numbers needed
	 */
	public static int[] getFall(int year1, int[][] allRanks, int[][] allDiff) {
		int output[] = new int[5];
		int rankFall = 0;
		for (int i = 0; i < allDiff.length; i++) {
			for (int j = 0; j < allDiff[0].length; j++) {
				if (allDiff[i][j] > rankFall) {
					rankFall = allDiff[i][j];
					output[2] = allRanks[i][j];
					output[3] = year1 + j;
					
					for (int k = j - 1; j >= 0; j--) {
						if (allRanks[i][k] > 0) {
							output[0] = allRanks[i][k];
							output[1] = year1 + k;
							break;
						}
					}
				}
			}
		}
		output[4] = output[2] - output[0];
		return output;
	}
	
	/**
	 * getRise:
	 * @Description This function will get a "year" parameter, an int[][] allRank parameter, and an int[][] allDiff parameter to 
	 * find out the data of the year_rise1 and year_rise2 and rank_rise1 and rank_rise2 
	 * @param int year1, int[][] allRanks, int[][] allDiff
	 * @return int[]: all the essential numbers needed
	 */
	public static int[] getRise(int year1, int[][] allRanks, int[][] allDiff) {
		int output[] = new int[5];
		int rankRise = 0;
		for (int i = 0; i < allDiff.length; i++) {
			for (int j = 0; j < allDiff[0].length; j++) {
				if (allDiff[i][j] < rankRise) {
					rankRise = allDiff[i][j];
					output[2] = allRanks[i][j];
					output[3] = year1 + j;
					
					for (int k = j - 1; j >= 0; j--) {
						if (allRanks[i][k] > 0) {
							output[0] = allRanks[i][k];
							output[1] = year1 + k;
							break;
						}
					}
				}
			}
		}
		output[4] = output[0] - output[2];
		return output;
	}
}