package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements 
{
	
	WebDriver driver;
	
	@FindBy(linkText="Register")
     public WebElement registerLink;
	
	@FindBy(linkText="Log in")
    public WebElement loginLink;
	
	
	@FindBy(id="small-searchterms")
    public WebElement searchTxtBox;
	
	
	@FindBy(css="input.search-box-button")
    public WebElement searchBtn;
	
	//
	@FindBy(linkText="Books")
    public WebElement BooksLink;
	
	public HomePageElements(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
