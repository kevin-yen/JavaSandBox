package me.khyen.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	private static WebDriver webDriver;
	private static JavascriptExecutor javascriptExecutor;

	private WebDriverFactory() {
		webDriver = null;
		javascriptExecutor = null;
	}

	public static WebDriver getWebDriver() {
		if (webDriver == null) {
			createWebDriverAndJavascriptExecutor();
		}

		return webDriver;
	}

	public static JavascriptExecutor getJavascriptExecutor() {
		if (javascriptExecutor == null) {
			createWebDriverAndJavascriptExecutor();
		}

		return javascriptExecutor;
	}

	private static void createWebDriverAndJavascriptExecutor() {
		if ("firefox".equals(System.getenv("browser"))) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (System.getenv("firefox.bin") != null) {
				firefoxOptions.setBinary(System.getenv("firefox.bin"));
			}

			FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);

			webDriver = firefoxDriver;
			javascriptExecutor = firefoxDriver;
		}
		else if ("chrome".equals(System.getenv("browser"))) {
			ChromeDriver chromeDriver = new ChromeDriver();

			webDriver = chromeDriver;
			javascriptExecutor = chromeDriver;
		}
		else if ("ie".equals(System.getenv("ie"))) {
			InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver();

			webDriver = internetExplorerDriver;
			javascriptExecutor = internetExplorerDriver;
		}
		else {
			throw new IllegalArgumentException("Invalid browser '" + System.getenv("browser") + "'");
		}
	}

}
