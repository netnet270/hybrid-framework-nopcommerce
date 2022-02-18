package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_12_Assert_Verify extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		userHomePage = PageGeneratorManager.getUserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
	}

	@Test
	public void User_01_Register() {
		System.out.println("User_01 - step 1: Click to Register link");
		registerPage = userHomePage.clickToRegisterLink();
		
		System.out.println("User_01 - step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("User_01 - step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("User_01 - step 4: Verify success mesage displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("User_01 - step 5: Click to logout link");
		userHomePage = registerPage.clickToLogoutLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, emailAddress, password;
}
