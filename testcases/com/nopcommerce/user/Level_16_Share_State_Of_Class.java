package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_State_Of_Class extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	String firstName, lastName, emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		log.info("Pre-Condition - Step 02: Click to login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 03: Inject cookie");
		loginPage.setAllCookies(driver, Common_01_Login.loginCookie);

		log.info("Pre-Condition - Step 04: Refresh Page");
		loginPage.refreshToPage(driver);
		
		log.info("Pre-Condition - Step 05: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplay());
	}

	@Test
	public void User_01_Create_New_Account() {
		log.info("User_01 - Create_New_Account");
	}

	@Test
	public void User_02_Delete_Account() {
		log.info("User_02 - Delete_Account");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
