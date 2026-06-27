package scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scroll 
{
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void scroll() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,2000)");
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}










