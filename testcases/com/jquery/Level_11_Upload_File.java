package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_File extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	
	String dalatName = "Dalat.jpg";
	String hanoiName = "HaNoi.jpg";
	String hueName = "Hue.jpg";
	String[] multipleFileName = { dalatName, hanoiName, hueName };

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_01_Upload_Single_File() {
		homePage.uploadMultipleFiles(driver, dalatName);
		
		Assert.assertTrue(homePage.isFileLoaded(dalatName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isLinkFileUpLoaded(dalatName));
		
		Assert.assertTrue(homePage.isImageFileUpLoaded(dalatName));
	}
	
	@Test
	public void TC_02_Upload_Multiple_File() {
		homePage.refreshToPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileName);
		
		Assert.assertTrue(homePage.isFileLoaded(dalatName));
		Assert.assertTrue(homePage.isFileLoaded(hanoiName));
		Assert.assertTrue(homePage.isFileLoaded(hueName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isLinkFileUpLoaded(dalatName));
		Assert.assertTrue(homePage.isLinkFileUpLoaded(hanoiName));
		Assert.assertTrue(homePage.isLinkFileUpLoaded(hueName));
		
		Assert.assertTrue(homePage.isImageFileUpLoaded(dalatName));
		Assert.assertTrue(homePage.isImageFileUpLoaded(hanoiName));
		Assert.assertTrue(homePage.isImageFileUpLoaded(hueName));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
