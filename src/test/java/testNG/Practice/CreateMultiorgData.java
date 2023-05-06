package testNG.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrgInformationPage;
import objectRepository.OrganizationPage;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateMultiorgData
{	 
	// generic library
	PropertyFileLibrary  plib= new PropertyFileLibrary();
	ExcelFileLibrary elib = new ExcelFileLibrary();
	JavaLibrary jlib= new JavaLibrary();
	WebDriverLibrary wlib= new WebDriverLibrary();	
	//
	@Test(dataProvider = "multiorganization")
	public void createmultiorganizationdataTest(String orgname,String industry) throws IOException
	{
		String randomOrg=orgname+jlib.getRandomNumber();	
		
		String BROWSER = plib.readDataFromPropertyFile("Browser");
		String URL = plib.readDataFromPropertyFile("Url");
		 String UN = plib.readDataFromPropertyFile("UserName");
		 String PWD = plib.readDataFromPropertyFile("Password");
		 
		 WebDriver driver=null;
		 
		 if(BROWSER.contains("chrome"))
		 {
			 driver=new ChromeDriver();
			 WebDriverManager.chromedriver().setup();
			 System.out.println("chrome lauched...");
		 }
		 else if(BROWSER.contains("edge"))
		 {
			 driver = new EdgeDriver();
			 WebDriverManager.edgedriver().setup();
			 System.out.println("edge lauched....");
		 }
		 else 
		 {
			 System.out.println("invalid browser..");
		 }
		 
		 wlib.maximiseWindow(driver);
		 wlib.waitForPageLoad(driver);
		 driver.get(URL);
		 
		 //login to application
		 
		 LoginPage lp = new LoginPage(driver);
		 lp.LoginToApp(UN, PWD);
		 
		 //home page click on organization link
		 
		 HomePage hp = new HomePage(driver);
		 hp.clickOnOrganizationlnk();
		 
		 //create orgnizatin lookup image(+)
		 
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookupImg();
		
		 //create new organization page and save
		
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createorgWithorgnameAndIndustryType(randomOrg, industry);
		
		 // validation of header text
		
		 OrgInformationPage ofp=new OrgInformationPage(driver);
		String orgheader = ofp.organizationHeader();
		 
		 if(orgheader.contains(orgname))
		 {		
			 System.out.println(orgname);
			 System.out.println("orgnization pass");
		 }
		 else
		 {
			 System.out.println("organization failed");
		 }
		 // logout to app
		 
		 hp.signoutOfapp(driver);
		 
	}	//use data provider for fetching multi test data
	
		@DataProvider(name = "multiorganization")
		public Object[][] getdata() throws EncryptedDocumentException, IOException
		{
		 Object[][] data = elib.readMultipleData("OrgnamewithIndustyType");
		return data;
		 
		}

	
}
