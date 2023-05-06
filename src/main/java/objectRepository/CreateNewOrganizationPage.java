package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary{
	@FindBy(name = "accountname")
	private WebElement orgname;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	
	//bussiness library
	public void createOrgwithorgname(String orgnm)
	{
		orgname.sendKeys(orgnm);
		saveBtn.click();
	}
	
	public void createorgWithorgnameAndIndustryType(String orgnm,String industryvalue)
	{
		orgname.sendKeys(orgnm);
		handleDropDown(industryvalue, industryDropDown);
		saveBtn.click();
	}
	
	

}
