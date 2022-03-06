package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class EmployeeListPageObject extends BasePage {
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
