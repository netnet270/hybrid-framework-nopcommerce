package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static EmployeeListPageObject getEmployeeListPageObject(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}
	
	public static AddEmployeePageObject getAddEmployeePageObject(WebDriver driver) {
		return new AddEmployeePageObject(driver);
	}
	
	public static PersonalDetailsPageObject getPersonalDetailsPageObject(WebDriver driver) {
		return new PersonalDetailsPageObject(driver);
	}
	
	public static PhotographPageObject getPhotographPageObject(WebDriver driver) {
		return new PhotographPageObject(driver);
	}
}
