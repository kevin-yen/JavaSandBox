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

		HomePage homePage = loginPage.login(System.getProperty("salesforce.username"), System.getProperty("salesforce.password"));

		OpportunitiesPage opportunitiesPage = homePage.openOpportunitiesPage();

		opportunitiesPage.openWindow();

		Thread.sleep(10000);

		webDriver.quit();
	}

}