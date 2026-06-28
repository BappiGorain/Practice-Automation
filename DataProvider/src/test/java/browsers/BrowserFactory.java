package browsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import DataProvider.ConfigDataProvider;

public class BrowserFactory
{
	static WebDriver driver = null;
	public static WebDriver browserOptions(String browser, String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigDataProvider.getTimeOut())));
		driver.manage().window().maximize();
		driver.navigate().to(url);
		return driver;
	}
	
	public void closeBrowser()
	{
		if(driver != null)
		{
			driver.close();
		}
	}
	
}
