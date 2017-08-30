package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

	private static By opportunitiesLink = By.linkText("Opportunities");

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public OpportunitiesPage openOpportunitiesPage() {
		click(opportunitiesLink);

		return new OpportunitiesPage(webDriver);
	}

}
