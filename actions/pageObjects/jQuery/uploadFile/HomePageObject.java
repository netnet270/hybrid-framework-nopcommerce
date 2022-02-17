package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		
		for (WebElement startButton : startButtons) {
			startButton.click();
		}
	}

	public boolean isLinkFileUpLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.LINK_FILE_ULOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.LINK_FILE_ULOADED, fileName);
	}

	public boolean isImageFileUpLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_FILE_ULOADED, fileName);
		return isImageLoaded(driver, HomePageUI.IMAGE_FILE_ULOADED, fileName);
	}
}
