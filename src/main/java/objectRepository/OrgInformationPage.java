package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInformationPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderTxt;
	
	public OrgInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderTxt() {
		return orgHeaderTxt;
	}
		
	//business library
	
	



	public String organizationHeader()
	{
		return orgHeaderTxt.getText();
	}
	
}
