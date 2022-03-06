package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.orangeHRM.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BasePage {
	WebDriver driver;

	public PersonalDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public PhotographPageObject clickToChangePhotoImage() {
		waitForElementVisible(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		clickToElement(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		return PageGenerator.getPhotographPageObject(driver);
	}
}
