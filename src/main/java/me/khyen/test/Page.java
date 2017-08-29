package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	private final long TIMEOUT_IN_SECONDS = 10;

	protected static WebDriver webDriver;

	private WebDriverWait wait;

	protected Page(WebDriver webDriver) {
		this.webDriver = webDriver;

		wait = new WebDriverWait(webDriver, TIMEOUT_IN_SECONDS);
	}

	protected void clear(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		WebElement webElement = webDriver.findElement(By.xpath(xpath));

		webElement.clear();
	}

	protected void click(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		WebElement webElement = webDriver.findElement(By.xpath(xpath));

		webElement.click();
	}

	protected void open(String url) {
		webDriver.get(url);
	}

	protected void type(String xpath, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		WebElement webElement = webDriver.findElement(By.xpath(xpath));

		webElement.sendKeys(text);
	}

}
