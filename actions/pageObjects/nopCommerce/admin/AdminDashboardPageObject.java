package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class AdminDashboardPageObject extends BasePage{
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminLoginPageObject clickToLogoutLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPageObject(driver);
	}
}
