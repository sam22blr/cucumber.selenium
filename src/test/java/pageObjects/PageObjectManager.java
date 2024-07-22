package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public OfferPage offerPage;
	public CheckOutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OfferPage getOfferPage() {
		offerPage = new OfferPage(driver);
		return offerPage;
	}

	public CheckOutPage getCheckOutPage() {
		checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
}
