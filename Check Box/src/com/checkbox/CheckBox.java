package com.checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox
{
	
	private WebDriver driver;
	private ChromeOptions options;
	private WebDriverWait wait;
	 
	
	@BeforeTest
	public void setUp()
	{
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	}
	
	
	@Test
	public void test()
	{
		List<WebElement> allCheckBoxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='form-group']//input[@type='checkbox']")));
		
		for(WebElement element : allCheckBoxes)
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if(element.isSelected())
			{
				System.out.println(element.getAttribute("value") + " : is Selected");
			}
		}
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
