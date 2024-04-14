package POMpractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class POMcontactTests 
{

	public static void main(String[] args) throws IOException
	{
		PropertyFileLibrary plib=new PropertyFileLibrary();
		ExcelFileLibrary elib=new ExcelFileLibrary();
		JavaLibrary jlib = new JavaLibrary();
		WebDriverLibrary wlib=new WebDriverLibrary();
		
		String BROWSER = plib.readDataFromPropertyFile("Browser");
		String URL = plib.readDataFromPropertyFile("Url");
		String UN = plib.readDataFromPropertyFile("UserName");
		String PWD = plib.readDataFromPropertyFile("Password");
		String LASTNAME = elib.readDataFromExcelSheet("Contact", 1, 2)+jlib.getRandomNumber();
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			System.out.println("chrome launched...");
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			System.out.println("edge launched...");
			
		}
		else
		{
			System.out.println("invalid browser..");
		}
		
		wlib.maximiseWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		//login to app
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(PWD, UN);
		
		
		//navigate to conatact page
		HomePage hom = new HomePage(driver);
		hom.clinkOncontactlnk();
		//create contact 
		ContactPage cp = new ContactPage(driver);
		cp.clickonTocreateContactImg();
		//create new contact page
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.CreateNewContactwithlastname(LASTNAME);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.HeaderTxt();
		System.out.println(contactHeader);
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("pass");
		}
		
		else
		{
			System.out.println("fail");
			 
		}
		//logout application
	
		//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); 
		// wlib.handleMouseHover(driver, ele);
		// driver.findElement(By.linkText("Sign Out")).click();
		
		hom.signoutOfapp(driver);
		
		
		
		
		
		
		
		
		
	}

}
