package resources;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporterNG {

	 public static ExtentReports extent;
	

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Web Automation");
		
		 extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 
		 extent.setSystemInfo("Tester", "Vijay Kute");
		 
		 return extent;
	}
}
