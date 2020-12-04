package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

/** 
 *Task4 Program
 *@author     <a href=mailto:yzhanghf@connect.ust.hk>Yao Zhang</a>
 *@version    1.0
 */
public class NameRecommendation {
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
     *getRank:
     *@Description This function  get the rank for a certain name for a certain gender in a certain year
     *@params int year, String name, String gender 
     *@return int ranking
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
	     *getName:
	     *@Description This function  get the Name for a certain rank for a certain gender in a certain year
	     *@params int year, int rank, String gender 
	     *@return String name
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
	     *getBabyName:
	     *@Description This function try to generate the recommended names for babys and it
	     *will do some illegal situation detection as well.
	     *@params int Dadyear, int Momyear, String Dadname, String Momname, int Vintageyear 
	     *@return String report of the recommended names
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