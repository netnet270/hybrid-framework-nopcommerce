package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.admin.AdminManageCustomerPageUI;

public class AdminManageCustomerPageObject extends BasePage{
	private WebDriver driver;

	public AdminManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void closePopup() {
		if(isElementDisplayed(driver, AdminManageCustomerPageUI.POPUP)) {
			clickToElement(driver, AdminManageCustomerPageUI.CLOSE_POPUP_BUTTON);
		}
	}

	public void enterToHeaderByColumnName(String columnName, String valueToEnter) {
		int columnIndex = getElementsSize(driver, AdminManageCustomerPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForAllElementVisible(driver, AdminManageCustomerPageUI.TEXBOX_HEADER_BY_LABEL, String.valueOf(columnIndex));
		senkeyToElement(driver, AdminManageCustomerPageUI.TEXBOX_HEADER_BY_LABEL, valueToEnter, String.valueOf(columnIndex));
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminManageCustomerPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminManageCustomerPageUI.SEARCH_BUTTON);
	}

	public boolean isAccountCustomerDisplay(String userFullName, String userEmail) {
		waitForAllElementVisible(driver, AdminManageCustomerPageUI.ACCOUNT_CUSTOMER, userFullName, userEmail);
		return isElementDisplayed(driver, AdminManageCustomerPageUI.ACCOUNT_CUSTOMER, userFullName, userEmail);
	}
}
