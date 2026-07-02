package tests;

import org.testng.annotations.Test;

import dataprovider.XlsxDataProvider;

public class XlsxTest 
{
	@Test
	public void xlsxDataTest()
	{
		XlsxDataProvider dataProvider = new XlsxDataProvider();
		dataProvider.xlsxDataReader();
	}
}
