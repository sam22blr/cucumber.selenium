package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageSteps {
	String productName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	public PageObjectManager pageObjectManager;
	
	public LandingPageSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		
	}
	
	@Given("User is on the greencart landing page")
	public void user_is_on_the_greencart_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^User enters the search word (.+) on the search box$")
	public void user_enters_the_search_word_on_the_search_box(String name) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.doSearch(name);
		//Thread.sleep(2000);
	}

	@Then("^User gets the filtered results containing product (.+)$")
	public void user_gets_the_filtered_results_containing_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		testContextSetup.productName = landingPage.splitProductName(landingPage.getProductName());
	}
	
	@Given("^User adds (.+) items to cart$")
	public void user_adds_item_to_cart(int items) {
		// Write code here that turns the phrase above into concrete actions
		//landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.increment(items);
		landingPage.addToCart();
	}

}
