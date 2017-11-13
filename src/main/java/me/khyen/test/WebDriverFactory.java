package me.khyen.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

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
			FirefoxProfile firefoxProfile = new FirefoxProfile();

			FirefoxDriver firefoxDriver;

			if (System.getenv("firefox.bin") != null) {
				FirefoxBinary firefoxBinary = new FirefoxBinary(new File(System.getenv("firefox.bin")));

				firefoxDriver = new FirefoxDriver(firefoxBinary, firefoxProfile);
			}
			else {
				firefoxDriver = new FirefoxDriver(firefoxProfile);
			}

			webDriver = firefoxDriver;
			javascriptExecutor = firefoxDriver;
		}
		else if ("chrome".equals(System.getenv("browser"))) {
			ChromeDriver chromeDriver = new ChromeDriver();

			webDriver = chromeDriver;
			javascriptExecutor = chromeDriver;
		}
		else if ("ie".equals(System.getenv("browser"))) {
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();

			desiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.google.com");

			InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(desiredCapabilities);

			webDriver = internetExplorerDriver;
			javascriptExecutor = internetExplorerDriver;
		}
		else {
			throw new IllegalArgumentException("Invalid browser '" + System.getenv("browser") + "'");
		}
	}

}
