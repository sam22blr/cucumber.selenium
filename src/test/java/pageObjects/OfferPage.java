package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	public WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver = driver;

	}

	By offersLink = By.cssSelector(".cart-header-navlink[href='#/offers']");
	By searchField = By.cssSelector("#search-field");
	By searchedProduct = By.cssSelector("tbody tr td:nth-child(1)");

	public void clickOffersLink() {
		driver.findElement(offersLink).click();
	}

	public void Search(String name) {
		// TODO Auto-generated method stub
		driver.findElement(searchField).sendKeys(name);

	}

	public String getProductText() {
		// TODO Auto-generated method stub
		return driver.findElement(searchedProduct).getText();
	}
}
