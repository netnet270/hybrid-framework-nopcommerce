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

public class Level_01_Register_DRY {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		emailAddress = "afc" + getRandomNumber() + "@gmail.vn";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Empty_Data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),
				"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"Password is required.");
	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Autoation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("123@123%^3132");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();
	}

	@Test
	public void TC_03_Register_Success() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Autoation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		driver.findElement(By.cssSelector("a.ico-logout")).click();
	}

	@Test
	public void TC_04_Email_Exists() {
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Autoation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error ")).getText(),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Password_Than_Less_6_Character() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Autoation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");

		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Invalid_Confirm_Password() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Autoation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("654321");

		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
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
