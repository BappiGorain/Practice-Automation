package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XlsxDataProvider
{
	
	private static final Logger logger = LoggerFactory.getLogger(XlsxDataProvider.class);
	
	
	public XSSFSheet XlsxDataReader()
	{
		XSSFSheet sheet = null;
		try
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("Sheet1");
		}
		catch(IOException ex)
		{
			logger.error("Failed to read data from XLSX file : ",ex);
			
		}
		return sheet;
	}
}
