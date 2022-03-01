package com.swalabs.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.swaglabs.InvestoryPageObject;
import pageObjects.swaglabs.LoginPageObject;
import pageObjects.swaglabs.PageGeneratorManager;

public class Level_19_Sort_ASC_DESC extends BaseTest {
	protected WebDriver driver;
	LoginPageObject loginPage;
	InvestoryPageObject investoryPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserName(browserName, url);
		
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToUPasswordTextbox("secret_sauce");
		investoryPage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Sort_Name() {
		investoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(investoryPage.isProductNameSort("ASC"));
		
		investoryPage.selectItemInSortDropdown("Name (Z to A)");
		verifyTrue(investoryPage.isProductNameSort("DESC"));

	}
	
	@Test
	public void TC_02_Sort_Price() {
		investoryPage.selectItemInSortDropdown("Price (low to high)");
		verifyTrue(investoryPage.isProductPriceSort("ASC"));
		
		investoryPage.selectItemInSortDropdown("Price (high to low)");
		verifyTrue(investoryPage.isProductPriceSort("DESC"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
