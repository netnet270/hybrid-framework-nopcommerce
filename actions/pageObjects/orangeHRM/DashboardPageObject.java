package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
