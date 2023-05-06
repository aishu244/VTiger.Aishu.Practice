package vTiger.Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void practice()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Test run 1");
		sa.assertEquals("M", "N");
		System.out.println("Test run 2");
		//Assert.assertEquals(20,30);
		sa.assertEquals(20, 30);
		Assert.assertEquals(true, true);
		System.out.println("Test run 3");
		sa.assertEquals(false, false);
		System.out.println("Test run 4");
		sa.assertEquals(false, false);
		Assert.assertTrue(false);
		System.out.println("Test run 5");
		sa.assertAll();
		
		
	
	}
}
