package testNG.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateMultipleOrganizationwinIndusty {

	@Test(dataProvider = "OrgWithIndustry")
	public void organizationWithIndustryTest(String orgname,String industry)
	{
		System.out.println("orgname= "+orgname+" industry= "+industry);
	}
	
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData()
	{
		Object[][] obj=new Object[5][2];
		
		obj[0][0]="Qspider";
		obj[0][1]="eduction";
		
		obj[1][0]="TCS";
		obj[1][1]="energy";		

		obj[2][0]="Wipro";
		obj[2][1]="Helthcare";
		
		obj[3][0]="Amazon";
		obj[3][1]="Elecronic";

		obj[4][0]="Flipcart";
		obj[4][1]="Manufacturing";
		
		return obj;

		
	}
}
