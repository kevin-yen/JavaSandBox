package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage extends Page {

	public LoggedInPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void logout() {
		click(By.id("menuToggle"));

		click(By.linkText("Sign Out"));
	}

}
