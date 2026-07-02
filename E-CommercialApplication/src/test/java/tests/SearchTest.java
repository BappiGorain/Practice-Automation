package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class SearchTest extends BaseClass
{
	private SearchPage searchPage;
	
	@BeforeMethod
	public void setUp()
	{
		searchPage = new SearchPage();
	}
	
	
	@Test
	public void searchTest()
	{
		searchPage.search("Gift Card");
	}
}
