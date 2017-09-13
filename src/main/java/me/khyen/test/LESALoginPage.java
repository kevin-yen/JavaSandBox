package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LESALoginPage extends Page {

	public LESALoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void go() {
		webDriver.get("http://www-support-2.liferay.com");
	}

	public void login(String email, String password) {
		clear(By.id("_58_login"));

		type(By.id("_58_login"), email);

		type(By.id("_58_password"), password);

		click(By.cssSelector("input[type=\"submit\"]"));
	}
}
