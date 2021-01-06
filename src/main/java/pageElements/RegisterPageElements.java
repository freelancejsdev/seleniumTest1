package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageElements 
{
	WebDriver driver;
	
	
	
	
	@FindBy(id="gender-female")
	public WebElement femaleRadioBtn;
	
	

	@FindBy(id="gender-male")
	public WebElement maleRadioBtn;
	

	@FindBy(id="FirstName")
	public WebElement firstNameTxtBox;
	
	
	@FindBy(id="LastName")
	public WebElement lastNameTxtBox;
	
	
	@FindBy(id="Email")
	public WebElement emailTxtBox;
	
	
	@FindBy(id="Password")
	public WebElement passwordTxtBox;
	
	
	@FindBy(id="ConfirmPassword")
	public WebElement confPasswordTxtBox;
	
	@FindBy(id="register-button")
	public WebElement registerBtn;
	
	//
	@FindBy(name="DateOfBirthDay")
	public WebElement dayDropDown;
	
	@FindBy(name="DateOfBirthMonth")
	public WebElement monthDropDown;
	
	@FindBy(name="DateOfBirthYear")
	public WebElement yearDropDown;
	
	
	
public RegisterPageElements(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}


}
