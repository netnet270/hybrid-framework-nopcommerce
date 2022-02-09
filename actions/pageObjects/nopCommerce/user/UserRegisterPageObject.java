package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getErorMessageAtFirstnameTexbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK); 
	}

	public void inputToFirstNameTextbox(String firstName) {
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);		
	}

	public void inputToEmailTextbox(String email) {
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputToPasswordTextbox(String password) {
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}

	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
	}
}
