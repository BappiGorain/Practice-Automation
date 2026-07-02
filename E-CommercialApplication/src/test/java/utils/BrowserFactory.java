package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory
{
	public static WebDriver browserOptions(WebDriver driver, String browser,String url)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		
		driver.navigate().to(url);
		
		return driver;
	}
	
	
	public static void closeBrowser(WebDriver driver)
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
