package comp3111.popnames;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopNamesForBirthTest {
//	The parameter Top N is a float which is not allowed! Please type again! \n
	
	@Test 
    public void testGetNames1() {
		TopNamesForBirth a = new TopNamesForBirth();
    	String i[][] = a.getNames(1990, 1995, 5, "F");
    	assertEquals(i[0][0], "Jessica");
    }
	@Test 
    public void testGetNames2() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i[][] = a.getNames(1990, 1995, 5, "M");
		assertEquals(i[0][0], "Michael");
    }
	@Test 
    public void testGetName3() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i[][] = a.getNames(1990, 1995, 5, "M");
		assertEquals(i[2][2], "Matthew");
    }
	@Test
	public void testGetReport1() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2000,1955,5,"M");
		assertEquals(i,"the range is illegal, please type again!");
	}
	@Test
	public void testGetRepot2() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2000,2010,-2,"M");
		assertEquals(i,"The parameter Top N is illegal(<1 or > the number of total distinct names in the period), please type again!");
	}
	@Test
	public void testGetRepot3() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2000,2000,5,"M");
		assertEquals(i,"Over the period 2000 to 2000, the name \"Jacob\" for male has hold the top spot most often for a total of 1 times. \n" + 
				"\n" + 
				" YEAR                     Rank1                      Rank2                     Rank3                     Rank4                     Rank5\n" + 
				"  2000                     Jacob                   Michael                   Matthew                    Joshua               Christopher\n");
	}
	@Test
	public void testGetRepot3_2() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2000,2000,5,"F");
		assertEquals(i,"Over the period 2000 to 2000, the name \"Emily\" for female has hold the top spot most often for a total of 1 times. \n" + 
				"\n" + 
				" YEAR                     Rank1                      Rank2                     Rank3                     Rank4                     Rank5\n" + 
				"  2000                     Emily                    Hannah                   Madison                    Ashley                     Sarah\n");
	}
	@Test
	public void testGetRepot4() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2010,2015,10,"M");
		assertEquals(i,"Over the period 2010 to 2015, the name \"Jacob\" for male has hold the top spot most often for a total of 3 times. \n" + 
				"\n" + 
				" YEAR                     Rank1                      Rank2                     Rank3                     Rank4                     Rank5                     Rank6                     Rank7                     Rank8                     Rank9                    Rank10\n" + 
				"  2010                     Jacob                     Ethan                   Michael                    Jayden                   William                 Alexander                      Noah                    Daniel                     Aiden                   Anthony\n" + 
				"  2011                      Jacob                     Mason                   William                    Jayden                      Noah                   Michael                     Ethan                 Alexander                     Aiden                    Daniel\n" + 
				"  2012                     Jacob                     Mason                     Ethan                      Noah                   William                      Liam                   Michael                    Jayden                 Alexander                     Aiden\n" + 
				"  2013                      Noah                      Liam                     Jacob                     Mason                   William                     Ethan                   Michael                 Alexander                    Jayden                    Daniel\n" + 
				"  2014                      Noah                      Liam                     Mason                     Jacob                   William                     Ethan                   Michael                 Alexander                     James                    Daniel\n" + 
				"  2015                      Noah                      Liam                     Mason                     Jacob                   William                     Ethan                     James                 Alexander                   Michael                  Benjamin\n");
	}
	@Test
	public void testGetRepot5() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2011,2011,5,"M");
		assertEquals(i,"Over the period 2011 to 2011, the name \"Jacob\" for male has hold the top spot most often for a total of 1 times. \n" + 
				"\n" + 
				" YEAR                     Rank1                      Rank2                     Rank3                     Rank4                     Rank5\n" + 
				"  2011                      Jacob                     Mason                   William                    Jayden                      Noah\n");
	}
	@Test
	public void testGetReport6() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(1922,1944,1,"M");
		assertEquals(i,"Over the period 1922 to 1944, the name \"Robert\" for male has hold the top spot most often for a total of 16 times. \n" + 
				"\n" + 
				" YEAR                     Rank1 \n" + 
				"  1922                      John\n" + 
				"  1923                      John\n" + 
				"  1924                    Robert\n" + 
				"  1925                    Robert\n" + 
				"  1926                    Robert\n" + 
				"  1927                    Robert\n" + 
				"  1928                    Robert\n" + 
				"  1929                    Robert\n" + 
				"  1930                    Robert\n" + 
				"  1931                     Robert\n" + 
				"  1932                    Robert\n" + 
				"  1933                    Robert\n" + 
				"  1934                    Robert\n" + 
				"  1935                    Robert\n" + 
				"  1936                    Robert\n" + 
				"  1937                    Robert\n" + 
				"  1938                    Robert\n" + 
				"  1939                    Robert\n" + 
				"  1940                     James\n" + 
				"  1941                      James\n" + 
				"  1942                     James\n" + 
				"  1943                     James\n" + 
				"  1944                     James\n");
	}
	@Test
	public void checkInrange1() {
		TopNamesForBirth a = new TopNamesForBirth();
		boolean i = a.checkInRange(1880, 1900, 100000, "F");
		assertEquals(i, false);
	}
	@Test
	public void checkInrange2() {
		TopNamesForBirth a = new TopNamesForBirth();
		boolean i = a.checkInRange(1880, 1900, 100000, "M");
		assertEquals(i, false);
	}
	@Test
	public void checkInrange3() {
		TopNamesForBirth a = new TopNamesForBirth();
		boolean i = a.checkInRange(1880, 1900, 30, "M");
		assertEquals(i, true);
	}
	@Test
	public void checkInrange4() {
		TopNamesForBirth a = new TopNamesForBirth();
		boolean i = a.checkInRange(1880, 1900, 30, "F");
		assertEquals(i, true);
	}
	
	@Test
	public void checkMax1() {
		TopNamesForBirth a = new TopNamesForBirth();
		int i = a.getMaxnum(2019, "F");
		assertEquals(i, 17905);
	}
	
	@Test
	public void checkMax2() {
		TopNamesForBirth a = new TopNamesForBirth();
		int i = a.getMaxnum(2000, "F");
		assertEquals(i, 17652);
	}
	
	@Test
	public void checkMax3() {
		TopNamesForBirth a = new TopNamesForBirth();
		int i = a.getMaxnum(2019, "M");
		assertEquals(i, 14049);
	}
	
}
