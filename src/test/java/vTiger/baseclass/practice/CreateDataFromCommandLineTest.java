package vTiger.baseclass.practice;

import org.testng.annotations.Test;

public class CreateDataFromCommandLineTest {
	@Test
	public void demo1()
	{
		System.out.println("this is test 1");
	}

	@Test
	public void demo2()
	{
		System.out.println("this is test 2");
	}

	@Test//(priority = 1,invocationCount = 3,enabled = false)
	public void demo3()
	{
		System.out.println("this is test 3....");
	}

	@Test
	public void readData()
	{
		String BROWSER = System.getProperty("browser");
		String UN = System.getProperty("username");
		String PWD = System.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(UN);
		System.out.println(PWD);
	}
}
