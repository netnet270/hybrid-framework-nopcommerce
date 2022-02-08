package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_MENU);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_MENU);
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.LOGIN_SUCCESS_MESSAGE);
		return getTextElement(driver, MyDashboardPageUI.LOGIN_SUCCESS_MESSAGE);
	}
}
