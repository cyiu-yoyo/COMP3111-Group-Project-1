package comp3111.popnames;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopNamesForBirthTest {


	@Test
	public void testRangeInvalid() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2000,1955,5,"M");
		assertEquals(i,"the range is illegal, please type again!");
	}
	
	public void testTopNumInvalid() {
		TopNamesForBirth a = new TopNamesForBirth();
		String i = a.getReport1(2000,2010,-2,"M");
		assertEquals(i,"the parameter Top N is illegal, please type again! ");
	}
}
