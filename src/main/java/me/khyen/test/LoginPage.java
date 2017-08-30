package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

	private static By usernameInput = By.id("username");
	private static By passwordInput = By.id("password");
	private static By loginButton = By.id("Login");

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void open() {
		webDriver.get("https://test.salesforce.com/");
	}

	public void login(String username, String password) {
		type(usernameInput, username);

		type(passwordInput, password);

		click(loginButton);
	}

}
