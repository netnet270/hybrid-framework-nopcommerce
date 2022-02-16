package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		sleepInSecond(2);
		
		homePage.openPagingByPageNumber("8");
		Assert.assertTrue(homePage.isPageNumberActived("8"));
		sleepInSecond(2);

		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		sleepInSecond(2);

		homePage.openPagingByPageNumber("2");
		Assert.assertTrue(homePage.isPageNumberActived("2"));
		sleepInSecond(2);

	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "123456");
		homePage.enterToHeaderTextboxByLabel("Males", "789");
		homePage.enterToHeaderTextboxByLabel("Total", "9999");
	}
	
	@Test
	public void Table_03_Get_Value_At_All_Page() {
		System.out.println(homePage.getValueEachRowAtAllPage());
		
		System.out.println(homePage.getValueColumnAtAllPage("country"));
	}
	
	
	@Test
	public void Table_04_Enter_To_Cell() {
		homePage.clickToLoadDataButton();
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Album", "1", "John Matt");
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "2", "Thomas");
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Year", "4", "1997");
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Price", "5", "200");
		
		homePage.selectDrodownByColumnNameAtRowNumber("Origin", "1", "US");
		
		homePage.selectDrodownByColumnNameAtRowNumber("Origin", "5", "Japan");
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
