package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.admin.AdminManageCustomerPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePageObject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPageOject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserMyDashboardPageObject getUserMyDashboardPageOject(WebDriver driver) {
		return new UserMyDashboardPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminManageCustomerPageObject AdminManageCustomerPageObject(WebDriver driver) {
		return new AdminManageCustomerPageObject(driver);
	}
}
