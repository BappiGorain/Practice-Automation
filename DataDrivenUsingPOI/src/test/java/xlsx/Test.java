package xlsx;
public class Test
{
	@org.testng.annotations.Test
	public void printXLSXData()
	{
		XlsxDataProvider dataProvider = new XlsxDataProvider();
		dataProvider.xlsxDataReader();
	}
}
