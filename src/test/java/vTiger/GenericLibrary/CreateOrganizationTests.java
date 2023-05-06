package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrganizationTests {
	public static void main(String[] args) throws IOException {
		
		// read data from property file
		FileInputStream fis =  new FileInputStream(".\\src\\test\\resources\\commonDataPropertiesFile");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("Browser");
		System.out.println(BROWSER);
		String URL = pobj.getProperty("Url");
		System.out.println(URL);
		String UN = pobj.getProperty("UserName");
		System.out.println(UN);
		String PWD = pobj.getProperty("Password");
		System.out.println(PWD);
		
		//read data frome Excel sheet
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("Organization");
		Row rw = sh.getRow(1);
		Cell ce = rw.getCell(2);
		String 	OrgName = ce.getStringCellValue();
		System.out.println(OrgName);
		
		// create a random number for avoiding duplicate value
		Random ran = new Random();
		int value = ran.nextInt(500);
		
		String ORG = OrgName+value;
		
		//lauch browser
	 WebDriver driver=null;
	 
	 if(BROWSER.equalsIgnoreCase("Chrome"))
	 {
		  driver = new ChromeDriver();
		  WebDriverManager.chromedriver().setup();
		  System.out.println("chrome launched........");
	 }
	 else if (BROWSER.equalsIgnoreCase("edge"))
	 {

		  driver = new EdgeDriver();
		  WebDriverManager.edgedriver().setup();
		  System.out.println(" edge launched........");
	 }
	 
	 else
	 {
		 System.out.println("invalid browser.....");
	 }
	 driver.get(URL);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
	 //login to app
	 
	 driver.findElement(By.name("user_name")).sendKeys(UN);
	 driver.findElement(By.name("user_password")).sendKeys(PWD);
	 driver.findElement(By.id("submitButton")).click();
	 
	 // navigate to organization
	 driver.findElement(By.linkText("Organizations")).click();
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	 // field mandatory fills
	 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORG);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
	}

}
