package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.WaitUtils;

public class CartPage 
{
	private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
	
	public void viewcart()
	{
		WaitUtils.click(By.xpath("//span[normalize-space()='Shopping cart']"));
		logger.info("clicked on shipping cart");
		
		WaitUtils.click(By.id("termsofservice"));
		logger.info("Clicked on terms of service checkbox");
		
		WaitUtils.click(By.id("checkout"));
		logger.info("Clicked on checked-out button");
		
		WaitUtils.click(By.xpath("//input[@onclick='Billing.save()']"));
		logger.info("Clicked on continue button 1");
		
		WaitUtils.click(By.id("PickUpInStore"));
		logger.info("Clicked on pickUp in store checkbox");
		
		
		WaitUtils.click(By.xpath("//input[@onclick='Shipping.save()']"));
		logger.info("Clicked on continue button 2");
		
		WaitUtils.click(By.id("paymentmethod_0"));
		logger.info("Click on cash on delivery radio button");
		
		WaitUtils.click(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
		logger.info("click on continue button 3");
		
		WaitUtils.click(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
		logger.info("click on continue button 4");
		
		WaitUtils.click(By.xpath("//input[@value='Confirm']"));
		logger.info("clicked on confirm button");
		
		
	}
}
