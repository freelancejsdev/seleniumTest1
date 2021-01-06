package pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;


import pageElements.HomePageElements;
import testbase.base;

public class HomePage extends base
{
	
	WebDriver driver;
	HomePageElements homepageElements;
	
	
public HomePage(WebDriver driver)
{
	this.driver = driver;
	homepageElements = new HomePageElements(driver);
}


public void enterSearchText()
{
	homepageElements.searchTxtBox.sendKeys(prop.getProperty("searchitem"));
	test.log(LogStatus.PASS, "Enter Search Text");
}


public void clickSearchButton()
{
	homepageElements.searchBtn.click();
	test.log(LogStatus.PASS, "click serach button");
}

public void clickLoginLink()
{
	homepageElements.loginLink.click();
	test.log(LogStatus.PASS, "click login link");
}

public void clickRegisterLink()
{
	homepageElements.registerLink.click();
	test.log(LogStatus.PASS, "click Register link");
}

public void clickBooksLink()
{
	homepageElements.BooksLink.click();
	test.log(LogStatus.PASS, "click Books link");
	
}
}
