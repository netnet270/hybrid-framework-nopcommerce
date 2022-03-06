package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class AddEmployeePageObject extends BasePage {
	WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {
		this.driver = driver;
	}
}
