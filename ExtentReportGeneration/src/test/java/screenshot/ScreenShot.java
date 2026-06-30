package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenShot
{
	private static final Logger logger = LoggerFactory.getLogger(ScreenShot.class);
	public static String takeScreenShot(WebDriver driver)
	{
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);

	    String path = System.getProperty("user.dir") + "/ScreenShot/screenshot_" + System.currentTimeMillis() + ".png";
	    
	    try {
	        FileUtils.copyFile(src, new File(path));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return path;
	}
	
}
