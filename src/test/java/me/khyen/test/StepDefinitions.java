package me.khyen.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;

public class StepDefinitions {

	@Before
	public void setup() {
		webDriver = WebDriverFactory.getWebDriver();

		functions = new Functions(webDriver, "locators/portal.json");
	}

	@After
	public void teardown() {
		webDriver.quit();
	}

	// Step Definitions

	@Given("^I sign in to Liferay Portal as \"([^\"]*)\"$")
	public void I_sign_in_to_Liferay_Portal_as() {
		webDriver.get("http://localhost:8080");

		functions.click("link","Sign In");
		functions.input("text_field","Email Address","test@liferay.com");
		functions.input("text_field","Password","test");
		functions.click("button","Sign In");
	}

	@Then("^I should be signed in$")
	public void i_should_be_signed_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("^I visit \"([^\"]*)\"$")
	public void I_visit(String url) {
		webDriver.get(url);
	}

	@When("^I click the \"([^\"]*)\" \"([^\"]*)\"$")
	public void I_click_the(String label, String object) {
		functions.click(object, label);
	}

	@When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void I_fill_in_with(String label, String text) {
		functions.input("text_field", label, text);
	}

	@When("^I switch to active modal$")
	public void I_switch_to_active_modal() {
		webDriver.switchTo().activeElement();
	}

	@When("^I sleep for (\\d+) milliseconds$")
	public void I_sleep_for(int milliseconds) {
		functions.sleep(milliseconds);
	}

	protected WebDriver webDriver;
	protected Functions functions;

}
