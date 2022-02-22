package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewerPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_14_Log_Report extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserRewardPointPageObject rewardPointPage;
	UserMyProductReviewerPageObject myProductReviewerPage;
	String firstName, lastName, emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
	}

	@Test
	public void User_01_Register_Register() {
		log.info("User_01_Register - Step 1: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("User_01_Register - Step 2: Enter to 'Firstname' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("User_01_Register - Step 3: Enter to 'Lastname' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("User_01_Register - Step 4: Enter to 'EmailAddress' textbox with value: " + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("User_01_Register - Step 5: Enter to 'Password' textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);
		
		log.info("User_01_Register - Step 6: Enter to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("User_01_Register - Step 7: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register - Step 8: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("User_01_Register - Step 9: Click to 'Logout' link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login_Login() {
		log.info("User_02_Login - Step 1: Click to login link");
		loginPage = homePage.clickToLoginLink();

		log.info("User_02_Login - Step 2: Enter to 'EmailAddress' textbox with value: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("User_02_Login - Step 3: Enter to 'Password' textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("User_02_Login - Step 4: Click to login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("User_02_Login - Step 5: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplay());
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		driver.quit();
	}
}
