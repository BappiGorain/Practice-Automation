package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigDataProvider 
{
	private static Properties properties;
	private static final Logger logger = LoggerFactory.getLogger(ConfigDataProvider.class);
	
	static
	{
		properties = new Properties();
		String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		try
		{
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
			logger.info("Config File Successfully loaded");
		}
		catch(IOException e)
		{
			logger.error("Failed to load Config File",e);
		}
	}
	
	
	public static String getEmail()
	{
		return properties.getProperty("email");
	}
	
	public static String getPassword()
	{
		return properties.getProperty("password");
	}
	
	public static String getTimeout()
	{
		return properties.getProperty("timeout");
	}
	
	public static String getBrowser()
	{
		return properties.getProperty("browser");
	}
	
	public static String getUrl()
	{
		return properties.getProperty("url");
	}
	
	
}
