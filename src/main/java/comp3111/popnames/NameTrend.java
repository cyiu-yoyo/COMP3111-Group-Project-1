package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

import java.util.*;

public class NameTrend {
	// same as in task0
	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}
	
	public static CSVParser [] getFileParsers(int year1, int year2) {  // get data
	     CSVParser parsers [] = new CSVParser[year2 - year1 + 1];
	     FileResource fr;
	     for (int year = year1; year <= year2; year++) {
	    	 fr = new FileResource(String.format("dataset/yob%s.csv", year));
	    	 parsers[year - year1] = fr.getCSVParser(false);
	     }
	     return parsers;
	}
	
	public static Vector<String> getNameList(int year1, int year2, String gender) {
		Vector<String> output = new Vector<String>();
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
	public static int getRank(int year, String name, String gender) {
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
	
	public static String getFallName(Vector<String> nameList, int[][] allDiff) {
		int rankRise = 0;
		String nameRise = "";
		for (int i = 0; i < allDiff.length; i++) {
			for (int j = 0; j < allDiff[0].length; j++) {
				if (allDiff[i][j] > rankRise) {
					rankRise = allDiff[i][j];
					nameRise = nameList.get(i);
				}
			}
		}
		return nameRise;
	}
	
	public static String getRiseName(Vector<String> nameList, int[][] allDiff) {
		int rankFall = 0;
		String nameFall = "";
		for (int i = 0; i < allDiff.length; i++) {
			for (int j = 0; j < allDiff[0].length; j++) {
				if (allDiff[i][j] < rankFall) {
					rankFall = allDiff[i][j];
					nameFall = nameList.get(i);
				}
			}
		}
		return nameFall;
	}
	
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