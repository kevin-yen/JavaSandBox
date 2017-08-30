package me.khyen.test;

import org.openqa.selenium.WebDriver;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	public static void main(String [] args) throws Exception {
		WebDriver webDriver = WebDriverFactory.getWebDriver();

		LoginPage loginPage = new LoginPage(webDriver);

		loginPage.open();

		loginPage.login(System.getProperty("salesforce.username"), System.getProperty("salesforce.password"));

		webDriver.quit();
	}

}