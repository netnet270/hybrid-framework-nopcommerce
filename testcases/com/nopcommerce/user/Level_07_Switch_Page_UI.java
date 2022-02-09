package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopCommerce.AddressPageObject;
import pageObjects.nopCommerce.CustomerInfoPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyProductReviewerPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.RewardPointPageObject;

public class Level_07_Switch_Page_UI extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInfoPageObject customerInfoPage;
	AddressPageObject addressPage;
	RewardPointPageObject rewardPointPage;
	MyProductReviewerPageObject myProductReviewerPage;
	String firstName, lastName, invalidEmail, notFoundEmail, existEmail, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "afc@333@$##$";
		existEmail = "afc" + getRandomNumber() + "@gmail.vn";
		notFoundEmail = "afc" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		System.out.println("User_01 - step 1: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		System.out.println("User_01 - step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("User_01 - step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("User_01 - step 4: Verify success mesage displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("User_01 - step 5: Click to logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		System.out.println("User_02 - step 1: Click to login link");
		loginPage = homePage.clickToLoginLink();

		System.out.println("User_02 - step 2: Input to all required fields");
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("User_02 - step 3: Click to login button");
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}

	@Test
	public void User_03_My_Account() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isMyAccountPageDisplay());
	}

	@Test
	public void User_04_Switch_Page() {
//		customerInfoPage -> addressPage
		addressPage = customerInfoPage.openAddressPage(driver);
		
//		addressPage -> customerInfoPage
		customerInfoPage = addressPage.openCustomerInfoPage(driver);
		
		rewardPointPage = customerInfoPage.openRewardPointPage(driver);
		
		addressPage = rewardPointPage.openAddressPage(driver);
		
		myProductReviewerPage = addressPage.openMyProductReviwerPage(driver);
		
		customerInfoPage = myProductReviewerPage.openCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
