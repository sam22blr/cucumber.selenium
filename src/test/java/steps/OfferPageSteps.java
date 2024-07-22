package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageSteps {
	String prodNameInOffer;
	TestContextSetup testContextSetup;
	OfferPage offerPage;
	public PageObjectManager pageObjectManager;

	public OfferPageSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;

	}

	@When("User clicks on the link Top Deals")
	public void User_clicks_on_the_link_TopDeals() {
		clickOffersLink();
		switchWindowToOffersPage();
	}

	public void clickOffersLink() {
		offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.clickOffersLink();
	}

	public void switchWindowToOffersPage() {
		if (!testContextSetup.common.getCurrentURL().contains("seleniumPractise/#/offers")) {
			testContextSetup.common.switchWindowToChild();
		}
	}

	@Then("^User enters the search word (.+) on the search field$")
	public void user_enter_searchWord_in_offer(String name) throws InterruptedException {
		offerPage.Search(name);
		Thread.sleep(1000);
	}

	@And("User verifies the search result")
	public void user_verifies_search_result() {
		prodNameInOffer = offerPage.getProductText();
		Assert.assertEquals(prodNameInOffer, testContextSetup.productName);
	}
}
