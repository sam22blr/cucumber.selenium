package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	By searchField = By.cssSelector("input[placeholder='Search for Vegetables and Fruits']");
	By prodName = By.cssSelector("h4.product-name");
	By plus = By.cssSelector(".increment");
	By addToCart = By.cssSelector("div[class='product-action'] button[type='button']");

	public void doSearch(String name) {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int noOfProds = getListCountBeforeSearch();
		driver.findElement(searchField).sendKeys(name);
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("h4.product-name"), noOfProds));

		// Thread.sleep(2000);
	}

	public String getProductName() {
		// Write code here that turns the phrase above into concrete actions

		return driver.findElement(prodName).getText();
	}

	public int getListCountBeforeSearch() {
		// Write code here that turns the phrase above into concrete actions

		return driver.findElements(prodName).size();
	}

	public String splitProductName(String text) {
		// Write code here that turns the phrase above into concrete actions
		return text.split("-")[0].trim();
	}

	public void increment(int times) {

		for (int i = 1; i < times; i++) {
			driver.findElement(plus).click();
		}
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
