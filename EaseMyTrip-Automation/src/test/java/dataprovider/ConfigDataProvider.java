package dataprovider;

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
			FileInputStream inputFile = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config.properties"
					);
			properties.load(inputFile);
		} 
		catch (IOException e)         
		{
			logger.error("Configuraion file does not load",e);
			throw new RuntimeException("Failed to load config file");
		}
	}

	public static String getBrowserName()
	{
		return properties.getProperty("browser");
	}

	public static String getAppURL() 
	{
		return properties.getProperty("url");
	}

	public static int getTimeOut()
	{
		return Integer.parseInt(properties.getProperty("timeout"));
	}

	public static String getUserName() 
	{
		return properties.getProperty("username");
	}

	public static String getPassword()
	{
		return properties.getProperty("password");
	}

}
