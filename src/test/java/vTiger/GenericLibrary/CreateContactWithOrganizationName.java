package vTiger.GenericLibrary;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationName {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		PropertyFileLibrary plib= new PropertyFileLibrary();
		ExcelFileLibrary elib= new ExcelFileLibrary();
		JavaLibrary jlib = new JavaLibrary();
		WebDriverLibrary wlib = new WebDriverLibrary();
		
		String BROWSER = plib.readDataFromPropertyFile("Browser");
		String URL = plib.readDataFromPropertyFile("Url");
		String UN = plib.readDataFromPropertyFile("UserName");
		String PWD = plib.readDataFromPropertyFile("Password");
		
		String LASTNAME = elib.readDataFromExcelSheet("Contact", 5, 2)+jlib.getRandomNumber();
		String ORGNAME = elib.readDataFromExcelSheet("Contact", 5, 3)+jlib.getRandomNumber();
	
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chrome launched...");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge launched...");
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wlib.maximiseWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		
		 
		 driver.findElement(By.name("user_name")).sendKeys(UN);
		 driver.findElement(By.name("user_password")).sendKeys(PWD);
		 driver.findElement(By.id("submitButton")).click();
		 //navigate to organization
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 //validation
		 String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 System.out.println(orgHeader);
		 if(orgHeader.contains(ORGNAME))
		 {
			 System.out.println("organization pass");
		 }
		 else
		 {
			 System.out.println("organization fail");
			 //wlib.takeScreenShot(driver,"CreateContactWithOrganizationName");
		 }
		 
		
		 
		 //navigate to contact page
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		 driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		  wlib.switchToWindow(driver,"Accounts");
		 driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText(ORGNAME)).click();
		 wlib.switchToWindow(driver,"Contacts");
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 //contac page header
		 String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 System.out.println(contactHeader);
		 
		 if(contactHeader.contains(LASTNAME))
		 {
			 System.out.println("contact passed");
		 }
		 else
		 {
			 System.out.println("contact failed");
			// wlib.takeScreenShot(driver, "CreateContactWithOrganizationName");
		 }
		 
	WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wlib.handleMouseHover(driver, adminImg);
		 driver.findElement(By.linkText("Sign Out")).click();
		// wlib.takeScreenShot(driver,"CreateContactWithOrganizationName"); 
		 
	        
	}

}
