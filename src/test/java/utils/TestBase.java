package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver driverManager() throws IOException {

		if (driver == null) {
			if (Common.getProperty("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (Common.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(Common.getProperty("qaUrl"));
			return driver;
		}
		return driver;
	}

}
