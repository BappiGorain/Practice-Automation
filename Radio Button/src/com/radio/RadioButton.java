package com.radio;


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

public class RadioButton 
{
	private WebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	
	
	@BeforeTest
	public void setUp()
	{
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");		
	}
	
	
	
	@Test
	public void test()
	{
		WebElement maleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("male")));
		maleRadioButton.click();
		
		if(maleRadioButton.isSelected())
		{
			System.out.println("Male Radio button is selected : ");
		}
		
		List<WebElement> genderRadioButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("gender")));		
		
		
		for(WebElement element : genderRadioButtons)
		{
			System.out.println(element.getAttribute("value"));
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
