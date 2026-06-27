package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import dataprovider.ConfigDataProvider;
import impl.LoginPageActions;
import screenshot.ScreenShot;
import utils.BrowserFactory;

public class BaseClass
{
	private WebDriver driver;
	
	private ChromeOptions options;
		
	private LoginPageActions loginPageActions;
	
	private ScreenShot screenShot = new ScreenShot();
	
	private Logger logger = LoggerFactory.getLogger(BaseClass.class);
		
	
	
	@BeforeSuite
	public void setUp()
	{
		options = new ChromeOptions();
		options.addArguments("disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigDataProvider.getTimeOut()));
		loginPageActions = new LoginPageActions(driver);
	}
	
	@BeforeClass
	public void test()
	{
		loginPageActions.loginEaseMyTrip();
	}
	
	@AfterClass
	public void quitBrowser()
	{
		BrowserFactory.closeBrowser(driver);
	}
	
	@AfterMethod
	public void takesScreenShotOnFaliure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			screenShot.takeScreenshot(driver);
			logger.info("Error found during Automation ");
			
			
		}
	}
}
