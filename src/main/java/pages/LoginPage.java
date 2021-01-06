package pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;


import pageElements.LoginPageElements;
import testbase.base;

public class LoginPage extends base
{
  
	WebDriver driver;
	LoginPageElements loginpageElements;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		loginpageElements = new LoginPageElements(driver);
	}
	
	public void enterEmail()
	{
		loginpageElements.emailTxtBox.sendKeys("alex@test.com");
		reportFailure("incorrect locator");
		
	}
	
	public void enterPassword()
	{
		loginpageElements.passwordTxtBox.sendKeys("testing");
		
	}
	
	public void clickLogin()
	{
		loginpageElements.loginBtn.click();
	}
	
	public void loginToNopCommerce()
	{
		loginpageElements.emailTxtBox.sendKeys("alex@test.com");
		test.log(LogStatus.PASS, "Enter username");
		
		
		loginpageElements.passwordTxtBox.sendKeys("testing");
		test.log(LogStatus.PASS, "Enter password");
		
		loginpageElements.loginBtn.click();
		test.log(LogStatus.PASS, "click login");
	}
}
