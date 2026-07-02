package base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import dataprovider.ConfigDataProvider;
import reports.ExtentManager;
import utils.BrowserFactory;
import utils.ScreenShot;
import utils.WaitUtils;

public class BaseClass
{
	protected WebDriver driver;
	
	private ConfigDataProvider configDataProvider;
	
	private ExtentReports extent;
	private ExtentTest test;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
	
	@BeforeSuite
	public void setUp()
	{
		logger.info("Before Suite executed");
		
		configDataProvider = new ConfigDataProvider();
		
	}
	
	@BeforeClass
	public void test()
	{
		extent = ExtentManager.getInstance();
		
	    test = extent.createTest("Login Test...");

	    driver = BrowserFactory.browserOptions(
	            driver,
	            ConfigDataProvider.getBrowser(),
	            ConfigDataProvider.getUrl());

	    new WaitUtils(driver);   // Important

	    test.info("Browser Launched Successfully");
	}

	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.fail("Test Failed : " + result.getThrowable());
			String path = ScreenShot.takeScreenShot(driver);
			test.addScreenCaptureFromPath(path);
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.pass("Test Passed");
		}
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		extent.flush();
	}
}
