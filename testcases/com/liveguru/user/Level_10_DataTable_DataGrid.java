package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.admin.AdminManageCustomerPageObject;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageObjects.liveGuru.user.UserHomePageObject;
import pageObjects.liveGuru.user.UserLoginPageObject;
import pageObjects.liveGuru.user.UserMyDashboardPageObject;
import pageObjects.liveGuru.user.UserRegisterPageObject;

public class Level_10_DataTable_DataGrid extends BaseTest{
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserRegisterPageObject userRegisterPage;
	UserMyDashboardPageObject userMyDashboardPage;
	AdminLoginPageObject adminLoginPage;
	AdminManageCustomerPageObject adminManageCustomerPage;
	String userFirstName, userLastName, userFullName, userEmail, userPassword, adminUser, adminPassword;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		userHomePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		userFirstName = "John";
		userLastName = "Smith";
		userFullName = userFirstName + " " + userLastName;
		userPassword = "123456";
		userEmail = "afc" + getRandomNumber() + "@gmail.com";
		
		adminUser = "user01";
		adminPassword = "guru99com";
	}

	@Test
	public void Table_01_User_Register_To_Systerm() {
		userLoginPage = userHomePage.clickToMyAccountLink();
		
		userRegisterPage = userLoginPage.clickToCreateAccountButton();
		
		userMyDashboardPage = userRegisterPage.loginAsUser(userFirstName, userLastName, userEmail, userPassword);
				
		Assert.assertEquals(userMyDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
	}
	
	@Test
	public void Table_02_Admin_Verify_Data() {
		userMyDashboardPage.openPageUrl(driver, GlobalConstants.ADMIN_LIVE_GURU_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		
		adminManageCustomerPage = adminLoginPage.loginAsAdmin(adminUser, adminPassword);

		adminManageCustomerPage.closePopup();

		adminManageCustomerPage.enterToHeaderByColumnName("Name", userFullName);
		
		adminManageCustomerPage.enterToHeaderByColumnName("Email", userEmail);
		
		adminManageCustomerPage.clickToSearchButton();
		
		Assert.assertTrue(adminManageCustomerPage.isAccountCustomerDisplay(userFullName, userEmail));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
