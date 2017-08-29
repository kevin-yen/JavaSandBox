package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

	private static final String HOME_PAGE_URL = "http://localhost:8080";

	private static final By SIGN_IN_EMAIL = By.id("_com_liferay_login_web_portlet_LoginPortlet_login");
	private static final By SIGN_IN_PASSWORD = By.id("_com_liferay_login_web_portlet_LoginPortlet_password");
	private static final By SIGN_IN_BUTTON = By.cssSelector("button[type=submit] > span");
	private static final By SIGN_IN_LINK = By.cssSelector("a.sign-in");

	private static final By CONTENT_LINK = By.xpath("//a[contains(., ' Content ')]");
	private static final By WEB_CONTENT_LINK = By.xpath("//a[contains(., ' Web Content ')]");

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public void open() {
		open(HOME_PAGE_URL);
	}

	public void signIn(String username, String password) {
		click(SIGN_IN_LINK);

		click(SIGN_IN_EMAIL);
		clear(SIGN_IN_EMAIL);
		type(SIGN_IN_EMAIL, username);

		type(SIGN_IN_PASSWORD, password);

		click(SIGN_IN_BUTTON);
	}

	public WebContentPage openWebContentPage() {
		click(CONTENT_LINK);

		click(WEB_CONTENT_LINK);

		return new WebContentPage(webDriver);
	}

}
