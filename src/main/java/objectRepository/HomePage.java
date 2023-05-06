package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary
{
	@FindBy(linkText = "Leads")
	private WebElement leadlnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement orglnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText = "Products")
	private WebElement productlnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorTag;
	
    @FindBy(linkText = "Sign Out")
	private WebElement signoutlnk;
	
	// initiate element via constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// accessing element via getter
	public WebElement getLeadlnk() {
		return leadlnk;
	}

	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getProductlnk() {
		return productlnk;
	}

	public WebElement getAdministratorTag() {
		return administratorTag;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	
	//bussiness libraray
	
	public void clickOnLeadlnk()
	{
		leadlnk.click();
	}
	
	public void clickOnOrganizationlnk()
	{
		orglnk.click();
	}
	
	public void clinkOncontactlnk()
	{
		contactlnk.click();
	}
	
	public void clinkOnproductlnk()
	{
		productlnk.click();
	}
	
	public void signoutOfapp(WebDriver driver)
	{
		handleMouseHover(driver, administratorTag);
		signoutlnk.click();
		
		
	}
	
	

}
