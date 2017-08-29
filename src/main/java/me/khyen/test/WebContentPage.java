package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebContentPage extends Page {

	private static final By ADD_BUTTON = By.xpath("//button[@data-qa-id='addButton']");
	private static final By BASIC_WEB_CONTENT_LINK = By.xpath("//a[contains(., 'Basic Web Content')]");

	public WebContentPage(WebDriver webDriver) {
		super(webDriver);
	}

	public AddWebContentPage openAddWebContentPage() {
		click(ADD_BUTTON);

		click(BASIC_WEB_CONTENT_LINK);

		return new AddWebContentPage(webDriver);
	}

}
