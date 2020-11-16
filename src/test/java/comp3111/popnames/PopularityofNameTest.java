package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PopularityofNameTest {
	int[] RCPM1, RCPM2, RCPM3, RCPM4, RCPM5;
	
	@Before
	public void setUp() throws Exception {
		RCPM1 = new int[] {7,30551,2};
		RCPM2 = new int[] {6,35892,2};
		RCPM3 = new int[] {6,37237,2};
		RCPM4 = new int[] {6,37374,2};
		RCPM5 = new int[] {6,37093,2};
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

}
