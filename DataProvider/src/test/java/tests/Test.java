package tests;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import DataProvider.ConfigDataProvider;
import DataProvider.XlsxDataProvider;
import browsers.BrowserFactory;

public class Test
{
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	private XlsxDataProvider xlsxDataProvider;
	private WebDriver driver = null;
	
	
	
	
	@org.testng.annotations.Test(dataProvider = "logginData")
	public void test(String username, String password)
	{
		driver = BrowserFactory.browserOptions(ConfigDataProvider.getBrowser(), ConfigDataProvider.getUrl());
		logger.info("Executing test with: " + username + " / " + password);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigDataProvider.getTimeOut())));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
		
		
	}
	
	@DataProvider(name="logginData")
	public Object[][] dataProvider()
	{
		xlsxDataProvider = new XlsxDataProvider();
		
		XSSFSheet sheet = xlsxDataProvider.XlsxDataReader();
		int rowCount = sheet.getLastRowNum() + 1;
		
		Object[][] obj = new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++)
		{
			if(sheet.getRow(i) != null) 
			{
				String userName = sheet.getRow(i).getCell(0).getStringCellValue();
				String password = sheet.getRow(i).getCell(1).getStringCellValue();
				obj[i][0] = userName;
				obj[i][1] = password;
			}
		}	
		return obj;
	}
}