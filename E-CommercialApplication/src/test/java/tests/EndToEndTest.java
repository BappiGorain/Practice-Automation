package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.ConfigDataProvider;
import dataprovider.XlsxDataProvider;
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
    private XlsxDataProvider xlsxDataProvider;
    private static final Logger logger = LoggerFactory.getLogger(EndToEndTest.class);

    @BeforeMethod
    public void setUp()
    {
        loginPage = new LoginPage();
        searchPage = new SearchPage();
        cartPage = new CartPage();
        logoutPage = new LogoutPage();
        xlsxDataProvider = new XlsxDataProvider();
    }

    @Test
    public void loginAndSearch()
    {
    	
    	XSSFSheet sheet = xlsxDataProvider.xlsxDataReader();
    	
//        loginPage.login(
//            ConfigDataProvider.getEmail(),
//            ConfigDataProvider.getPassword());
        
        loginPage.login(
        		sheet.getRow(1).getCell(1).getStringCellValue(),
        		sheet.getRow(1).getCell(2).getStringCellValue());

        searchPage.search("Gift Card");
        cartPage.viewcart();
        
        String path = ScreenShot.takeScreenShot(driver);
        logger.info("Screenshot taken successfully: {}", path);
        
        logoutPage.logout();

        
    }
}