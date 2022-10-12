package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base {
	
	private static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());
	
	
	@BeforeTest
	public void initiBrowser() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver initialized");
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void navigationBarCheck() throws IOException, InterruptedException
	{
		
		
		LandingPage l = new LandingPage(driver);
		
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");
	//	System.out.println("Executed Validate Navigation Bar class");		
			
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		//System.out.println("Closed Validate Navigation Bar class");
		driver.close();
	}
	
	
	
		

}
