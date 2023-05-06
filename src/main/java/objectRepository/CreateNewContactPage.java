package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {

	@FindBy(name = "lastname")
	private WebElement lastNmEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourceDropdown;
	
	@FindBy(xpath = "  //input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement organizationImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	public CreateNewContactPage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);	
	}

	
	public WebElement getLastNmEdt() {
		return lastNmEdt;
	}

	public WebElement getLeadsourceDropdown() {
		return leadsourceDropdown;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//bussiness library
	
	public void CreateNewContactwithlastname(String lastname)
	{
		lastNmEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void CreateNewContact(String lastname,String leadsourcevalue)
	{
		lastNmEdt.sendKeys(lastname);
		handleDropDown(leadsourceDropdown, leadsourcevalue);
		saveBtn.click();
	}
}
