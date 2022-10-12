package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base {
	
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initiBrowser() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		log.info("Navigate to the Home page");
	}
	
	
	@Test
	public void checkTitle() throws IOException, InterruptedException
	{
		
		
		
		LandingPage l = new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1212");
		//log.info("Successfully validate text message");
		
		//System.out.println("Executed Validate Title class");
		
		
		
			
	}
	
	@AfterTest
	public void closeBrowser()
	{
		//System.out.println("Closed Validate Title class");
		driver.close();
	}
	
	
		

}
