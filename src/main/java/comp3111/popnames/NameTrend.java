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
	 * get_unique_people:
	 * @Description This function will take parameters "year" and "gender", and use them to 
	 * get the number of names of people with gender "gender" and borned in year "year".
	 * @param int year; String gender
	 * @return int: unique_people
	 */
	public static int get_unique_people(int year, String gender) {
		int unique_people=0;
		for (CSVRecord rec : getFileParser(year)) {
			if (rec.get(1).equals(gender)) {
				unique_people++;
			}
		}
		return unique_people;
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
	 * getNameList:
	 * @Description This function will get year parameters "year1" & "year2" and the "gender" and Top "N" and use it to get a list of  
	 * names taht remained in rank N within "year1" & "year2" and of gender "gender"
	 * @param int year1; int year2; String gender; int N;
	 * @return Vector<String>: vector of names
	 */
	public static Vector<String> getNameList(int year1, int year2, String gender, int N) {
		Vector<String> output = new Vector<String>();
		Vector<String> output2 = new Vector<String>();
		if (year2 <= year1) {
			output.add("Wrong input! Please make sure the second year is larger than the first year!");
			return output;
		}
		else if (year1 < 1880 || year2 > 2019) {
			output.add("Wrong input! Please make sure both years are in range 1880 to 2019!");
			return output; 
		}
		if (N < 1) {
			output.add("Wrong input! Please make sure N is larger or equal to 1!");
			return output;
		}
		for (int i= year1; i <= year2; i++) {
			if (N > get_unique_people(i, gender)) {
				output.add("Wrong input! Your input N is too large. Please make it smaller!");
				return output;
			}
		}
		CSVParser[] parsers=getFileParsers(year1,year2);
		int count = 0;
		for (CSVRecord rec : parsers[0]) {  // iterate through N row
			if (count == N) { break; }
			if (rec.get(1).equals(gender)) {
				output.add(rec.get(0));
				output2.add(rec.get(0));
				count++;
			}
		}

		for (int j = 1; j < parsers.length; j++) {  // iterate through every year
			for (int k = 0; k < N; k++) {
				if ((getRank(year1+j, output2.get(k), gender) > N) || (getRank(year1+j, output2.get(k), gender)) < 0) {
					output.removeElement(output2.get(k));
				}
			}
		}
		

		return output;
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
	 * getHighestRanks:
	 * @Description This function will get one year parameters "year1", a int[][] rankArray, and a int N
	 * from the UI and rank data we need for the report.
	 * @param int year1; int[][] rankArray; int N;
	 * @return 2D array: all rank arrays
	 */
	public static int[][] getHighestRanks(int year1, int[][] rankArray, int N) {
		int array[][] = new int[rankArray.length][4];
		for (int i = 0; i < rankArray.length; i++) {
			for (int j = 0 ; j < rankArray[0].length; j++) {
				if (j == 0) {
					array[i][0] = rankArray[i][j];
					array[i][1] = year1;
					array[i][2] = rankArray[i][j];
					array[i][3] = year1;
				}
				else {
					if (rankArray[i][j] > array[i][0]) {
						array[i][0] = rankArray[i][j];
						array[i][1] = year1+j;
					}
					if (rankArray[i][j] < array[i][2]) {
						array[i][2] = rankArray[i][j];
						array[i][3] = year1+j;
					}
				}
			}
		}
		return array;
	}
	
	/**
	 * grossTrend:
	 * @Description This function will get an int[][] array and output a String[] containing the trends of every name
	 * @param int[][] array; 
	 * @return String array: trends
	 */
	public static String[] grossTrend(int[][] array) {
		String[] output = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i][1] <= array[i][3]) {
				if(array[i][2] == array[i][0]) {
					output[i] = "FLAT";
				}
				else if (array[i][0] < array[i][2]) {
					output[i] = "DOWN";
				}
				else {
					output[i] = "UP";
				}
			}
			else{
				if(array[i][2] == array[i][0]) {
					output[i] = "FLAT";
				}
				else if (array[i][0] > array[i][2]) {
					output[i] = "DOWN";
				}
				else {
					output[i] = "UP";
				}
			}
		}
		return output;
	}
}