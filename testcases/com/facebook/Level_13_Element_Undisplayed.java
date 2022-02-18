package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		loginPage = PageGeneratorManager.getLoginPageObject(driver);

		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
	}

	@Test
	public void TC_01_ELement_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		
		loginPage.EnterToEmailAddress(emailAddress);
		loginPage.sleepInSecond(3);
		
		verifyTrue(loginPage.isConfirmEmailAdressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_ELement_Undisplayed_In_DOM() {
		loginPage.EnterToEmailAddress("");
		loginPage.sleepInSecond(3);

		verifyFalse(loginPage.isConfirmEmailAdressTextboxDisplayed());
	}
	
	@Test
	public void TC_03_ELement_Undisplayed_Not_In_DOM_I() {
		loginPage.closeToRegisterPopup();
		loginPage.sleepInSecond(3);

		loginPage.overrideImplicitlyGlobalTimeout(driver, GlobalConstants.SHORT_TIME);
		verifyFalse(loginPage.isConfirmEmailAdressTextboxDisplayed());
		loginPage.overrideImplicitlyGlobalTimeout(driver, GlobalConstants.LONG_TIME);
	}
	
	@Test
	public void TC_03_ELement_Undisplayed_Not_In_DOM_II() {
		loginPage.closeToRegisterPopup();
		loginPage.sleepInSecond(3);

		verifyTrue(loginPage.isConfirmEmailAdressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	LoginPageObject loginPage;
	String emailAddress;
}
