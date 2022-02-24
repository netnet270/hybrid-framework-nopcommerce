package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewerPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Common_01_Login extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserRewardPointPageObject rewardPointPage;
	UserMyProductReviewerPageObject myProductReviewerPage;
	String firstName, lastName, emailAddress, password;
	public static Set<Cookie> loginCookie;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";

		log.info("Common_01 - Step 1: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Common_01 - Step 2: Enter to 'Firstname' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Common_01 - Step 3: Enter to 'Lastname' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Common_01 - Step 4: Enter to 'EmailAddress' textbox with value: " + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 5: Enter to 'Password' textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Common_01 - Step 6: Enter to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Common_01 - Step 7: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 8: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Common_01 - Step 9: Click to 'Logout' link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Common_01 - Step 1: Click to login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Common_01 - Step 2: Enter to 'EmailAddress' textbox with value: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 3: Enter to 'Password' textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Common_01 - Step 4: Click to login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common_01 - Step 5: Get all login cookie");
		loginCookie = homePage.getAllCookies(driver);
		
		log.info("Common_01 - Step 6: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplay());
		
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}