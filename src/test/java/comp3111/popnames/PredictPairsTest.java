package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PredictPairsTest {
	@Test
	public void PredictTest1()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "David";
		String result = PP.getpairname(2018,"David","M","M","Y");
		assertEquals(PN, result);
	}
	@Test
	public void PredictTest2()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Samuel";
		String result = PP.getpairname(2018,"David","M","M","O");
		assertEquals(PN, result);
	}
	@Test
	public void PredictTest3()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Chloe";
		String result = PP.getpairname(2018,"David","M","F","Y");
		assertEquals(PN, result);
	}
	@Test
	public void PredictTest4()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Penelope";
		String result = PP.getpairname(2018,"David","M","F","O");
		assertEquals(PN, result);
	}
	@Test
	public void PredictTest5()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Wyatt";
		String result = PP.getpairname(2018,"Zoey","F","M","O");
		assertEquals(PN, result);
	}
	@Test
	public void PredictTest6()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Emma";
		String result = PP.getpairname(2015,"Zyrielle","F","F","Y");
		assertEquals(PN, result);
	}
	@Test
	public void PredictTest7()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Emma";
		String result = PP.getpairname(2015,"abc","M","F","Y");
		assertEquals(PN, result);
	}
	@Test
	public void YearTest1()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Your invalid prefered mate's year!!\nPlease check your input";
		String result = PP.getpairname(2019,"David","M","M","O");
		assertEquals(PN, result);
	}
	@Test
	public void YearTest2()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Input year out of range!!\nPlease check your input";
		String result = PP.getpairname(2020,"David","M","M","O");
		assertEquals(PN, result);
	}
	@Test
	public void YearTest3()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Your invalid prefered mate's year!!\nPlease check your input";
		String result = PP.getpairname(1880,"David","M","M","Y");
		assertEquals(PN, result);
	}
	@Test
	public void YearTest4()
	{
		PredictPairs PP = new PredictPairs();
		String PN = "Input year out of range!!\nPlease check your input";
		String result = PP.getpairname(1800,"David","M","M","O");
		assertEquals(PN, result);
	}
}
