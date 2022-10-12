package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	
	@BeforeTest
	public void initiBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	
	
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String uname, String password) throws IOException, InterruptedException
	{
		
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);
		
		
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		//System.out.println(lp.getemailId().isEnabled());
	
		lp.getemailId().sendKeys(uname);
		lp.getpassword().sendKeys(password);
		//Thread.sleep(2000);
		lp.getlogin().click();
		//System.out.println("Executed Home Page class");
		
			
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		//1st credentials
		
		data[0][0] = "solidqa1@gmail.com";
		data[0][1] = "Test@123";
		data[0][2] = "940428";
		
	//2nd credentials
		data[1][0] = "solidqa2@gmail.com";
		data[1][1] = "Test@123";
		
		
		return data;
		
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
	//	System.out.println("Closed Home Page class");
		driver.close();
	}
	
	

}
