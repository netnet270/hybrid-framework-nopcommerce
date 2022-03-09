package com.orangehrm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.orangeHRM.AddEmployeePageObject;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.PersonalDetailsPageObject;
import pageObjects.orangeHRM.PhotographPageObject;

public class Level_22_Cloud_Testing_Browserstack extends BaseTest {
	protected WebDriver driver;
	protected LoginPageObject loginPage;
	protected DashboardPageObject dashboardPage;	
	protected EmployeeListPageObject employeeListPage;
	protected AddEmployeePageObject addEmployeePage;
	protected PersonalDetailsPageObject personalDetailsPage;
	protected PhotographPageObject photographPage;

	protected String statusValue, adminUserName, adminPassword, empFirstName, empLastName, empLastNameUpdate, empFullName, empUserName,
			empPassword, employeeID, avatarFilePath, genderValue, nationalityValue;

	@Parameters({"url", "osName", "osVersion" ,"browserName", "browserVersion"})
	@BeforeClass
	public void beforeClass(String url, String osName, String osVersion, String browserName, String browserVersion) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + url + "'");
		driver = getBrowserDriverBrowserstack(url, osName, osVersion, browserName, browserVersion);
		loginPage = PageGenerator.getLoginPageObject(driver);

		adminUserName = "Admin";
		adminPassword = "admin123";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSytem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_Employee_01 - Step 01: Open to 'Employee List' page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPageObject(driver);

		log.info("Add_New_Employee_01 - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonById(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePageObject(driver);

		log.info("Add_New_Employee_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxById(driver, "firstName", empFirstName);

		log.info("Add_New_Employee_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxById(driver, "lastName", empLastName);

		log.info("Add_New_Employee_01 - Step 05: Get value 'Employee ID' textbox");
		employeeID = addEmployeePage.getTextboxValue(driver, "employeeId");

		log.info("Add_New_Employee_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");

		log.info("Add_New_Employee_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxById(driver, "user_name", empUserName);

		log.info("Add_New_Employee_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxById(driver, "user_password", empPassword);

		log.info("Add_New_Employee_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxById(driver, "re_password", empPassword);

		log.info("Add_New_Employee_01 - Step 10: Select '" + statusValue + "' value in 'Status' dropdow");
		addEmployeePage.selectItemInDropdownById(driver, "status", statusValue);

		log.info("Add_New_Employee_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonById(driver, "btnSave");
		personalDetailsPage = PageGenerator.getPersonalDetailsPageObject(driver);

		log.info("Add_New_Employee_01 - Step 12: Open to 'Employee List' page");
		personalDetailsPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPageObject(driver);

		log.info("Add_New_Employee_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isPageLoadedSuccess(driver));
		employeeListPage.enterToTextboxById(driver, "empsearch_employee_name_empName", empFullName);
		verifyTrue(employeeListPage.isPageLoadedSuccess(driver));

		log.info("Add_New_Employee_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonById(driver, "searchBtn");
		verifyTrue(employeeListPage.isPageLoadedSuccess(driver));

		log.info("Add_New_Employee_01 - Step 15: Verify employee info displayed at 'Result table'");
		log.info("employeeID actual = " + employeeListPage.getValueAtTableIdByColumnNameAndRowIndex(driver, "resultTable", "Id", "1"));
		log.info("employeeID expect = " + employeeID);
		verifyEquals(employeeListPage.getValueAtTableIdByColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		
		log.info("First (& Middle) Name = " + employeeListPage.getValueAtTableIdByColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"));
		verifyEquals(employeeListPage.getValueAtTableIdByColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), empFirstName);

		log.info("Last Name = " + employeeListPage.getValueAtTableIdByColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"));
		verifyEquals(employeeListPage.getValueAtTableIdByColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), empLastName);
	}

	@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar_02 - Step 01: Login to system with Employee role");
		loginPage = employeeListPage.logoutToSytem(driver);
		dashboardPage = loginPage.loginToSytem(driver, empUserName, empPassword);
		
		log.info("Upload_Avatar_02 - Step 02: Open 'Personal Details' page");
		dashboardPage.openMenuPage(driver, "My Info");
		personalDetailsPage = PageGenerator.getPersonalDetailsPageObject(driver);
		
		log.info("Upload_Avatar_02 - Step 03: Click to Avatar image to change photo");
		photographPage = personalDetailsPage.clickToChangePhotoImage();
		
		log.info("Upload_Avatar_02 - Step 04: Upload avatar");
		photographPage.uploadAvatarImage(avatarFilePath);
		
		log.info("Upload_Avatar_02 - Step 05: Click to 'Upload' button");
		photographPage.clickToButtonById(driver, "btnSave");
		
		log.info("Upload_Avatar_02 - Step 06: Verify message success is displayed");
		verifyEquals(photographPage.getUploadFileSuccessMessage(), "Successfully Uploaded");
		
		log.info("Upload_Avatar_02 - Step 07: Verify new avatar is displayed");
		verifyTrue(photographPage.isAvatarUploadedSuccess());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		cleanBrowserAndDriver();
	}
}
