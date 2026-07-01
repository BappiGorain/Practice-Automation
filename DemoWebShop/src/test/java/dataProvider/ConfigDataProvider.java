package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigDataProvider 
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigDataProvider.class);
	static Properties properties;
	static
	{
		properties = new Properties();
		String path = System.getProperty("user.dir") + "/config/config.properties";
		try 
		{
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
			logger.info("Config Path is loaded successfully");
		}
		catch (IOException e) 
		{
			logger.error("Config path is not loaded",e);
		}
	}
	
	public static String getBrowser()
	{
		return properties.getProperty("browser");
	}
	
	public static String getUrl()
	{
		return properties.getProperty("url");
	}
	
	public static String getTimeOut()
	{
		return properties.getProperty("timeout");
	}
	
	public static String getValidEmail()
	{
		return properties.getProperty("correctemail");
	}
	
	public static String getValidPassword()
	{
		return properties.getProperty("correctpassword");
	}
	
	public static String getInValidEmail()
	{
		return properties.getProperty("incorrectemail");
	}
	
	public static String getInValidPassword()
	{
		return properties.getProperty("incorrectpassword");
	}
}
