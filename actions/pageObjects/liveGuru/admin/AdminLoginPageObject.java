package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageUIs.liveGuru.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserName(String adminUser) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, adminUser);
	}

	public void inputToPassword(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminManageCustomerPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.lOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.lOGIN_BUTTON);
		return PageGeneratorManager.AdminManageCustomerPageObject(driver);
	}

	public AdminManageCustomerPageObject loginAsAdmin(String adminUser, String adminPassword) {
		inputToUserName(adminUser);
		inputToPassword(adminPassword);
		return clickToLoginButton();
	}
}
