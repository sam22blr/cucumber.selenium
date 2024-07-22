package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;

public class Common {

	public WebDriver driver;
	public WebDriverWait wait;
	public ScreenshotUtil screenshotUtil;

	public Common(WebDriver driver) {
		this.driver = driver;
	}

	public void switchWindowToChild() {

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
	}
	
	public WebDriverWait waitUntil() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
	
	public WebElement waitForElement(By ele) {
		return waitUntil().until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public static String getProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/global.properties"));
		
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	
	public void attachScreenshotToStep(Scenario scenario) throws IOException {
		screenshotUtil = new ScreenshotUtil(driver);
		 
		//ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(captureScreenshot("extra"));
		scenario.attach(FileUtils.readFileToByteArray(screenshotUtil.captureScreenshot()), "image/png", "extra");
		ExtentCucumberAdapter.addTestStepLog("Screenshot attached successfully.");
	}
	
	public String captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        try {
            FileHandler.copy(source, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
