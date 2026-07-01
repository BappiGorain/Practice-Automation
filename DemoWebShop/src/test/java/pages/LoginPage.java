package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.WaitUtils;

public class LoginPage 
{
	private final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private WaitUtils waitUtils;
	
	public LoginPage(WebDriver driver)
	{
		waitUtils = new WaitUtils(driver);
	}
	
	
	
	public void login(String email, String password)
	{
		waitUtils.click(By.xpath("//a[normalize-space()='Log in']"));
		logger.info("Redirected to login page");
		
		waitUtils.sendKeys(By.id("Email"), email);
		logger.info("Email entered on email field");
		
		waitUtils.sendKeys(By.id("Password"), password);
		logger.info("Password enter on password field");
		
		waitUtils.click(By.xpath("//input[@value='Log in']"));
		logger.info("Login button clicked");
		
	}
	
	
	
	
}
