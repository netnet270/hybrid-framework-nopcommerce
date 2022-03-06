package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.orangeHRM.PhotographPageUI;

public class PhotographPageObject extends BasePage {
	WebDriver driver;

	public PhotographPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void uploadAvatarImage( String filePath) {
		senkeyToElement(driver, PhotographPageUI.UPLOAD_FILE, filePath);
	}
	
	public String getUploadFileSuccessMessage() {
		waitForElementVisible(driver, PhotographPageUI.UPLOAD_FILE_SUCCESS_MESSAGE);
		return getTextElement(driver, PhotographPageUI.UPLOAD_FILE_SUCCESS_MESSAGE).trim();
	}
	
	public boolean isAvatarUploadedSuccess() {
		int widthImage = Integer.parseInt(getAttributeValue(driver, PhotographPageUI.AVATAR_IMAGE, "width")); 
		int heightImage = Integer.parseInt(getAttributeValue(driver, PhotographPageUI.AVATAR_IMAGE, "height")); 
		return (widthImage!= 200) || (heightImage!= 200);
	}
}
