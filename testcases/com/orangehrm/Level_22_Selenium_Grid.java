package com.orangehrm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGenerator;

public class Level_22_Selenium_Grid extends BaseTest {
	protected WebDriver driver;
	protected LoginPageObject loginPage;
	protected DashboardPageObject dashboardPage;
	protected String adminUserName, adminPassword;

	@Parameters({"browser", "url", "ipAddess", "port"})
	@BeforeClass
	public void beforeClass(String browserName, String url, String ipAddess, String port) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserDriverLocal(browserName, url, ipAddess, port);
		loginPage = PageGenerator.getLoginPageObject(driver);

		adminUserName = "Admin";
		adminPassword = "admin123";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSytem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_Employee_01 - Open to 'Employee List' page");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
