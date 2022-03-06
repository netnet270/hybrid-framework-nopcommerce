package com.bankguru;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.Enviroment;

public class Level_20_Multiple_Enviroment extends BaseTest {
	WebDriver driver;
	Enviroment env;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		env = ConfigFactory.create(Enviroment.class);
		
		log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + env.appUrl() + "'");
		driver = getBrowserName(browserName, env.appUrl());
		System.out.println(env.appUrl());
	}

	@Test
	public void User_01_Register() {
		log.info("Register_01");
	}

	@Test
	public void User_02_Login() {
		log.info("Login_02");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
