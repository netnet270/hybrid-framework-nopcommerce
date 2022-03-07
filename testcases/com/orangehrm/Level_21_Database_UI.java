package com.orangehrm;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGenerator;

public class Level_21_Database_UI extends BaseTest {
	protected WebDriver driver;
	protected LoginPageObject loginPage;
	protected DashboardPageObject dashboardPage;
	protected String adminUserName, adminPassword;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserName(browserName, url);
		loginPage = PageGenerator.getLoginPageObject(driver);

		adminUserName = "Admin";
		adminPassword = "admin123";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSytem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_Search() throws SQLException {
		log.info("Employee_Search - Step 1: Get Employee size on UI");
		int empoyeeNumberListUI = dashboardPage.getEmployeeListNumberUI();
		
		log.info("Employee_Search - Step 1: Get Employee size in DB");
		int empoyeeNumberListDB = dashboardPage.getEmployeeListNumberDB();

		log.info("Employee_Search - Step 1: Verify Employee Number List in UI and Db are equals");
		verifyEquals(empoyeeNumberListUI, empoyeeNumberListDB);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
