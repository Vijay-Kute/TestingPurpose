package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	
	
	By email = By.id("user_email");
    By pwd = By.id("user_password");
    By login=By.name("commit");
	
    public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
    
	public WebElement getemailId()
	{
		return driver.findElement(email);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
}
