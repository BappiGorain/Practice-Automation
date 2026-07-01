package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigDataProvider;

public class WaitUtils 
{
	private WebDriverWait wait;
	public WaitUtils(WebDriver driver)
	{
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigDataProvider.getTimeOut())));
	}
	
	
	
	public void click(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void sendKeys(By locator, String data)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(data);
	}
	
	
	
}
