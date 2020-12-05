package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

/** 
 *Task4 Program
 *Main Class for the Application1 that can generate recommended names for newborn babies based 
 *on their parents' names and brth year.
 *@author  <a href=mailto:yzhanghf@connect.ust.hk>Yao Zhang</a>
 *@version 1.0
 */
public class NameRecommendation {
	/**
     *getFileParsers:
     *This function get the corresponding data.
     *@param year birth year of the user
     *@return CSVParser the data file
    */ 
	public static CSVParser getFileParser(int year) {
     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
     return fr.getCSVParser(false);
	}
	/**
     *getRank:
     *@Description This function  get the rank for a certain name for a certain gender in a certain year
     *@param year birth year of the user
	 *@param name name of the user 
	 *@param gender gender of the user
     *@return ranking the rank of a certain name of certain gender in certain year
    */ 	
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
	     	return 1;
	 }
	 
	 /**
	     *getName
	     *This function  get the Name for a certain rank for a certain gender in a certain year
	     *@param year birth year of user
	     *@param rank ranking of a name of a gender of a certain year
	     *@param gender gender of user
	     *@return name the name of a rank of a gender in a certain year
	    */ 	
	 public static String getName(int year, int rank, String gender) {
	 	boolean found = false;
	     String oName = "";
	     int currentRank = 0;
	     
	     // For every name entry in the CSV file
	     for (CSVRecord rec : getFileParser(year)) { 
	         // Get its rank if gender matches param
	         if (rec.get(1).equals(gender)) {
	             // Get the name whose rank matches param
	         	currentRank++;
	            if (currentRank == rank) {
	             	found = true;
	             	oName = rec.get(0);
	                break;
	            }
	         }
	     }     
	     if (found)
	     	return oName;
	     else
	     	return "information on the name at the specified rank is not available";
	 }
	 /**
	     *getMaxnum
	     *A helper function to retrive the maximum number of names of a certain gender
	     *for a certain year;
	     *@param year the year of birth
	     *@param gender the gender of the user
	     *@return Maxnum the maximum number of distinct names of a certain year
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
	     *getBabyName
	     *This function try to generate the recommended names for babys and it
	     *will do some illegal situation detection as well.
	     *@param Dadyear birth year of father
	     *@param Momyear birth year of mother
	     *@param Dadname name of father
	     *@param Momname name of mother
	     *@param Vintageyear vintage year for the baby's name
	     *@return report report and conclusion of the recommended names
	    */ 
	 public static String getBabyName(int Dadyear, int Momyear, String Dadname, String Momname, int Vintageyear) {
		 if(Dadyear < 1880 || Dadyear > 2019 || Momyear < 1880 || Momyear > 2019 ) {
			 return "The year of Dad/Mom's birth is out of range! Please type a new one!";
		 }
		 if(Vintageyear < 1880 || Vintageyear > 2019 ) {
			 return "The year of Vintageyear is out of range! Please type a new one!";
		 }
		 String Report = "";
		 int DadRank = getRank(Dadyear,Dadname,"M");
		 int MomRank = getRank(Momyear,Momname,"F");
		 int maxRank_g = getMaxnum(Vintageyear, "F");
		 int maxRank_b = getMaxnum(Vintageyear, "M");
		 if(DadRank > maxRank_b) {DadRank = 1;}
		 if(MomRank > maxRank_g) {MomRank = 1;}
		 //Report += String.format("dad's rank: %d mom's rank: %d \n", DadRank, MomRank);
		 String BabyBoyName = getName(Vintageyear, DadRank, "M");
		 String BabyGirlName = getName(Vintageyear, MomRank, "F");
		 Report += String.format("The recommended name for baby boy is \" %s \" \n", BabyBoyName);
		 Report += String.format("The recommended name for baby girl is \" %s \" \n", BabyGirlName);
		 return Report;
	 }
 
}