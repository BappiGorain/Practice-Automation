package loginPageActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	private WebDriverWait wait;
	public void loginPage(WebDriver driver)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("student");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("Password123");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
		
	}
}
