package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewerPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest{
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserRegisterPageObject userRegisterPage;
	UserCustomerInfoPageObject userCustomerInfoPage;
	UserAddressPageObject userAddressPage;
	UserRewardPointPageObject userRewardPointPage;
	UserMyProductReviewerPageObject userMyProductReviewerPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	String userEmail, userPassword, adminEmail, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		userHomePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		userEmail = "afc123@gmail.com";
		userPassword = "123456";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void User_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
		userHomePage.clickToLogoutLink();
		
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		
		adminLoginPage = adminDashboardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Admin_To_User() {
		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		
		userHomePage = PageGeneratorManager.getUserHomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
