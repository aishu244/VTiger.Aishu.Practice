package vTiger.LisenersPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrgInformationPage;
import objectRepository.OrganizationPage;
import vTiger.GenericLibrary.BaseClass;
@Listeners(vTiger.GenericLibrary.LisnersImplementationLibrary.class)
public class CreateOrganizationWithLisners extends BaseClass
{
	@Test
	public void createorganizationtests() throws EncryptedDocumentException, IOException
	{
		String orgname = elib.readDataFromExcelSheet("Organization", 1, 2)+jlib.getRandomNumber();
	
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationlnk();		
		Reporter.log("organization linked",true);
		
		OrganizationPage op = new OrganizationPage(driver);
	   op.clickOnCreateOrgLookupImg();
	   Reporter.log("click on lookup image..",true);
		
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createOrgwithorgname(orgname);
		Reporter.log("create new organization...",true);
		
		OrgInformationPage oif = new OrgInformationPage(driver);
		String orgHeader = oif.organizationHeader();
		Reporter.log("organization header created..",true);
		
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
