package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewerPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import reportConfig.ExtentTestManager;

public class Level_14_Log_Extent_Report extends BaseTest{
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
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
	}

	@Test
	public void User_01_Register_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register_Register");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 1: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 2: Enter to 'Firstname' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 3: Enter to 'Lastname' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 4: Enter to 'EmailAddress' textbox with value: " + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 5: Enter to 'Password' textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 6: Enter to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 7: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 8: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 9: Click to 'Logout' link");
		homePage = registerPage.clickToLogoutLink();
		
		ExtentTestManager.endTest();
	}

	@Test
	public void User_02_Login_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login_Login");

		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 1: Click to login link");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 2: Enter to 'EmailAddress' textbox with value: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 3: Enter to 'Password' textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 4: Click to login button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - Step 5: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplay());

		ExtentTestManager.endTest();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
