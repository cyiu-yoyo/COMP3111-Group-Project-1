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
    
    
    //getNameList
    
    @Test 
    public void testGetNameListNotFound1() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1945, 1941, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound2() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2021, 2020, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound3() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1870, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound4() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 1879, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }

    @Test 
    public void testGetNameListNotFound5() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1900, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound6() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1879, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound7() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 2020, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound8() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 2021, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound9() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1870, 1879, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound10() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1900, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }

    @Test 
    public void testGetNameListNotFound11() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 2020, "M");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound1F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1945, 1941, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound2F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2021, 2020, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound3F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1870, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound4F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 1879, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }

    @Test 
    public void testGetNameListNotFound5F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1900, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound6F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 1879, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure the second year is larger than the first year!");
    }
    
    @Test 
    public void testGetNameListNotFound7F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 2020, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound8F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2020, 2021, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound9F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1870, 1879, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameListNotFound10F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1879, 1900, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }

    @Test 
    public void testGetNameListNotFound11F() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(1900, 2020, "F");
    	assertEquals(i.get(0), "Wrong input! Please make sure both years are in range 1880 to 2019!");
    }
    
    @Test 
    public void testGetNameList1() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2000, 2019, "M");
    	assertEquals(i.get(0), "Jacob");
    }
    
    @Test 
    public void testGetNameList2() {
    	NameTrend a = new NameTrend();
    	Vector<String> i = a.getNameList(2000, 2019, "F");
    	assertEquals(i.get(0), "Emily");
    }
    
    // getAllRanks
    
    @Test 
    public void testGetAllRanks1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	assertTrue(i[6][0]==7);
    }

    @Test 
    public void testGetAllRanks2() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	assertTrue(i[6][1]==6);
    }
    
    // getDifference
    
    @Test 
    public void testGetDifference1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	assertTrue(j[6][0]==0);
    }
    
    @Test 
    public void testGetDifference2() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	assertTrue(j[6][1]==-1);
    }
    
    // getFallName
    
    @Test 
    public void testGetFallName1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	String k = a.getFallName(b, j);
    	assertEquals(k, "Tyrus");
    }
    
    // getRiseName
    
    @Test 
    public void testGetRiseName1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	String k = a.getRiseName(b, j);
    	assertEquals(k, "Macarthur");
    }
    
    // getFall
    
    @Test 
    public void testFall1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getFall(1941, i, j);
    	assertTrue(k[0]==1693);
    }
    
    // getFall
    
    @Test 
    public void testFall2() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1943, 1945, "M");
    	int[][] i = a.getAllRanks(1943, 1945, "M", b);
    	int[][] j = a.getDifference(1943, 1945, "M", i);
    	int[] k = a.getFall(1943, i, j);
    	assertTrue(k[1]==1943);
    }
    
    @Test 
    public void testFall3() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getFall(1941, i, j);
    	assertTrue(k[2]==3867);
    }
    
    @Test 
    public void testFall4() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getFall(1941, i, j);
    	assertTrue(k[3]==1944);
    }
    
    // getRise
    
    @Test 
    public void testRise1() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getRise(1941, i, j);
    	assertTrue(k[0]==3816);
    }
    
    @Test 
    public void testRise2() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getRise(1941, i, j);
    	assertTrue(k[1]==1941);
    }
    
    @Test 
    public void testRise3() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getRise(1941, i, j);
    	assertTrue(k[2]==513);
    }
    
    @Test 
    public void testRise4() {
    	NameTrend a = new NameTrend();
    	Vector<String> b = a.getNameList(1941, 1945, "M");
    	int[][] i = a.getAllRanks(1941, 1945, "M", b);
    	int[][] j = a.getDifference(1941, 1945, "M", i);
    	int[] k = a.getRise(1941, i, j);
    	assertTrue(k[3]==1942);
    }
    
}
