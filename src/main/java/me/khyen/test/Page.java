package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	private final long TIMEOUT_IN_SECONDS = 10;
	private final long SLEEP_IN_MILLIS = 1000;

	protected static WebDriver webDriver;
	protected static WebDriverWait wait;

	protected Page(WebDriver webDriver) {
		this.webDriver = webDriver;

		wait = new WebDriverWait(webDriver, TIMEOUT_IN_SECONDS, SLEEP_IN_MILLIS);
	}

	protected void clear(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		WebElement webElement = webDriver.findElement(by);

		webElement.clear();
	}

	protected void click(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));

		WebElement webElement = webDriver.findElement(by);

		webElement.click();
	}

	protected void type(By by, CharSequence text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		WebElement webElement = webDriver.findElement(by);

		webElement.sendKeys(text);
	}

	protected void open(String url) {
		webDriver.get(url);
	}

}
