package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
