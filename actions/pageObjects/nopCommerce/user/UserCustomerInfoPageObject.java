package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage{
	private WebDriver driver;
	
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplay() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
	}
}
