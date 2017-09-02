package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpportunitiesPage extends Page {

	private static By populateOtherProjectLink = By.linkText("Populate Other-Populate Other Project-S-2013.1.1");
	private static By partnerResellerField = By.id("CF00N70000002Obry_ilecell");
	private static By searchIcon = By.id("CF00N70000002ObryIcon");
	private static By detailsLink = By.id("efpViews_0062F000002O3RB_option1");

	public OpportunitiesPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void openWindow() {
		click(populateOtherProjectLink);

		click(detailsLink);

		click(partnerResellerField);

		type(partnerResellerField, Keys.ENTER);

		click(searchIcon);
	}

}
