package me.khyen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JenkinsConfigureSecurityPage extends Page {

	private String pageURL;

	private By preventCSRFCheckbox = By.name("_.csrf");
	private By applyButton = By.xpath("//button[contains(text(), 'Apply')]");
	private By defaultCrumbIssuerRadioButton = By.xpath("//input[contains(text(), 'Default Crumb Issuer')]");
	private By enableProxyCompabitiblityCheckbox = By.name("_.excludeClientIPFromCrumb");

	protected JenkinsConfigureSecurityPage(WebDriver webDriver, String jenkinsURL) {
		super(webDriver);

		pageURL = jenkinsURL + "/configureSecurity";
	}

	public void open() {
		webDriver.get(pageURL);
	}

	public void disableCSRF() {
		WebElement csrfCheckbox = webDriver.findElement(preventCSRFCheckbox);

		if (csrfCheckbox.getAttribute("checked") == null) {
			return;
		}

		String checked = csrfCheckbox.getAttribute("checked");

		if (checked.equals("true")) {
			click(preventCSRFCheckbox);
		}
	}

	public void enableCSRF() {
		WebElement csrfCheckbox = webDriver.findElement(preventCSRFCheckbox);

		String checked = csrfCheckbox.getAttribute("checked");

		if (checked == null || !checked.equals("true")) {
			click(preventCSRFCheckbox);

			click(defaultCrumbIssuerRadioButton);

			click(enableProxyCompabitiblityCheckbox);

			try {
				Thread.sleep(10000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();

				throw new RuntimeException(e);
			}

			click(applyButton);
		}

	}

}
