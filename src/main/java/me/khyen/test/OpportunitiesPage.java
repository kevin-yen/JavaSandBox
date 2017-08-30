package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesPage extends Page {

	private static By populateOtherProjectLink = By.linkText("Populate Other-Populate Other Project-S-2013.1.1");
	private static By partnerResellerField = By.id("CF00N70000002Obry_ileinner");
	private static By searchIcon = By.id("CF00N70000002ObryIcon");
	private static By detailsLink = By.id("efpViews_0062F000002O3RB_option1");

	public OpportunitiesPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void openWindow() {
		click(populateOtherProjectLink);

		click(detailsLink);

		click(partnerResellerField);

		try {
			Thread.sleep(100);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		click(partnerResellerField);

		click(searchIcon);
	}

}
