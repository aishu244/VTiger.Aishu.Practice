package vTiger.LisenersPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import vTiger.GenericLibrary.BaseClass;

@Listeners(vTiger.GenericLibrary.LisnersImplementationLibrary.class)
public class CreateContactWithLisners extends BaseClass{
	
	@Test(groups ="smokeSuite")
	public void createcontacttests() throws EncryptedDocumentException, IOException
	{
		String LASTNAME = elib.readDataFromExcelSheet("Contact", 1, 2)+jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clinkOncontactlnk();
		Assert.fail();
		
		ContactPage cp = new ContactPage(driver);
		cp.clickonTocreateContactImg();
		
	     CreateNewContactPage ccp = new CreateNewContactPage(driver);
	     ccp.CreateNewContactwithlastname(LASTNAME);
	     
	     ContactInfoPage cif = new ContactInfoPage(driver);
	     String contactHeader = cif.HeaderTxt();
	     System.out.println(contactHeader);
	     Assert.assertTrue(contactHeader.contains(LASTNAME), "contact created");
	    // Assert.assertTrue(contactHeader.contains(LASTNAME));
	     
	     
	}
	@Test(groups = "regressionsuite")
	public void abc()
	{
		System.out.println("add one for regression teste");
	}
		
		

}
