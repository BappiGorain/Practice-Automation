package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import dataProvider.ConfigDataProvider;
import extent.ExtentManager;
import utils.Browsers;
import utils.ScreenShot;

public class BaseClass
{

	protected WebDriver driver;
	
	private ConfigDataProvider configDataProvider;
	
	private ExtentReports extent;
	private ExtentTest test;
	
	@BeforeSuite
	public void setUp()
	{
		configDataProvider = new ConfigDataProvider();
		extent = ExtentManager.getInstance();
	}
	
	@BeforeClass
	public void test()
	{
		
		test = extent.createTest("Login Test...");
		
		 driver = Browsers.browserOptions(driver,ConfigDataProvider.getBrowser(), ConfigDataProvider.getUrl());
		
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
		Browsers.closeBrowser(driver);
		extent.flush();
	}
}
