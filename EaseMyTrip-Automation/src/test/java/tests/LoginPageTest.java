package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import dataprovider.ConfigDataProvider;
import impl.LoginPageActions;
import utils.BrowserFactory;

public class LoginPageTest 
{
	static WebDriver driver;
	private LoginPageActions loginPageActions;
	
	@Test
	public void loginEaseMyTrip()
	{
		driver = BrowserFactory.browserOption(ConfigDataProvider.getBrowserName(), ConfigDataProvider.getAppURL());
		loginPageActions = new LoginPageActions(driver);
		loginPageActions.loginEaseMyTrip();
		BrowserFactory.closeBrowser(driver);
	}
}
