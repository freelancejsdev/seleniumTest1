/**
 * 
 */
package TestCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;


import testbase.base;

/**
 * @author Niharika
 *
 * 
 */
public class Login extends base
   {
	
	SoftAssert softAssert = new SoftAssert();
	private static Logger log = LogManager.getLogger(Login .class.getName());
   
	
	 @BeforeTest
		public void driverinitialize() throws IOException
	       {
			test = rep.startTest("Login");
			test.log(LogStatus.INFO, "starting Login Test");
			initializeDriver();
			}
	 
	 @Test
		public void LoginTest() throws IOException, InterruptedException 
	    {
		 
		 try{
				
			 driver.navigate().to(prop.getProperty("url"));
				test.log(LogStatus.PASS, "opened url");
				
				
				
				homepage.clickLoginLink();
				
				takeScreenShot();
				
				
				
				loginpage.loginToNopCommerce();
				
				
				
					}catch(Exception e){
					    e.printStackTrace();
						test.log(LogStatus.FAIL, new RuntimeException(e));
						reportFailure(e.getMessage());
					}
					
					
		     }
			
			
	 @AfterTest
		public void closeBrowser()
	    {
			driver.close();
			driver = null; 
			rep.endTest(test);
			rep.flush();
		}

}


