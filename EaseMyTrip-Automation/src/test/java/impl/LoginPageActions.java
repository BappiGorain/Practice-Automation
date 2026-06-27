package impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dataprovider.ConfigDataProvider;
import utils.WaitUtils;

public class LoginPageActions
{
	private static final Logger logger = LoggerFactory.getLogger(LoginPageActions.class);

	private WebDriver driver;
	private WaitUtils utils;
	
	public LoginPageActions(WebDriver driver)
	{
		this.driver = driver;
	    this.utils = new WaitUtils(driver);
	}
	
	public void loginEaseMyTrip()
	{
	
		Actions actions = new Actions(driver);
		actions.moveToElement(utils.waitForVisibility(By.xpath("//span[normalize-space()='Login or Signup']"))).perform();
		logger.info("Hover to login-signup button");
		
		utils.click(By.id("shwlogn"));
		logger.info("Clicked on Login Button");
		
		
		utils.sendKeys(By.id("txtEmail"), ConfigDataProvider.getUserName());
		logger.info("Email button clicked");
		
		utils.click(By.id("shwotp"));
		logger.info("Continue button clicked");
		
		utils.sendKeys(By.id("txtEmail2"), ConfigDataProvider.getPassword());
		logger.info("Password Enterd");
		
		utils.waitForClickable(By.name("btn_Login"));
		logger.info("Login button clicked");
		
		Assert.assertTrue(driver.findElement(By.id("userProfile")).isDisplayed());
		logger.info("User Logged-in Successfully");
	}
	
	
	
	
}
