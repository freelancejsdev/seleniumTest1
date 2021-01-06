package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.base;

public class BooksPageElements extends base
{
   WebDriver driver;
	
	@FindBy(linkText="First Prize Pies") 
	public WebElement firstPrizeBookLink;
	
	
	@FindBy(xpath="(//input[@value='Add to cart'])[2]")
	public WebElement addToCartBtn2;
	
	
public BooksPageElements(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
