package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
   
	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 private By regLink = By.xpath("//span[text()='Register']");
	 private By firtsname = By.id("user_name");
	 private By email  = By.id("user_email");
	 private By password = By.xpath("//input[@id='password']");
	 private By submit = By.xpath("//input[@type='submit']");
	 private By errorText = By.xpath("//input[@id='user_email']/following-sibling::div[text()='This field is required']");
	 
	 public Map<String, String> inlineError() {
	 Map<String,String> map = new HashMap<String,String>();
     map.put("EmailError","This field is required");
     return map;
	 }
     
	 
	public WebElement registrationLink() {
		
		return driver.findElement(regLink);
	}
	
	public WebElement firstNameInput() {
		
		return driver.findElement(firtsname);
	}
	
	public WebElement EmailInput() {
		
		return driver.findElement(email);
	}
	
	public WebElement passowrdInput() {
		
		return driver.findElement(password);
	}
	
public void submitClick() {
		
		driver.findElement(submit).click();
	}

public String errorInline() {
   return driver.findElement(errorText).getText();
}

}
