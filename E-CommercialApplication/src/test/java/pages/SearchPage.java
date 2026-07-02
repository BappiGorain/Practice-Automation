	package pages;
	
	import org.openqa.selenium.By;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	
	import utils.WaitUtils;
	
	public class SearchPage
	{
		
		private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);
		
		public void search(String keywords)
		{
			WaitUtils.click(By.id("small-searchterms"));
			logger.info("Click on search field");
			
			WaitUtils.sendKeys(By.id("small-searchterms"), keywords);
			logger.info("send data on Search field");
			
			WaitUtils.click(By.xpath("//input[@class='button-1 search-box-button']"));
			logger.info("Click on search button");
			
			
			WaitUtils.click(By.xpath("//div[@class='product-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]"));
			logger.info("click on add to cart button");
			
			WaitUtils.sendKeys(By.id("giftcard_4_RecipientName"),"user");
			logger.info("Recipient's Name entered");
			
			
			WaitUtils.click(By.id("add-to-cart-button-4"));
			logger.info("click on add to cart button again");
			
		}
	}
