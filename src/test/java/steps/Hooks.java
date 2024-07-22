package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;
import utils.TestContextSetup;

public class Hooks {

	TestContextSetup testContextSetup;
	private ScreenshotUtil screnshotUtil;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		testContextSetup.setScenario(scenario);
	}

	@After
	public void AfterScenario() throws IOException {
		testContextSetup.testBase.driverManager().quit();

	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws WebDriverException, IOException {
		attachToExtentReport(scenario, "screenshot");
	}
	
	@BeforeStep
	public void beforeStep(Scenario scenario) throws WebDriverException, IOException {
		//attachToExtentReport(scenario, "screenshot");
	}

	public File TakeScreenshot() throws WebDriverException, IOException {
		screnshotUtil = new ScreenshotUtil(testContextSetup.testBase.driverManager());
		return screnshotUtil.captureScreenshot();
	}
	
	public void attachToExtentReport(Scenario scenario, String name) throws WebDriverException, IOException {
		scenario.attach(FileUtils.readFileToByteArray(TakeScreenshot()), "image/png", name);
	}
}
