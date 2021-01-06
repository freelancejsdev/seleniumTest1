package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements 
{
	WebDriver driver;
	
	
	
	
	@FindBy(id="Email")
	public WebElement emailTxtBox;
	
	
	/*
	@FindBy(id="Password")
	public WebElement passwordTxtBox;
	*/
	
	@FindBy(id="ui")
	public WebElement passwordTxtBox;
	
	
	@FindBy(css="input.login-button")
	public WebElement loginBtn;
	
	

	
	
	
	
public LoginPageElements(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}


}
