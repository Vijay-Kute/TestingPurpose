package Academy;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.RegistrationPage;
import resources.base;

public class RegistrationForm extends base {
	RegistrationPage regPage;
	
	@BeforeTest
	public void initiBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test(dataProvider="getData")
	public void InsertRegData(String username, String email, String password) {
		
	     
		 regPage = new RegistrationPage(driver);
		regPage.registrationLink().click();
		
		regPage.firstNameInput().sendKeys(username);
		regPage.EmailInput().sendKeys(email);
		regPage.passowrdInput().sendKeys(password);	
		
	}
	
	@Test(dataProvider="getData")
	public void inlineErrorCheck(String username, String email, String password) {
		
        regPage.registrationLink().click();
		
		regPage.firstNameInput().sendKeys(username);
		//regPage.EmailInput().sendKeys(email);
		regPage.passowrdInput().sendKeys(password);
		regPage.submitClick();
		
		String expected = regPage.inlineError().get("EmailError");
		String actual = regPage.errorInline();
		
		Assert.assertEquals(expected, actual);
		
		
	}
	
	

	

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][3];
		
		//1st credentials
		
		data[0][0] = "solidqa1@gmail.com";
		data[0][1] = "Test@123";
		data[0][2] = "940428";
		
		return data;
		
		
	}
}
