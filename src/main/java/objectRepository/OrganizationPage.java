package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	
		@FindBy(linkText = "Organizations")
		private WebElement orglnk;

	   @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	   private WebElement createorgimg;
	   
	   public OrganizationPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
		 
	   }

	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getCreateorgimg() {
		return createorgimg;
	}	   
	   
	   //business library
	
	public void clickOnOrglink()
	{
		orglnk.click();
	}
	
	public void clickOnCreateOrgLookupImg()
	{
		createorgimg.click();
	}

}
