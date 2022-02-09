package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_02_Login extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, invalidEmail, notFoundEmail, existEmail, password;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "afc@333@$##$";
		existEmail = "afc" + getRandomNumber() + "@gmail.vn";
		notFoundEmail = "afc" + getRandomNumber() + "@gmail.com";

		System.out.println("Pre-Condition - step 1: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Pre-Condition - step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-Condition - step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Pre-Condition - step 4: Verify success mesage displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Pre-Condition - step 5: Click to logout link");
		registerPage.clickToLogoutLink();
		
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - step 1: Click to login link");
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
		homePage.clickToLoginLink();
		
		loginPage = new UserLoginPageObject(driver);
		
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
		homePage.clickToLoginLink();
		
		loginPage = new UserLoginPageObject(driver);

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
		homePage.clickToLoginLink();
		
		loginPage = new UserLoginPageObject(driver);

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
		homePage.clickToLoginLink();
		
		loginPage = new UserLoginPageObject(driver);

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
		homePage.clickToLoginLink();
		
		loginPage = new UserLoginPageObject(driver);

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
}
