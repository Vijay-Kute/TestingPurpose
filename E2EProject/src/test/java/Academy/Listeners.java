package Academy;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import resources.ExtentReporterNG;

public class Listeners extends base implements ITestListener{
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test; 

	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName()); 
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
	
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		String testmethodName = result.getMethod().getMethodName();
		//System.out.println(testmethodName);
		
	
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
						e1.printStackTrace();
		} 
	
		
	    try {
	    	extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodName, driver), testmethodName);
			//getScreenshotPath(testmethodName, driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	

}
