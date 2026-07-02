package tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.ConfigDataProvider;
import pages.CartPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SearchPage;
import utils.ScreenShot;

public class EndToEndTest extends BaseClass
{
    private LoginPage loginPage;
    private SearchPage searchPage;
    private CartPage cartPage;
    private LogoutPage logoutPage;
    private static final Logger logger = LoggerFactory.getLogger(EndToEndTest.class);

    @BeforeMethod
    public void setUp()
    {
        loginPage = new LoginPage();
        searchPage = new SearchPage();
        cartPage = new CartPage();
        logoutPage = new LogoutPage();
    }

    @Test
    public void loginAndSearch()
    {
        loginPage.login(
            ConfigDataProvider.getEmail(),
            ConfigDataProvider.getPassword());

        searchPage.search("Gift Card");
        cartPage.viewcart();
        
        String path = ScreenShot.takeScreenShot(driver);
        logger.info("Screenshot taken successfully: {}", path);
        
        logoutPage.logout();
        Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
        
        
    }
}