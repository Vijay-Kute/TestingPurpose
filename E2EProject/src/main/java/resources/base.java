package resources;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;



public class base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream ("C:\\Users\\Admin\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("Chrome"))
		{
			//Initialize driver for Chrome
			System.setProperty("webdriver.chrome.driver", "C://Users//Admin//OneDrive//Desktop//App//chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		else if (browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\OneDrive\\Desktop\\App\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}
		
		else if (browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\OneDrive\\Desktop\\App\\msedgedriver.exe");
			
			driver = new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
		
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		//TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		//File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	
	}

}
