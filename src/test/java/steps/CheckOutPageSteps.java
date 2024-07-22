package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckOutPageSteps {
	String productName;
	TestContextSetup testContextSetup;
	CheckOutPage checkOutPage;
	
	
	public PageObjectManager pageObjectManager;

	public CheckOutPageSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckOutPage();
		
	}

	@Then("^User clicks on checkout and validate the (.+) and (.+) in checkout page$")
	public void user_checksout(String name, int items) throws InterruptedException {

		checkOutPage.goToShoppingBag();
		checkOutPage.proceedToCheckOut();

		assertEquals(checkOutPage.getProdName(), "Tomato - 1 Kg");
		assertEquals(checkOutPage.getQuantiy(), items + " Nos.");
	}

	@Then("User verifies promo code and place the order")
	public void user_verifies_promo_code() throws IOException {
		testContextSetup.common.waitForElement(checkOutPage.waitPromoButton());
		Assert.assertTrue(checkOutPage.verifyPromoButton());
		testContextSetup.common.attachScreenshotToStep(testContextSetup.getScenario());
		checkOutPage.placeOrder();
	}

}
