package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.user.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage{
	private WebDriver driver;
	
	public UserMyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserMyDashboardPageUI.ACCOUNT_MENU);
		clickToElement(driver, UserMyDashboardPageUI.ACCOUNT_MENU);
		waitForElementClickable(driver, UserMyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, UserMyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}

	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, UserMyDashboardPageUI.LOGIN_SUCCESS_MESSAGE);
		return getTextElement(driver, UserMyDashboardPageUI.LOGIN_SUCCESS_MESSAGE);
	}
}
