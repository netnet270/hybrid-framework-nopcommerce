package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.liveGuru.user.UserHomePageObject;
import pageObjects.liveGuru.user.UserLoginPageObject;
import pageObjects.liveGuru.user.UserMyDashboardPageObject;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageObjects.liveGuru.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserMyDashboardPageObject myDashboardPage;
	String firstName, lastName, email, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		email = "afc" + getRandomNumber() + "@gmail.vn";
	}

	@Test
	public void User_01_Register_To_Systerm() {
		loginPage = homePage.clickToMyAccountLink();
		
		System.out.println("User 01 - step 1: Click to Create Account Button");
		registerPage = loginPage.clickToCreateAccountButton();
		
		System.out.println("User 01 - step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("User 01 - step 3: Click to Register button");
		myDashboardPage = registerPage.clickToRegisterButton();
				
		System.out.println("User 01 - step 4: Verify success mesage displayed");
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		
		System.out.println("User 01 - step 5: Click to logout link");
		homePage = myDashboardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login_To_Systerm() {
		loginPage = homePage.clickToMyAccountLink();
		
		System.out.println("User 02 - step 1: Input to required fields");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("User 02 - step 2: Click to Login button");
		myDashboardPage = loginPage.clickToLoginButton();
		
		System.out.println("User 02 - step 3: Verify success mesage displayed");
		Assert.assertEquals(myDashboardPage.getLoginSuccessMessage(), "Hello, " + firstName + " " + lastName + "!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
