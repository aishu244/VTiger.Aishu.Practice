package testNG.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateOrgnizationsWithHelthcareTest {
	@Test(dataProvider = "healthcare")
	public void orgWithHelthcare(String orgname,String industry)
	{
		System.out.println("orgname= "+orgname+" industry= "+industry);
	}
	@DataProvider(name="healthcare")
	public Object[][] getdata()
	{
		Object[][] data = new Object[5][2];
		
		data[0][0]="Qspider";
		data[0][1]="Helthcare";
		
		data[1][0]="TCS";
		data[1][1]="Helthcare";
		
		data[2][0]="Wipro";
		data[2][1]="Helthcare";
		
		data[3][0]="Amazon";
		data[3][1]="Helthcare";
		
		data[4][0]="Flipcart";
		data[4][1]="Helthcare";
		
		return data;
	}

}
