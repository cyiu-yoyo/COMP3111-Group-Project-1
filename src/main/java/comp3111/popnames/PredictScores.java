package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;
import java.text.DecimalFormat;

public class PredictScores {
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
	
	// same as in task0
	/**
	 * get_oRank:
	 * @Description This function will get a year parameter "iYOB" and a String iName and a String iGender and use it to get 
	 * the rank of name "iName", gender "iGender" in year "iYOB".
	 * @param int year; String name; String gender
	 * @return int: rank
	 */
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
	
	/**
	 * get_oYOB:
	 * @Description This function will get a year parameter "iYOB" and a String iPreferenceand use it to get 
	 * preference year of birth.
	 * @param int iYOB; String iPreference;
	 * @return int: oYOB
	 */
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
	
	/**
	 * get_oRankMate:
	 * @Description This function will get a year parameter "oYOB", a String iNameMate, and a String iGenderMate
	 * and use them to get the rank of the input mate.
	 * @param int oYOB; String iNameMate; String iGenderMate
	 * @return int: oRankMate
	 */
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
	
	/**
	 * get_oRankMate:
	 * @Description This function will use rank "oRank" and rank "oRankMate", "iYOB" and "oYOB", and "iGender" and "iMateGender"
	 * and use them to get the score of the compatibility between you and your mate.
	 * @param int oRank; int oRankMate, int iYOB, int oYOB, String iGender, String iMateGender
	 * @return string: final score
	 */
	public static String get_oScore(int oRank, int oRankMate, int iYOB, int oYOB, String iGender, String iMateGender) {
		int rank_total_1 = get_unique_people(iYOB, iGender);
		int rank_total_2 = get_unique_people(oYOB, iMateGender);
		double oScore = (1.0 - Math.abs(((1.0 * oRank - (1.0 * oRankMate))*2)/(rank_total_1+rank_total_2))) * 100;
		DecimalFormat df = new DecimalFormat("#.##");
		String score = df.format(oScore);
		return score;
	}
	
}