package xlsx;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XlsxDataProvider 
{
	private static final Logger logger = LoggerFactory.getLogger(XlsxDataProvider.class);
	public void xlsxDataReader() 
	{
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			logger.info("Data read from XLSX File");
			
			
			int rowCount = sheet.getLastRowNum();
			System.out.println("Total number of rows : "+rowCount);
			System.out.println("UserName" + "\t" + "Password");
			for(int i=0;i<rowCount;i++)
			{
				if(sheet.getRow(i)==null) continue;
				
				String userName = sheet.getRow(i).getCell(0).getStringCellValue();
				String password = sheet.getRow(i).getCell(1).getStringCellValue();
				
				System.out.println(userName + "\t" + password);	
			}
		}
		catch(IOException ex)
		{
			logger.error("Failed to read data from XLSX file",ex);
		}
		
	}
}
