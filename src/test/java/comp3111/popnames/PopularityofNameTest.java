package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PopularityofNameTest {
	int[] RCPM1, RCPM2, RCPM3, RCPM4, RCPM5, RCPF1, RCPF2, NotName;
	
	@Before
	public void setUp() throws Exception {
		RCPM1 = new int[] {7,30551,1227941};
		RCPM2 = new int[] {6,35892,1380774};
		RCPM3 = new int[] {6,37237,1426846};
		RCPM4 = new int[] {6,37374,1362555};
		RCPM5 = new int[] {6,37093,1345610};
		RCPF1 = new int[] {29,5921,1694640};
		RCPF2 = new int[] {31,5650,1665373};
		NotName = new int[] {-1,0,1};
	}
	@Test 
    public void testGetRCPMale1() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "David", "M");
		assertArrayEquals(i[0], RCPM1);
    }
	
	@Test 
	public void testGetRCPMale2() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "David", "M");
		assertArrayEquals(i[1], RCPM2);
    }
	
	@Test 
	public void testGetRCPMale3() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "David", "M");
		assertArrayEquals(i[2], RCPM3);
    }
	
	@Test 
	public void testGetRCPMale4() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "David", "M");
		assertArrayEquals(i[3], RCPM4);
    }
	
	@Test 
	public void testGetRCPMale5() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "David", "M");
		assertArrayEquals(i[4], RCPM5);
    }
	
	@Test 
	public void testGetRCPFemale1() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(2018,2019, "Zoey", "F");
		assertArrayEquals(i[0], RCPF1);
    }
	
	@Test 
	public void testGetRCPFemale2() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(2018,2019, "Zoey", "F");
		assertArrayEquals(i[1], RCPF2);
    }
	
	@Test 
	public void NameInput1() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "", "M");
		assertArrayEquals(i[0], NotName);
    }
	
	@Test 
	public void NameInput2() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "eee", "M");
		assertArrayEquals(i[0], NotName);
    }
	
	@Test 
	public void NameInput3() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, " ", "F");
		assertArrayEquals(i[0], NotName);
    }
	
	@Test 
	public void NameInput4() {
		PopularityofName PM = new PopularityofName();
    	int i[][] = PM.getRCP(1941,1945, "abc", "F");
		assertArrayEquals(i[0], NotName);
    }
	
	@Test
	public void testInvalidYearInput1() {
		PopularityofName PM = new PopularityofName();
		String report = PM.getReport(2018, 2015, "XXX", "M");
		String ER = "Invalid input time peroid!!\nPlease check your input";
		assertEquals(ER, report);
	}
	
	@Test
	public void testInvalidYearInput2() {
		PopularityofName PM = new PopularityofName();
		String report = PM.getReport(1900, 2020, "XXX", "M");
		String ER = "Input year out of range!!\nPlease check your input";
		assertEquals(ER, report);
	}
	
	@Test
	public void testReport1() {
		PopularityofName PM = new PopularityofName();
		String report = PM.getReport(1944,1945, "David", "M");
		String ER = "In the year 1945, the number of birth with name \" David \" is 37,093, which represents 2.756594 percent of total M births in 1945. The year when the name \"David\" was most popular in 1945. In that year, the number of birth is 37,093, which represents 2.756594 percent of total M births in 1945.\n\n" + 
				"Year \t Rank \t Count \t Percentage\n1944 \t 6 \t\t 37374 \t 2.742935\n1945 \t 6 \t\t 37093 \t 2.756594\n";
		assertEquals(ER, report);
	}
	@Test
	public void testReport2() {
		PopularityofName PM = new PopularityofName();
		String report = PM.getReport(2015,2016, "Ema", "F");
		String ER = "In the year 2016, the number of birth with name \" Ema \" is 151, which represents 0.008541 percent of total F births in 2016. The year when the name \"Ema\" was most popular in 2016. In that year, the number of birth is 151, which represents 0.008541 percent of total F births in 2016.\n\n" + 
				"Year \t Rank \t Count \t Percentage\n2015 \t 1477 \t\t 155 \t 0.008699\n2016 \t 1503 \t\t 151 \t 0.008541\n";
		assertEquals(ER, report);
	}
}
