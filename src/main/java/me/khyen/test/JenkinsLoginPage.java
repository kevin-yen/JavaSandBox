package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JenkinsLoginPage extends Page {

	private String pageURL;

	private By usernameField = By.id("j_username");
	private By passwordField = By.name("j_password");
	private By loginButton = By.xpath("//button[contains(text(), 'log in')]");
	private By logoutLink = By.xpath("//a[@href='/logout']");

	protected JenkinsLoginPage(WebDriver webDriver, String jenkinsURL) {
		super(webDriver);

		pageURL = jenkinsURL + "/login";
	}

	public void login(String username, String password) {
		open();

		String loginURL = webDriver.getCurrentUrl();

		type(usernameField, username);
		type(passwordField, password);

		click(loginButton);

		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
	}

	public void open() {
		webDriver.get(pageURL);
	}

}
