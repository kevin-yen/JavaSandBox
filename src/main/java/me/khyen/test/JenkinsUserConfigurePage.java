package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JenkinsUserConfigurePage extends Page {

	private String pageURL;

	private By showApiTokenButton = By.xpath("//button[contains(text(), 'Show API Token...')]");
	private By apiTokenField = By.id("apiToken");

	protected JenkinsUserConfigurePage(WebDriver webDriver, String jenkinsURL, String username) {
		super(webDriver);

		pageURL = jenkinsURL + "/user/" + username + "/configure";
	}

	public void open() {
		webDriver.get(pageURL);
	}

	public String getApiToken() {
		click(showApiTokenButton);

		WebElement apiTokenFieldElement = webDriver.findElement(apiTokenField);

		return apiTokenFieldElement.getAttribute("value");
	}

}
