package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;

import browser.BrowserFactory;
import loginPageActions.LoginPage;
import reports.ExtentManager;
import screenshot.ScreenShot;

public class Test 
{
    private WebDriver driver;
    private LoginPage page;

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setupReport()
    {
        extent = ExtentManager.getInstance();
    }

    @org.testng.annotations.Test
    public void test()
    {
        test = extent.createTest("Login Test");

        driver = BrowserFactory.browserOptions("chrome", "https://practicetestautomation.com/practice-test-login/");
        
        page = new LoginPage();
        
        test.info("Browser launched");

        page.loginPage(driver);

        test.pass("Login action performed successfully");
    }

    @AfterMethod
    public void captureResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.fail("Test failed: " + result.getThrowable());

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
        BrowserFactory.closeBrowser();
        extent.flush(); // ✅ VERY IMPORTANT  
    }
}