package vTiger.baseclass.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrgInformationPage;
import objectRepository.OrganizationPage;
import vTiger.GenericLibrary.BaseClass;

public class CreateOrganizationWithBaseclass extends BaseClass {
	
	@Test
	public void createorganizationtests() throws EncryptedDocumentException, IOException
	{
		String orgname = elib.readDataFromExcelSheet("Organization", 1, 2)+jlib.getRandomNumber();
		String industry = elib.readDataFromExcelSheet("Organization", 4, 3)+jlib.getRandomNumber();
		 Object[][] ind = elib.readMultipleData("OrgnamewithIndustyType");
	
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationlnk();
		
		OrganizationPage op = new OrganizationPage(driver);
	   op.clickOnCreateOrgLookupImg();
		
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
	    cop.createorgWithorgnameAndIndustryType(orgname, industry);
		cop.createOrgwithorgname(orgname);
		
		OrgInformationPage oif = new OrgInformationPage(driver);
		String orgHeader = oif.organizationHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(orgname));
		//or
	//	Assert.assertTrue(orgHeader.contains(orgname), "organization created");
		
	//	 instead of 
		
	//  if(orgHeader.contains(orgname))
	//	{
	//		System.out.println("pass");
	//	}
	//	else
	//	{
	//		System.out.println("fail");
	//	}
		
	} 

	@Test(groups = "regressionsuite")
	public void att()
    {
	System.out.println("hi in this class i doing group execution");
	}
	
	@Test
	public void contactwithchecklead()
	{
		System.out.println("contact with lead");
	}
	@Test
	public void contactWithleadsource()
	{
		System.out.println("contact with lead source..");
	}
	
	
	
	
	
	
	
}
