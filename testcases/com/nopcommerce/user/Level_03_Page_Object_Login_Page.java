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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Login_Page extends BasePage {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	String firstName, lastName, invalidEmail, notFoundEmail, existEmail, password;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		registerPage = new RegisterPageObject(driver);
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
	public void TC_01_Empty_Data() {
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_Not_Found_Email() {
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Existing_Email_Empty_Password() {
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void TC_05_Existing_Email_Incorrect_Password() {
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox("8247237");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Success() {
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
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
