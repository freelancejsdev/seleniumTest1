
package testbase;

import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import frameworkdata.ExtentManager;
import pages.BooksPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;



/**
 * @author Niharika
 *
 * 
 */



public class base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public HomePage homepage;
	public LoginPage loginpage;
	public RegisterPage registerpage;
	public BooksPage bookspage;
	
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	 private static Logger log = LogManager.getLogger(base.class.getName());
	public  SoftAssert softAssert = new SoftAssert();
// initialize driver
	public WebDriver initializeDriver() throws IOException{
		
		//data properties
		 prop = new Properties();
		 try{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/data.properties");
		prop.load(fs);
		}catch(Exception e){
		e.printStackTrace();
		 }
	
		
		String browserName = prop.getProperty("browser");
	
		if(browserName.equals("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("disable-infobars");
			
			//execute in chrome driver
		
			//System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		 test.log(LogStatus.PASS, "Chrome Browser");
		}
		else if(browserName.equals("firefox")){
			//execute in firefox driver
			
			//System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			
			driver=new FirefoxDriver();
			 test.log(LogStatus.PASS, "Firefox Browser");
		}
		else if(browserName.equals("IE")){
			//execute in ie
		//	System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver();
			 test.log(LogStatus.PASS, "IE Browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		registerpage = new RegisterPage(driver);
		bookspage = new BooksPage(driver);
	   
		return driver;
		
	}
	
	public void navigateToUrl(String url)
	{
		driver.navigate().to(url);
	}
	
	
	/******************Get url **********************************/
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	/**************wait to load**********************************/
	
		public void waitToLoad() throws InterruptedException{
			Thread.sleep(5000);
		}
	
	
	/********************Browser Navigation***********************/
	public static void navigate_forward(WebDriver driver) {
		driver.navigate().forward();
		}

		public static void navigate_back(WebDriver driver) {
		driver.navigate().back();
		}

		public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
		}

	
	

/*****************************Reporting********************************/

public void reportPass(String msg)
{
test.log(LogStatus.PASS, msg);
}

public  void reportFailure(String msg)
{
	test.log(LogStatus.FAIL, msg);
	takeScreenShot();
	Assert.fail(msg);
	
}



public  void takeScreenShot(){
	Date d=new Date();
	String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"/screenshots/"+screenshotFile));
		} 
	catch (IOException e) {
		
		e.printStackTrace();
	}
	test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/"+screenshotFile));
	
}


public void getScreenshot(String name) {
	// TODO Auto-generated method stub
	
}


/*************************Dropdown*********************************/

public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
	 	return value;
	}
	
	public void SelectUsingIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}
	
	public void SelectUsingVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}
	
	public void SelectByVisibleValue(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}
	

	
	
	/**************** validations **************/
	
	public void getPageTitle()
	{
		String title = driver.getTitle();
		test.log(LogStatus.PASS, title);
		
	}
}

	

