package pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import pageElements.BooksPageElements;
import testbase.base;

public class BooksPage extends base
{
	 WebDriver driver;
	 BooksPageElements  bookpageElements;
	 
	 
	 public BooksPage(WebDriver driver)
	 {
		 this.driver=driver;
		 bookpageElements = new BooksPageElements(driver);
		 
	 }
	 
	 
	 public void clickFirstPrizeBookLink()
	 {
		 bookpageElements.firstPrizeBookLink.click();
		 test.log(LogStatus.PASS, "click first prize book link");
	 }
	 
	 public void clickSecondAddToCartBtn()
	 {
		 bookpageElements.addToCartBtn2.click();
		 test.log(LogStatus.PASS, "click second add to cart button");
	 }
}
