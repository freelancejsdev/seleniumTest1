package pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;


import pageElements.LoginPageElements;
import pageElements.RegisterPageElements;
import testbase.base;

public class RegisterPage extends base
{
  
	WebDriver driver;
	RegisterPageElements registerpageElements;
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		registerpageElements = new RegisterPageElements(driver);
	}
	
	
	public void enterFirstName()
	{
		registerpageElements.firstNameTxtBox.sendKeys(prop.getProperty("firstname"));
		test.log(LogStatus.PASS, "Enter Firstname as " + prop.getProperty("firstname"));
	}
	
	public void enterLastName()
	{
		registerpageElements.lastNameTxtBox.sendKeys(prop.getProperty("lastname"));
		test.log(LogStatus.PASS, "Enter Lastname as " + prop.getProperty("lastname"));
	}
	
	public void enterEmail()
	{
		registerpageElements.emailTxtBox.sendKeys(prop.getProperty("email"));
		test.log(LogStatus.PASS, "Enter email as " + prop.getProperty("email"));
	}
	
	public void enterPassword()
	{
		registerpageElements.passwordTxtBox.sendKeys(prop.getProperty("password"));
		test.log(LogStatus.PASS, "Enter Password as " + prop.getProperty("password"));
	}
	
	public void enterConfPassword()
	{
		registerpageElements.confPasswordTxtBox.sendKeys(prop.getProperty("password"));
		test.log(LogStatus.PASS, "Enter Password as " + prop.getProperty("password"));
	}
	
	public void clickRegisterBtn()
	{
		registerpageElements.registerBtn.click();
		test.log(LogStatus.PASS, "Click Register Button");
	}
	
	public void clickMaleRadioBtn()
	{
		registerpageElements.maleRadioBtn.click();
		test.log(LogStatus.PASS, "Click Male Radio Button");
	}
	
	public void clickFemaleRadioBtn()
	{
		registerpageElements.femaleRadioBtn.click();
		test.log(LogStatus.PASS, "Click Female Radio Button");
	}
	
	public void selectDay()
	{
		SelectUsingIndex(registerpageElements.dayDropDown,4);
		test.log(LogStatus.PASS, "Select day");
	}
	
	public void selectMonth()
	{
		SelectUsingVisibleText(registerpageElements.yearDropDown,"June");
		test.log(LogStatus.PASS, "Select month");
	}
	
	public void selectYear()
	{
		SelectByVisibleValue(registerpageElements.yearDropDown,"1999");
		test.log(LogStatus.PASS, "Select year");
	}
}
