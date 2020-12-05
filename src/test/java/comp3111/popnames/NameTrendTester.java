package comp3111.popnames;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NameTrendTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	// get_unique_people
	
    @Test 
    public void testget_unique_people() {
    	NameTrend a = new NameTrend();
    	int i = a.get_unique_people(2019, "F");
    	assertTrue(i==17905);
    }

	// getRank
	
	@Test 
    public void testGetRankNotFound1() {
		NameTrend a = new NameTrend();
    	int i = a.getRank(2020, "Faiz", "M");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGetRankNotFound2() {
		NameTrend a = new NameTrend();
    	int i = a.getRank(2019, "XXX", "M");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGetRankNotFound3() {
		NameTrend a = new NameTrend();
    	int i = a.getRank(2019, "Faiz", "F");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGetRankNotFound4() {
		NameTrend a = new NameTrend();
    	int i = a.getRank(2020, "Faiz", "M");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGetRankNotFound5() {
		NameTrend a = new NameTrend();
    	int i = a.getRank(1879, "Faiz", "M");
		assertEquals(i, -1);
    }
    
    @Test 
    public void testGetRankMale() {
    	NameTrend a = new NameTrend();
    	int i = a.getRank(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGetRankFemale() {
    	NameTrend a = new NameTrend();
    	int i = a.getRank(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    
    
    // getNameList
    
    @Test 
    public void testGetNameListNotFound1() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1945, 1941, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound2() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2021, 2020, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound3() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1870, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound4() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 1879, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }

    @Test 
    public void testGetNameListNotFound5() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1900, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound6() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1879, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound7() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 2020, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound8() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 2021, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound9() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1870, 1879, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound10() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1900, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }

    @Test 
    public void testGetNameListNotFound11() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 2020, "M", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound1F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1945, 1941, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound2F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2021, 2020, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound3F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1870, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound4F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 1879, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }

    @Test 
    public void testGetNameListNotFound5F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1900, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound6F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1879, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound7F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 2020, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound8F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 2021, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound9F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1870, 1879, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound10F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1900, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }

    @Test 
    public void testGetNameListNotFound11F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 2020, "F", 10);
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFoundxx() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 1920, "F", -1);
    	assertEquals(i.get(0), "Wrong input! Please make sure N is larger or equal to 1!");
    }
    
    @Test 
    public void testGetNameList1() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1941, 1945, "M", 10);
    	assertEquals(i.get(0), "James");
    }
    
    @Test 
    public void testGetNameList2() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1941, 1945, "F", 10);
    	assertEquals(i.get(0), "Mary");
    }
    
    @Test 
    public void testGetNameList3() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1941, 1942, "F", 100000);
    	assertEquals(i.get(0), "Wrong input! Your input N is too large. Please make it smaller!");
    }
    
    @Test 
    public void testGetNameList4() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1941, 1950, "M", 20);
    	assertEquals(i.get(0), "James");
    }
//    
//    // getAllRanks
//    
    @Test 
    public void testGetAllRanks1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M", 10);
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	assertTrue(i[6][0]==7);
    }

    @Test 
    public void testGetAllRanks2() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M", 10);
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	assertTrue(i[6][1]==6);
    }
    
    
    // getHighestRanks
    
    @Test 
    public void testGetHighestRanks1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M", 10);
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getHighestRanks(1941, i, 10);
    	assertTrue(j[0][0]==1);
    }

    @Test 
    public void testGetHighestRanks2() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M", 10);
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getHighestRanks(1941, i, 10);
    	assertTrue(i[6][0]==7);
    }
    
    // grosstrend
    @Test 
    public void testgrosstrend() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M", 10);
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getHighestRanks(1941, i, 10);
    	String[] k = a.grossTrend(j);
    	assertEquals(k[0], "FLAT");
    }
      
}
