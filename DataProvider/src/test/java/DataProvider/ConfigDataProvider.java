package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigDataProvider 
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigDataProvider.class);
	
	private static Properties properties;
	
	
		static
		{
			properties = new Properties();
		
			try 
			{
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
				properties.load(fis);
			}
			catch (IOException e)
			{
				logger.error("Failed to read properties file",e); 
			}
		}
	
	
	public static String getBrowser()
	{
		return properties.getProperty("browser");
	}
	
	public static String getUrl()
	{
		return properties.getProperty("appurl");
	}
	
	public static String getTimeOut()
	{
		return properties.getProperty("timeout");
	}
}
