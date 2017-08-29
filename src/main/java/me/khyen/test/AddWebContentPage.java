package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddWebContentPage extends Page {

	private static final By CONTENT_TEXT_BOX = By.xpath("//div[@title='Rich Text Editor']");
	private static final By SWITCH_EDITOR_BUTTON = By.xpath("//button[contains(@id, 'Editor') and not(contains(@class, 'hide'))]");
	private static final By ACE_EDITOR = By.cssSelector("div.ace_editor");

	public AddWebContentPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void addSourceWebContent(String text) {
		click(CONTENT_TEXT_BOX);

		click(SWITCH_EDITOR_BUTTON);

		click(ACE_EDITOR);

		typeAceEditor(ACE_EDITOR, text);
	}

	protected void typeAceEditor(By by, String text) {
		type(by, text);

		WebElement webElement = webDriver.findElement(by);

		webElement.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));

		webElement.sendKeys(Keys.DELETE);
	}

}
