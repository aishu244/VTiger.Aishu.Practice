package aishu.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactForDDT {
	public static void main(String[] args) throws IOException {
		//load the file into java stream
		FileInputStream fs =new FileInputStream(".\\src\\test\\resources\\commonDataPropertiesFile");
		//create object of property file
		Properties pobj = new Properties();
		// load data fileinput to property file
		pobj.load(fs);
		// use key and read the value
		String BROWSER = pobj.getProperty("Browser");
		System.out.println(BROWSER);
		String URL = pobj.getProperty("Url");
		System.out.println(URL);
		String USERNAME = pobj.getProperty("UserName");
		System.out.println(USERNAME);
		String PASSWORD = pobj.getProperty("Password");
		System.out.println(PASSWORD);
		
		// read data frome excelsheet
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Contact");
  		Row   rw = sh.getRow(1);
		Cell ce = rw.getCell(2);
		String LasstName = ce.getStringCellValue();
		System.out.println(LasstName);
		
	// lauch the browser
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			System.out.println("chrome launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
			System.out.println("edge launched");
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//login to the application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		// navigate to contact page
		driver.findElement(By.linkText("Contacts")).click();
		
		// create contact and fill mandatory field 
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LasstName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// click on sign out button
		
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions action = new Actions(driver);
		 action.moveToElement(ele).perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
	}

	
	}

	
      
	    

