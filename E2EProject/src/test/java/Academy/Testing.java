package Academy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//OneDrive//Desktop//App//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//div[@role='combobox']/child::input[@type='text']")).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@role='combobox']/child::input[@type='text']")).sendKeys("ams");
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']"));
		int sizelist = options.size();
		for(int i=0; i<sizelist; i++)
		{
			if(i==0)
			{
				
				options.get(i).click();
			}
			
		}
		
		

	}

}
