package me.khyen.test;

import org.apache.commons.io.FileUtils;

import org.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;

public class Functions {

	public Functions(WebDriver webDriver, String locatorsFileName) {
		this.webDriver = webDriver;

		try {
			ClassLoader classLoader = getClass().getClassLoader();

			File locatorsFile = new File(classLoader.getResource(
				locatorsFileName).getFile());

			String jsonString = FileUtils.readFileToString(
				locatorsFile, Charset.defaultCharset());

			jsonLocators = new JSONObject(jsonString);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void click(String type, String label) {
		String path = jsonLocators.getJSONObject(type).getString("xpath");

		path = path.replace("{access_name}", label);

		webDriver.findElement(By.xpath(path)).click();

		sleep(1000);
	}

	public void input(String type, String label, String text) {
		String path = jsonLocators.getJSONObject(type).getString("xpath");

		path = path.replace("{access_name}", label);

		webDriver.findElement(By.xpath(path)).clear();
		webDriver.findElement(By.xpath(path)).sendKeys(text);
	}

	public void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	protected WebDriver webDriver;
	protected JSONObject jsonLocators;

}
