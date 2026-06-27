package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenShot {

    private static final Logger logger = LoggerFactory.getLogger(ScreenShot.class);

    public String takeScreenshot(WebDriver driver) {
        
        String filePath = "./ScreenShot/easemytrip_" + currentDateTime() + ".png";

        File dir = new File("./ScreenShot");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File srcFile = screenShot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(filePath));
            logger.info("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            logger.error("Failed to take screenshot", e);
        }

        return filePath;
    }

    private String currentDateTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss"));
    }
}