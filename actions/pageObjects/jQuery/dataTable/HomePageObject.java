package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToHeaderTextboxByLabel(String columnName, String valueToEnter) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, columnName);
		senkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, valueToEnter, columnName);
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementsSize(driver, HomePageUI.TOTAL_PAGINATION);
		
		List<String> allValueEachRowAtAllPage = new ArrayList<String>();
		
		for (int index = 1; index <= totalPage; index++) {
			openPagingByPageNumber(String.valueOf(index));
			
			List<WebElement> allRowAtEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			
			for (WebElement row : allRowAtEachPage) {
				allValueEachRowAtAllPage.add(row.getText());
			}
		}
		
		return allValueEachRowAtAllPage;
	}

	public List<String> getValueColumnAtAllPage(String columnName) {
		int totalPage = getElementsSize(driver, HomePageUI.TOTAL_PAGINATION);
		
		List<String> allValueColumnAtAllPage = new ArrayList<String>();
		
		for (int index = 1; index <= totalPage; index++) {
			openPagingByPageNumber(String.valueOf(index));
			
			List<WebElement> allValueColumnEachPage = getListWebElement(driver, HomePageUI.VALUE_COLUMN_ALL_PAGE, columnName);
			
			for (WebElement row : allValueColumnEachPage) {
				allValueColumnAtAllPage.add(row.getText());
			}
		}
		
		return allValueColumnAtAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToEnter) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDrodownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkTheCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckTheCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
	}
}
