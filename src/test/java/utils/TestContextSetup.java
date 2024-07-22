package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String productName;
	public WebDriverWait wait;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public Common common;
	public Scenario scenario;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.driverManager());
		common = new Common(testBase.driverManager());
	}
	
	public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
