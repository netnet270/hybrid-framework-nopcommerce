package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopCommerce.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage{
	private WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplay() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
	}
}
