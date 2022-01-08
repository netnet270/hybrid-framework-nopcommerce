package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;

public class Level_02_Apply_BasePage_I {
	WebDriver driver;
	String emailAddress;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		basePage = new BasePage();

		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Empty_Data() {
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");
	}

	@Test
	public void TC_02_Invalid_Email() {
		basePage.refreshToPage(driver);
		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Autoation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senkeyToElement(driver, "//input[@id='Email']", "123@123%^3132");
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		basePage.clickToElement(driver, "//button[@id='register-button']");
	}

	@Test
	public void TC_03_Register_Success() {
		basePage.refreshToPage(driver);
		
		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Autoation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='result']"), "Your registration completed");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_Email_Exists() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Autoation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getTextElement(driver, "//div[contains(@class, 'message-error')]"), "The specified email already exists");
	}

	@Test
	public void TC_05_Password_Than_Less_6_Character() {
		basePage.refreshToPage(driver);
		
		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Autoation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Invalid_Confirm_Password() {
		basePage.refreshToPage(driver);
		
		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Autoation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");

		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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
