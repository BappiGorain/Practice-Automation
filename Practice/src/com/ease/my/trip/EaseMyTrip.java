package com.ease.my.trip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EaseMyTrip
{
	private WebDriver driver;
	private ChromeOptions options;
	private static final Logger logger = LoggerFactory.getLogger(EaseMyTrip.class);
	
	@BeforeTest
	public void setUp()
	{
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.easemytrip.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test() throws Exception
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("eva_closeBtn"))).click();
//		logger.info("Eva Closed");
		
		Actions actions = new Actions(driver);
		
		WebElement loginOrSignup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login or Signup']")));
		
		actions.moveToElement(loginOrSignup).perform();
		logger.info("Hover to login button");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Customer Login']"))).click();
		logger.info("Click on Loggin button");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtEmail"))).sendKeys("Bappi");
		logger.info("Email send to the web page");
		
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
