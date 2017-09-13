package me.khyen.test;

import org.openqa.selenium.WebDriver;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	public static void main(String [] args) throws Exception {
		WebDriver webDriver = WebDriverFactory.getWebDriver();

		LESALoginPage LESALoginPage = new LESALoginPage(webDriver);

		LESALoginPage.go();

		LESALoginPage.login(System.getProperty("lesa.email"), System.getProperty("lesa.password"));

		Thread.sleep(5000);

		webDriver.quit();
	}

}