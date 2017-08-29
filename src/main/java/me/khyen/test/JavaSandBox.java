package me.khyen.test;

import org.openqa.selenium.WebDriver;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	public static void main(String [] args) throws Exception {
		WebDriver webDriver = WebDriverFactory.getWebDriver();

		HomePage homePage = new HomePage(webDriver);

		homePage.open();

		homePage.signIn("test@liferay.com", "test");

		WebContentPage webContentPage = homePage.openWebContentPage();

		AddWebContentPage addWebContentPage = webContentPage.openAddWebContentPage();

		StringBuilder sb = new StringBuilder();

		sb.append("<h2 class=\"text-center\">Hello</h2>\n");
		sb.append("<p class=\"text-center\">World!</p>");

		addWebContentPage.addSourceWebContent(sb.toString());

		webDriver.quit();
	}

}
