package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.User;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_19_Manage_Test_Data_Init_In_Java_Class extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
	}

	@Test
	public void User_01_Register() {
		log.info("User_01_Register - Step 1: Click to 'Register' link");
		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getUserRegisterPageOject(driver);
		
		log.info("User_01_Register - Step 2: Enter to 'Firstname' textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", User.Register.FIRST_NAME);
		
		log.info("User_01_Register - Step 3: Enter to 'Lastname' textbox");
		registerPage.enterToTextboxByID(driver, "LastName", User.Register.LAST_NAME);

		log.info("User_01_Register - Step 4: Enter to 'EmailAddress' textbox with value: " + User.Register.EMAIL_ADDRESS);
		registerPage.enterToTextboxByID(driver, "Email", User.Register.EMAIL_ADDRESS);

		log.info("User_01_Register - Step 5: Enter to 'Password' textbox with value: " + User.Register.PASSWORD);
		registerPage.enterToTextboxByID(driver, "Password", User.Register.PASSWORD);

		log.info("User_01_Register - Step 6: Enter to 'Confirm Password' textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", User.Register.PASSWORD);

		log.info("User_01_Register - Step 7: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("User_01_Register - Step 8: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("User_01_Register - Step 9: Click to 'Logout' link");		
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getUserHomePageObject(driver);
	}

	@Test
	public void User_02_Login() {
		log.info("User_02_Login - Step 1: Click to login link");
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getUserLoginPageObject(driver);

		log.info("User_02_Login - Step 2: Enter to 'EmailAddress' textbox with value: " + User.Register.EMAIL_ADDRESS);
		registerPage.enterToTextboxByID(driver, "Email", User.Register.EMAIL_ADDRESS);
		
		log.info("User_02_Login - Step 3: Enter to 'Password' textbox with value: " + User.Register.PASSWORD);
		registerPage.enterToTextboxByID(driver, "Password", User.Register.PASSWORD);

		log.info("User_02_Login - Step 4: Click to login button");
		registerPage.clickToButtonByText(driver, "Log in");
		
		log.info("User_02_Login - Step 5: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplay());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
