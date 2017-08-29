package me.khyen.test;

import org.apache.commons.lang.StringEscapeUtils;

import org.openqa.selenium.JavascriptExecutor;
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

		webDriver.get("http://www.google.com");

		JavascriptExecutor javascriptExecutor = firefoxDriver;

		String unicode = "\u5730\u7403\u304B\u3089\u3001\u5B87\u5B99\u306E\u679C\u3066\u3078";

		System.out.println(unicode);

		unicode = unicode.replace("\\", "\\\\");

		System.out.println(unicode);

		unicode = StringEscapeUtils.escapeJavaScript(unicode);

		System.out.println(unicode);

		// unicode = StringEscapeUtils.unescapeJava(unicode);

		// System.out.println(unicode);

		StringBuilder sb = new StringBuilder();

		sb.append("console.log(\"");
		sb.append(unicode);
		sb.append("\");");

		System.out.println(sb.toString());

		Thread.sleep(5000);

		javascriptExecutor.executeScript(sb.toString());

		Thread.sleep(10000);

		webDriver.quit();
	}

}
