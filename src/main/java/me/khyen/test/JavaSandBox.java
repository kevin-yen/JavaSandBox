package me.khyen.test;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin Yen
 */

public class JavaSandBox {

	private WebDriver webDriver;

	public JavaSandBox(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public static void main(String [] args) {
		WebDriver webDriver = WebDriverFactory.getWebDriver();

		List<String> serverURLs = Arrays.asList(
//			"http://test-1-0",
			"http://test-1-1", "http://test-1-2"
//			, "http://test-1-3", "http://test-1-4", "http://test-1-5"
			,"http://test-1-6", "http://test-1-7", "http://test-1-8",
//			, "http://test-1-9", "http://test-1-10"
//			,"http://test-1-11", "http://test-1-12", "http://test-1-13",
			"http://test-1-14"
//			, "http://test-1-15"
//			,"http://test-1-16", "http://test-1-17", "http://test-1-18", "http://test-1-19", "http://test-1-20"
//			,"http://test-1-21", "http://test-1-22", "http://test-1-23"
//			,"http://test-2-1",
//			,"http://test-5-1", "http://test-5-2",
//			,"http://test-7-1"
		);

		JavaSandBox javaSandBox = new JavaSandBox(WebDriverFactory.getWebDriver());

		for (String serverURL : serverURLs) {
			javaSandBox.enableCSRF(serverURL, System.getenv("jenkinsUsername"), System.getenv("jenkinsPassword"));
		}

		webDriver.quit();
	}

	private String getJenkinsApiToken(String url, String username, String password) {
		JenkinsLoginPage jenkinsLoginPage = new JenkinsLoginPage(webDriver, url);

		jenkinsLoginPage.open();

		jenkinsLoginPage.login(username, password);

		JenkinsUserConfigurePage jenkinsUserConfigurePage = new JenkinsUserConfigurePage(webDriver, url, username);

		jenkinsUserConfigurePage.open();

		return jenkinsUserConfigurePage.getApiToken();
	}

	private void enableCSRF(String url, String username, String password) {
		JenkinsLoginPage jenkinsLoginPage = new JenkinsLoginPage(webDriver, url);

		jenkinsLoginPage.open();

		jenkinsLoginPage.login(username, password);

		JenkinsConfigureSecurityPage jenkinsConfigureSecurityPage = new JenkinsConfigureSecurityPage(webDriver, url);

		jenkinsConfigureSecurityPage.open();

		jenkinsConfigureSecurityPage.enableCSRF();
	}

}