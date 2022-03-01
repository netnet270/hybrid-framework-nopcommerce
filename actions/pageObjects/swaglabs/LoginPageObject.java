package pageObjects.swaglabs;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.swaglabs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
	}

	public void enterToUPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public InvestoryPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getInvestoryPageObject(driver);
	}
}
