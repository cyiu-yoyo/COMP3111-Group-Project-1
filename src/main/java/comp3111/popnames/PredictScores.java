package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

public class PredictScores {
	// same as in task0
	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}
	
	// same as in task0
	public static int get_oRank(int iYOB, String iName, String iGender) {
		if (iYOB < 1880 || iYOB > 2019) {
			return -2;
		}
		
		boolean found = false;
		int oRank = 0;
		int rank = 1;
		for (CSVRecord rec : getFileParser(iYOB)) {
			// Increment rank if gender matches param
			if (rec.get(1).equals(iGender)) {
				// Return rank if name matches param
				if (rec.get(0).equals(iName)) {
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
	
	public static int get_oYOB(int iYOB, String iPreference) {
		int oYOB = iYOB;
		if (iPreference == "younger") {
			oYOB += 1;
		}
		else {
			oYOB -= 1;
		}
		return oYOB;
	}
	
	public static int get_oRankMate(int oYOB, String iNameMate, String iGenderMate) {
		if (oYOB < 1880 || oYOB > 2019) {
			return -2;
		}
		
		boolean found = false;
		int oRankMate = 0;
		int rank = 1;
		for (CSVRecord rec : getFileParser(oYOB)) {
			// Increment rank if gender matches param
			if (rec.get(1).equals(iGenderMate)) {
				// Return rank if name matches param
				if (rec.get(0).equals(iNameMate)) {
					found = true;
					oRankMate = rank;
					break;
				}
				rank++;
			}
		}
		if (found)
			return oRankMate;
		else
			return -1;
	}
	
	public static double get_oScore(int oRank, int oRankMate) {
		double oScore = (1.0 - Math.abs(1.0 * oRank - (1.0 * oRankMate)/(1.0 * oRank))) * 100;
		return oScore;
	}
	
}