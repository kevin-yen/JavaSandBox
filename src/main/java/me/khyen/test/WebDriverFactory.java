package me.khyen.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
		if ("firefox".equals(System.getenv("browser.type"))) {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver/0.18.0/linux64/geckodriver");

			FirefoxOptions firefoxOptions = new FirefoxOptions();

			firefoxOptions.addPreference("browser.download.dir", ".");
			firefoxOptions.addPreference("browser.download.folderList", 2);
			firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
			firefoxOptions.addPreference("browser.download.useDownloadDir", true);
			firefoxOptions.addPreference("browser.helperApps.alwaysAsk.force", false);
			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/excel,application/msword,application/pdf,application/zip,audio/mpeg3,image/jpeg,image/png,text/plain");
			firefoxOptions.addPreference("dom.max_chrome_script_run_time", 300);
			firefoxOptions.addPreference("dom.max_script_run_time", 300);

			firefoxOptions.setBinary(System.getenv("firefox.bin"));

			FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);

			webDriver = firefoxDriver;
			javascriptExecutor = firefoxDriver;
		}
		else {
			throw new IllegalArgumentException("Invalid browser type " + System.getenv("browser.type"));
		}
	}

}
