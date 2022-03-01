package pageObjects.swaglabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.swaglabs.InvestoryPageUI;

public class InvestoryPageObject extends BasePage {
	WebDriver driver;
	
	public InvestoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String itemValue) {
		waitForElementClickable(driver, InvestoryPageUI.SORT_DROPDOWN);
		selectItemInDropdown(driver, InvestoryPageUI.SORT_DROPDOWN, itemValue);
	}

	public boolean isProductNameSort(String sortType) {
		List<WebElement> productNameElements = getListWebElement(driver, InvestoryPageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameTexts = new ArrayList<String>();
		
		for (WebElement productName : productNameElements) {
			productNameTexts.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameTexts);
		Collections.sort(productNameTextClone);
		
		if(sortType == "DESC") Collections.reverse(productNameTextClone);
		
		return productNameTexts.equals(productNameTextClone);
	}

	public boolean isProductPriceSort(String sortType) {
		List<WebElement> productPriceElements = getListWebElement(driver, InvestoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceTexts = new ArrayList<Float>();
		
		for (WebElement productPrice : productPriceElements) {
			productPriceTexts.add(Float.parseFloat(productPrice.getText().substring(1).trim()));
		}
		
		List<Float> productPriceTextClone = new ArrayList<Float>(productPriceTexts);
		Collections.sort(productPriceTextClone);

		if(sortType == "DESC") Collections.reverse(productPriceTextClone);
		
		return productPriceTexts.equals(productPriceTextClone);
	}
}
