package tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.ConfigDataProvider;
import pages.LoginPage;

public class LoginPageTest extends BaseClass
{	
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginPageTest.class);
	
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage()
    {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void Login()
    {
        loginPage.login(ConfigDataProvider.getValidEmail(),
                        ConfigDataProvider.getValidPassword());
        logger.info("valid login method executed");
        
        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
        
        

    }

    @Test
    public void invalidLogin()
    {
        loginPage.login(ConfigDataProvider.getInValidEmail(),
                        ConfigDataProvider.getInValidPassword());
        
        Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());

        logger.info("invalid login method executed");
    }
}