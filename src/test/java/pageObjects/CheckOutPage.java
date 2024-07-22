package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;

	}

	By cart = By.cssSelector("img[alt='Cart']");
	By checkout = By.cssSelector("div[class='cart-preview active'] button[type='button']");
	By apply = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[normalize-space()='Place Order']");
	By prodName = By.cssSelector(".product-name");
	By quantity = By.cssSelector(".quantity");


	public void goToShoppingBag() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(cart).click();
	}

	public void proceedToCheckOut() {
		// Write code here that turns the phrase above into concrete actions

		driver.findElement(checkout).click();
	}
	
	public By waitPromoButton() {
		return apply;
	}
	public Boolean verifyPromoButton() {
		// Write code here that turns the phrase above into concrete actions

		return driver.findElement(apply).isDisplayed();
	}
	
	public void placeOrder() {
		driver.findElement(placeOrder).click();
	}
	
	public String getProdName() {
		return driver.findElement(prodName).getText();
	}
	
	public String getQuantiy() {
		return driver.findElement(quantity).getText();
	}
}
