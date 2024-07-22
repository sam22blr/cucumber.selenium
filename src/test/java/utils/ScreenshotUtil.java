package utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    public File captureScreenshot() {
    	File path = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		return path;
    }
}