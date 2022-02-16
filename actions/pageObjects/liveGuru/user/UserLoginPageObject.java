package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAccountButton() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManager.getUserRegisterPageOject(driver);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserMyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserMyDashboardPageOject(driver);
	}
}
