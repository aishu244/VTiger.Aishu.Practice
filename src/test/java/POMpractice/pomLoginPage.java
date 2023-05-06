package POMpractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class pomLoginPage {

	public static void main(String[] args) throws IOException {
			
	    WebDriverLibrary wlib=new WebDriverLibrary();
	    PropertyFileLibrary plib = new PropertyFileLibrary();
	    String BROWSER = plib.readDataFromPropertyFile("Browser");
	    String URL = plib.readDataFromPropertyFile("Url");
	    String UN = plib.readDataFromPropertyFile("UserName");
	    String PWD = plib.readDataFromPropertyFile("Password");
	    WebDriver driver=null;
	    {
	    	if(BROWSER.equalsIgnoreCase("chrome"))
	    	{
	    		WebDriverManager.chromedriver().setup();
	    	    driver = new ChromeDriver();
	    		System.out.println("chrome launched");
	    	}
	    	else if(BROWSER.equalsIgnoreCase("edge"))
	    	{
	    		WebDriverManager.edgedriver().setup();
	    		driver = new EdgeDriver();
	    		System.out.println("edge launched");
	    	}
	    	else
	    	{
	    		System.out.println("invalid browser...");
	    	}
	    }
	   
	    wlib.maximiseWindow(driver);
	    wlib.waitForPageLoad(driver);
	    driver.get(URL);
	    
	    LoginPage lp = new LoginPage(driver);
	   // lp.getUserNameEdt().sendKeys(UN);
	    //lp.getUserPasswordEdt().sendKeys(PWD);
	   // lp.getLoginBtn().click();
	    lp.LoginToApp(UN, PWD);
	}
}
