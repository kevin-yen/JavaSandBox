package me.khyen.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	public static void main(String [] args) throws Exception {
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

		firefoxOptions.setBinary("/opt/firefox/firefox");

		FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);

		WebDriver webDriver = firefoxDriver;

		webDriver.quit();
	}


}