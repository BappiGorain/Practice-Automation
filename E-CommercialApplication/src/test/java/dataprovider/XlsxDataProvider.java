package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XlsxDataProvider
{
	private static final Logger logger = LoggerFactory.getLogger(XlsxDataProvider.class);
	
	public XSSFSheet xlsxDataReader()
	{
		XSSFSheet sheet = null;
		try
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("Sheet1");
			
			logger.info("Successfully read xlsx data");
			
			String url = sheet.getRow(1).getCell(0).getStringCellValue();
			String email = sheet.getRow(1).getCell(1).getStringCellValue();
			String password = sheet.getRow(1).getCell(2).getStringCellValue();
			
			
			
		} 
		catch (IOException e) 
		{
			logger.error("Failed to read data from Xlsx file",e);
		}
		return sheet;
	}
}
