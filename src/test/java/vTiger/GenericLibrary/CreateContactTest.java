package vTiger.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;

public class CreateContactTest extends BaseClass
{
@Test
public void CreateContactT() throws IOException
{
String LASTNAME = elib.readDataFromExcelSheet("Contact", 1, 2)+jlib.getRandomNumber();
	
	 HomePage hp = new HomePage(driver);
	 hp.clinkOncontactlnk();
	 
	 ContactPage cp = new ContactPage(driver);
	 cp.clickonTocreateContactImg();
	 
	 CreateNewContactPage ccp = new CreateNewContactPage(driver);
	 ccp.CreateNewContactwithlastname(LASTNAME);	 
	 
	 //validation
	 
	 String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 System.out.println(contactHeader);
	 
	 if(contactHeader.contains(LASTNAME))
	 {
		 System.out.println("pass");
	 }
	 else
	 {
		 System.out.println("fail");
	 }
	
} 
	
}

