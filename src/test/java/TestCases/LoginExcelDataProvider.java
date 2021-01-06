package TestCases;

import org.testng.annotations.Test;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelReader;

public class LoginExcelDataProvider
{
	public static ExcelReader excel = null;
	
	@Test(dataProvider="getData")
	public void testExcelData(Hashtable<String,String> data)
	{
		System.out.println(data.get("username") + " " + data.get("password"));
	}
	
	

	@Test(dataProvider="getData")
	public void login(Hashtable<String,String> data) throws InterruptedException
	{
		
		
		 WebDriver driver;
		    
		    driver =  new ChromeDriver();
		    
		    driver.navigate().to("https://demo.nopcommerce.com/");
		    
		    driver.manage().window().maximize();
		    
		    driver.findElement(By.linkText("Log in")).click();
		     
		   driver.navigate().refresh(); 
            
		    driver.findElement(By.id("Email")).sendKeys(data.get("username"));
		    driver.findElement(By.id("Password")).sendKeys(data.get("password"));
		    
		    driver.findElement(By.cssSelector("input.login-button")).click();
		    
		    Thread.sleep(2000);
		   // driver.findElement(By.linkText("Log out")).click();
		    
		    driver.close();
	}

	@DataProvider
	public Object[][] getData()
	{    
		
		if(excel==null)
		{
			excel = new ExcelReader("/Users/niharikasree/eclipse-workspace/Framework_TestNGWithPOM/src/test/java/testData/testdata.xlsx");
		}
		
		String sheetName = "test";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;
		
		for(int rowNum=2; rowNum<=rows; rowNum++)
		{
			table = new Hashtable<String,String>();
			
			for(int colNum=0; colNum<cols;colNum++)
			{
				table.put(excel.getCellData(sheetName,colNum,1),excel.getCellData(sheetName, colNum, rowNum));
				
				data[rowNum-2][0] = table;
			}
		}
		
		return data;
	
		
	}
	
}
