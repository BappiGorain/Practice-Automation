package extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent == null)
		{
			ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/extentReport.png");
			reporter.config().setReportName("Automation test results");
			reporter.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
}
