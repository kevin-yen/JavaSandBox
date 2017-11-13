package me.khyen.test;

import org.openqa.selenium.WebDriver;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	public static void main(String [] args) throws Exception {
		WebDriver webDriver = WebDriverFactory.getWebDriver();

		LESALoginPage LESALoginPage = new LESALoginPage(webDriver);

		Exception thrownException = null;

		while (thrownException == null) {
			try {
				LESALoginPage.go();

				LoggedInPage loggedInPage = LESALoginPage.login(System.getProperty("lesa.email"), System.getProperty("lesa.password"));

				System.out.println("Logging in");

				long startTime = System.currentTimeMillis();

				System.out.println(webDriver.getCurrentUrl());

				System.out.println(System.currentTimeMillis() - startTime);

				System.out.println("Logging out");

				loggedInPage.logout();

				startTime = System.currentTimeMillis();

				System.out.println(webDriver.getCurrentUrl());

				System.out.println(System.currentTimeMillis() - startTime);
			}
			catch (Exception e) {
				e.printStackTrace();

				thrownException = e;
			}
		}

		webDriver.quit();

		throw thrownException;
	}

}