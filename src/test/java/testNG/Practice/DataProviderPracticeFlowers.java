package testNG.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeFlowers {
	
	@Test(dataProvider = "Flowers")
	public void FlowerOrderTest(String name,int qty,String location)
	{
		System.out.println("flowername= "+name+" qty= "+qty+" location= "+location);
	}

	@DataProvider(name="Flowers")
	
	public Object[][]senderData()
	{
		Object[][] obj = new Object[3][3];
		obj[0][0]="lotus";
		obj[0][1]=5;
		obj[0][2]="pune";
		
		obj[1][0]="rose";
		obj[1][1]=50;
		obj[1][2]="kolhapur";
		
		obj[2][0]="sunflower";
		obj[2][1]=40;
		obj[2][2]="mumbai";
		return obj;
		
	}
}
