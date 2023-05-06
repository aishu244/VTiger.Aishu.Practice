package testNG.Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGpractice 
{
	
	@Test(invocationCount=2,priority=3)
	public void testNGpracticeTest()
	{
		//Assert.fail();
		System.out.println("test/////");
	}
	@Test//(dependsOnMethods = {"testNGpracticeTest","testNGendTest"})
	public void testNGstartTest()
	{ 
		
		System.out.println("start////");
	}

	@Test(enabled = false)
	public void testNGendTest()
	{
		
		System.out.println("end////");
	}
}
