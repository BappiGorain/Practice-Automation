package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.WaitUtils;

public class LoginPage 
{
		
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	public void login(String email,String password)
	{
		WaitUtils.click(By.xpath("//a[normalize-space()='Log in']"));
		logger.info("Clicked on login button");
		
		WaitUtils.sendKeys(By.id("Email"), email);
		logger.info("send data on email input field");
		
		WaitUtils.sendKeys(By.id("Password"), password);
		logger.info("send data on password field");
		
		WaitUtils.click(By.xpath("//input[@value='Log in']"));
		logger.info("clicked on login button after entering data");
		
	}
}
