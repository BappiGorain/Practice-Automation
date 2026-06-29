package com.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown
{
	private WebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	
	@BeforeTest
	public void setUp()
	{
		options = new ChromeOptions();
		options.addArguments("disable-notifications");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");		
	}
	
	
	@Test
	public void test()
	{
		WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		Select countryList = new Select(countryDropdown);
		List<WebElement> allOptions = countryList.getOptions();
		int totalCountry = allOptions.size();
		for(int i=0;i<totalCountry;i++)
		{
			System.out.println(allOptions.get(i).getText());
		}
	}
	
	
	@AfterTest
	public void tearDown()
	{
		if(driver != null)
		{
			driver.close();
		}
	}
	
	
}
