package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, invalidEmail, notFoundEmail, existEmail, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);

		registerPage = new UserRegisterPageObject(driver);
		registerPage.clickToRegisterLink();

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "afc@333@$##$";
		existEmail = "afc" + getRandomNumber() + "@gmail.vn";
		notFoundEmail = "afc" + getRandomNumber() + "@gmail.com";

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - step 1: Click to login link");
		homePage = new UserHomePageObject(driver);
		homePage.clickToLoginLink();

		System.out.println("Login_01 - step 1: Click to login button");
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		System.out.println("Login_01 - step 3: Verify error message displayed at email field");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - step 1: Click to login link");
		loginPage.clickToLoginLink();
		
		System.out.println("Login_02 - step 2: Input to email field");
		loginPage.inputToEmailTextbox(invalidEmail);
		
		System.out.println("Login_02 - step 3: Click to login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_02 - step 4: Verify error message displayed at email field");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Not_Found_Email() {
		System.out.println("Login_03 - step 1: Click to login link");
		loginPage.clickToLoginLink();
		
		System.out.println("Login_03 - step 2: Input to all required fields");
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Login_03 - step 3: Click to login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_03 - step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04 - step 1: Click to login link");
		loginPage.clickToLoginLink();
		
		System.out.println("Login_04 - step 2: Input to all required fields");
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox("");
		
		System.out.println("Login_04 - step 3: Click to login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_04 - step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.println("Login_05 - step 1: Click to login link");
		loginPage.clickToLoginLink();
		
		System.out.println("Login_05 - step 2: Input to all required fields");
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox("8247237");
		
		System.out.println("Login_05 - step 3: Click to login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login_05 - step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Login_Success() {
		System.out.println("Login_06 - step 1: Click to login link");
		loginPage.clickToLoginLink();
		
		System.out.println("Login_06 - step 2: Input to all required fields");
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Login_06 - step 3: Click to login button");
		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999);
	}
}
