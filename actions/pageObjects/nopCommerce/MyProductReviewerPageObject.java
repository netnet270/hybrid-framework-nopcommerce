package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class MyProductReviewerPageObject extends BasePage{
	WebDriver driver;
	
	public MyProductReviewerPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
