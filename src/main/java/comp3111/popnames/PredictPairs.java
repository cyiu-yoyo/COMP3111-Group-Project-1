package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

/** 
 *Task5 Program
 *@author     <a href=mailto:blanaa@connect.ust.hk>Lan Bo</a>
 *@version    1.0
 */
public class PredictPairs {
	/**
	 * read the csv file of the given year
	 * @param year the starting year
	 */
	public static CSVParser getFileParser(int year) {
	     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
	     return fr.getCSVParser(false);
	}
	
	public static int getRank(int year, String name, String gender) {		
		CSVParser parser=getFileParser(year);
		boolean found=false;
		int rank=1;
		int orank=1;
		for(CSVRecord rec : parser) {
			if (rec.get(1).equals(gender)) {
	             // Return rank if name matches param
	             if (rec.get(0).equals(name)) {
	             	found = true;
	             	orank=rank;
	             }
	             rank++;
			}
		}
		if(!found) {
			orank=1;
		}
		return orank;
	}
	
	/**
	 * Find the name of your pair
	 * @param year your pair's year of birth
	 * @param gender your pair's gender
	 * @param rank rank of your own name
	 */
	public static String findname(int year, String gender, int rank) {
		CSVParser parser=getFileParser(year);
		int crank=1;
		String name="";
		for(CSVRecord rec : parser){
			if(rec.get(1).equals(gender)) {
				if(crank == rank) {
					name=rec.get(0);
					break;
				}
				crank++;
			}
		}
		if(crank != rank) {
			parser=getFileParser(year);
			for(CSVRecord rec : parser){
				System.out.println(rec.get(1));
				if(rec.get(1).equals(gender)) {
					name=rec.get(0);
					return name;
				}
			}
		}
		return name;
	}
	
	/**
	 * Return your pair name
	 * @param year your year of birth
	 * @param name your name
	 * @param gender your gender
	 * @param gendermate pair's gender
	 * @param preference pair age preference
	 */
	public static String getpairname(int year, String name, String gender, String gendermate, String preference) {
		if(year<1880 || year>2019) {
			String result="Input year out of range!!\nPlease check your input";
			return result;
		}
		if((year==1880 && preference.equals("Y")) || (year==2019 && preference.equals("O"))) {
			String result="Your invalid prefered mate's year!!\nPlease check your input";
			return result;
		}
		int rank=getRank(year,name,gender);
		if(preference.equals("Y")) {
			year-=1;
		}
		else {
			year+=1;
		}
		return findname(year,gendermate,rank);
	}
}
