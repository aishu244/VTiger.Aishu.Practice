package vTiger.GenericLibrary;
/**
 * this is a generic class which consists of all basic configuration annotations
 * @author HP
 *
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public PropertyFileLibrary plib=new PropertyFileLibrary();
	public ExcelFileLibrary elib = new ExcelFileLibrary();
	public WebDriverLibrary wlib = new WebDriverLibrary();
	public JavaLibrary jlib = new JavaLibrary();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	
	@BeforeSuite(groups ={"smokeSuite","regressionsuite"})
	public void beforesuiteConfig()
	{
		System.out.println("databse connected successfully");
	}
	//@Parameters("browser")
	@BeforeClass(groups ={"smokeSuite","regressionsuite"})
	public void beforeclass(/*String BROWSER*/) throws IOException
	{
	    String BROWSER = plib.readDataFromPropertyFile("Browser");
		String URL = plib.readDataFromPropertyFile("Url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chorme lauched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge launched successfully");
		}
		else
		{
			System.out.println("invalid browser...");
		}
		
		sdriver=driver;
		
		wlib.maximiseWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups ={"smokeSuite","regressionsuite"})
	public void beforemethodConfig() throws IOException
	{
		String UN = plib.readDataFromPropertyFile("UserName");
		String PWD = plib.readDataFromPropertyFile("Password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(UN, PWD);
		
		System.out.println("login successfully...");
	}
	
	@AfterMethod(groups ={"smokeSuite","regressionsuite"})
	public void aftermethodConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.signoutOfapp(driver);
		
		System.out.println("sign out application successfully...");
	}
	
	@AfterClass(groups ={"smokeSuite","regressionsuite"})
	public void afterclassConfig()
	{
		driver.quit();
		System.out.println("browser closed successfully...");
	}
	
	
	@AfterSuite(groups ={"smokeSuite","regressionsuite"})
	public void aftersuiteConfig()
	{
		System.out.println("database closed successfully");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
