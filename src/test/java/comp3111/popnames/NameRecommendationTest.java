package comp3111.popnames;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NameRecommendationTest {


	@Test
	public void testgetRank1() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getRank(1990, "XXX", "M");
		assertEquals(i,1);
	}
	@Test
	public void testgetRank2() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getRank(2000,"XXX","F");
		assertEquals(i,1);
	}
	@Test
	public void testgetRank3() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getRank(2000,"Lisa","F");
		assertEquals(i,295);
	}
	@Test
	public void testgetRank4() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getRank(2000,"Joseph","M");
		assertEquals(i,8);
	}
	
	@Test
	public void checkMax1() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getMaxnum(2019, "F");
		assertEquals(i, 17905);
	}
	
	@Test
	public void checkMax2() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getMaxnum(2000, "F");
		assertEquals(i, 17652);
	}
	
	@Test
	public void checkMax3() {
		NameRecommendation a = new NameRecommendation();
		int i = a.getMaxnum(2019, "M");
		assertEquals(i, 14049);
	}
	
	@Test
	public void testgetName1() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getName(2000,8,"F");
		assertEquals(i,"Jessica");
	}
	@Test
	public void testgetName2() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getName(2000,1000,"M");
		assertEquals(i,"Isaak");
	}
	
	@Test
	public void testgetName3() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getName(2000,300000,"F");
		assertEquals(i,"information on the name at the specified rank is not available");
	}
	@Test
	public void testgetNam4() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getName(2000,299999,"M");
		assertEquals(i,"information on the name at the specified rank is not available");
	}
	

	
	@Test
	public void testgetBabyName1() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(2020, 1990, "Ken", "Rose", 1970);
		assertEquals(i,"The year of Dad/Mom's birth is out of range! Please type a new one!");
	}
	@Test
	public void testgetBabyName1_2() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1800, 1990, "Ken", "Rose", 1970);
		assertEquals(i,"The year of Dad/Mom's birth is out of range! Please type a new one!");
	}
	@Test
	public void testgetBabyName2() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 2020, "Ken", "Rose", 1970);
		assertEquals(i,"The year of Dad/Mom's birth is out of range! Please type a new one!");
	}
	
	@Test
	public void testgetBabyName2_2() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 1800, "Ken", "Rose", 1970);
		assertEquals(i,"The year of Dad/Mom's birth is out of range! Please type a new one!");
	}
	@Test
	public void testgetBabyName3() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 2000, "Ken", "Rose", 2020);
		assertEquals(i,"The year of Vintageyear is out of range! Please type a new one!");
	}
	@Test
	public void testgetBabyName4() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 1990, "Ken", "Rose", 1800);
		assertEquals(i,"The year of Vintageyear is out of range! Please type a new one!");
	}
	@Test
	public void testgetBabyName5() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 1990, "XXX", "Rose", 1990);
		assertEquals(i,"The recommended name for baby boy is \" Michael \" \n" + 
				"The recommended name for baby girl is \" Rose \" \n");
	}
	@Test
	public void testgetBabyName6() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 1990, "Ken", "XXX", 1990);
		assertEquals(i,"The recommended name for baby boy is \" Ken \" \n" + 
				"The recommended name for baby girl is \" Jessica \" \n");
	}
	@Test
	public void testgetBabyName7() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 1990, "Ken", "Rose", 1990);
		assertEquals(i,"The recommended name for baby boy is \" Ken \" \n" + 
				"The recommended name for baby girl is \" Rose \" \n");
	}
	@Test
	public void testgetBabyName8() {
		NameRecommendation a = new NameRecommendation();
		String i = a.getBabyName(1990, 2000, "XXX", "XXX", 1990);
		assertEquals(i,"The recommended name for baby boy is \" Michael \" \n" + 
				"The recommended name for baby girl is \" Jessica \" \n");
	}
	
	
}
