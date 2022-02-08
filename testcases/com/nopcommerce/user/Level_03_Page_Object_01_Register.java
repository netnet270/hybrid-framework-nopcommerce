package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Page_Object_01_Register extends BasePage {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String firstName, lastName, emailAddress, password;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - step 1: Click to register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register_01 - step 2: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_01 - step 3: Verify error message displayed at required fields");
		Assert.assertEquals(registerPage.getErorMessageAtFirstnameTexbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - step 1: Click to register link");
		registerPage.clickToRegisterLink();

		System.out.println("Register_02 - step 2: Input to all required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123%^3132");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - step 3: Click to register button");
		registerPage.clickToRegisterButton();
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - step 1: Click to register link");
		registerPage.clickToRegisterLink();

		System.out.println("Register_03 - step 2: Input to all required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register_03 - step 5: Click to logout link");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Email_Exists() {
		System.out.println("Register_04 - step 1: Click to register link");
		homePage.clickToRegisterLink();

		System.out.println("Register_04 - step 2: Input to all required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - step 3: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_04 - step 4: Verify error existing email message displayed");
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Than_Less_6_Character() {
		System.out.println("Register_05 - step 1: Click to register link");
		registerPage.clickToRegisterLink();

		System.out.println("Register_05 - step 2: Input to all required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register_05 - step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - step 4: Verify error message displayed at password field");
		Assert.assertEquals(registerPage.getErorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - step 1: Click to register link");
		registerPage.clickToRegisterLink();

		System.out.println("Register_06 - step 2: Input to all required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("654321");

		System.out.println("Register_06 - step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - step 4: Verify error message displayed at confirm password field");
		Assert.assertEquals(registerPage.getErorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");
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
