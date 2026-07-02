package tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.ConfigDataProvider;
import pages.LoginPage;

public class LoginPageTest extends BaseClass
{
	
private static final Logger logger = LoggerFactory.getLogger(LoginPageTest.class);
	
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage()
    {
        loginPage = new LoginPage();
    }

    @Test
    public void validLogin()
    {
        loginPage.login(ConfigDataProvider.getEmail(),
                        ConfigDataProvider.getPassword());
        logger.info("valid login method executed");
        
        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

    }
    
    

}
