package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(name = "user_name")
private WebElement userNameEdt;

@FindBy(name = "user_password")
private WebElement userPasswordEdt;

@FindAll({@FindBy(xpath = "//input[@type='submit']"),@FindBy(id = "submitButton")})
private WebElement loginBtn;

// create constructor for element initialization
public LoginPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}
//access the getter for element

public WebElement getUserNameEdt() {
	return userNameEdt;
}

public WebElement getUserPasswordEdt() {
	return userPasswordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

// create reason for busseness library is optimise the code

public void LoginToApp(String username,String password)
{
	userNameEdt.sendKeys(username);
	userPasswordEdt.sendKeys(password);
	loginBtn.click();
}





}
