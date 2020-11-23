package comp3111.popnames;

import org.apache.commons.csv.*;
import edu.duke.*;

public class NameRecommendation {

	public static CSVParser getFileParser(int year) {
     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
     return fr.getCSVParser(false);
	}
 		
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
		 //Report += String.format("dad's rank: %d mom's rank: %d \n", DadRank, MomRank);
		 String BabyBoyName = getName(Vintageyear, DadRank, "M");
		 String BabyGirlName = getName(Vintageyear, MomRank, "F");
		 Report += String.format("The recommended name for baby boy is \" %s \" \n", BabyBoyName);
		 Report += String.format("The recommended name for baby girl is \" %s \" \n", BabyGirlName);
		 return Report;
	 }
 
}