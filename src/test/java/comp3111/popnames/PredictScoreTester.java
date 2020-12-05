package comp3111.popnames;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PredictScoreTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
    public void testGet_oRankNotFound1() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRank(2020, "Faiz", "M");
		assertEquals(i, -2);
    }
	
	@Test 
    public void testGet_oRankNotFound2() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRank(2019, "XXX", "M");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGet_oRankNotFound3() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRank(2019, "Faiz", "F");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGet_oRankNotFound4() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRank(1879, "Faiz", "F");
		assertEquals(i, -2);
    }
    
    @Test 
    public void testGet_oRank1() {
    	PredictScores a = new PredictScores();
    	int i = a.get_oRank(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGet_oRank2() {
    	PredictScores a = new PredictScores();
    	int i = a.get_oRank(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    
    
    
    
    @Test 
    public void testGet_oRankMateNotFound1() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRankMate(2020, "Faiz", "M");
		assertEquals(i, -2);
    }
	
	@Test 
    public void testGet_oRankMateNotFound2() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRankMate(2019, "XXX", "M");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGet_oRankMateNotFound3() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRankMate(2019, "Faiz", "F");
		assertEquals(i, -1);
    }
	
	@Test 
    public void testGet_oRankMateNotFound4() {
		PredictScores a = new PredictScores();
    	int i = a.get_oRankMate(1879, "Faiz", "F");
		assertEquals(i, -2);
    }
    
    @Test 
    public void testGet_oRankMate1() {
    	PredictScores a = new PredictScores();
    	int i = a.get_oRankMate(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGet_oRankMate2() {
    	PredictScores a = new PredictScores();
    	int i = a.get_oRankMate(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    
    
    @Test 
    public void testget_oYOB1() {
    	PredictScores a = new PredictScores();
    	int i = a.get_oYOB(1995, "younger");
    	assertTrue(i==1996);
    }
    
    @Test 
    public void testget_oYOB2() {
    	PredictScores a = new PredictScores();
    	int i = a.get_oYOB(1995, "older");
    	assertTrue(i==1994);
    }
    
    @Test 
    public void test_get_unique_people() {
    	PredictScores a = new PredictScores();
    	int i = a.get_unique_people(2012, "M");
    	assertTrue(i==14216);
    }

    
    @Test public void testget_oScore() {
    	PredictScores a = new PredictScores();
    	int k = a.get_oRank(2018, "David", "M");
    	int j = a.get_oRankMate(2019, "Desire", "F");
    	String i = a.get_oScore(k, j, 2018, 2019, "M", "F");
    	assertEquals(i, "86.42");
    }

}
