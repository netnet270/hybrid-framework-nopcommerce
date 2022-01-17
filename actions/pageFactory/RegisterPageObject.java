package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BaseFactory;

public class RegisterPageObject extends BaseFactory{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastnameTextbox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstnameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastnameErrorMessage;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emalErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//div[contains(@class, 'message-error')]")
	private WebElement existEmailErrorMessagere;
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement loginLink;
	
	public String getErorMessageAtFirstnameTexbox() {
		waitForElementVisible(driver, firstnameErrorMessage);
		return getTextElement(driver, firstnameErrorMessage);
	}

	public String getErorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastnameErrorMessage);
		return getTextElement(driver, lastnameErrorMessage);
	}

	public String getErorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emalErrorMessage);
		return getTextElement(driver, emalErrorMessage);
	}

	public String getErorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getTextElement(driver, passwordErrorMessage);
	}

	public String getErorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getTextElement(driver, confirmPasswordErrorMessage);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink); 
	}

	public void inputToFirstNameTextbox(String firstName) {
		senkeyToElement(driver, firstnameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		senkeyToElement(driver, lastnameTextbox, lastName);		
	}

	public void inputToEmailTextbox(String email) {
		senkeyToElement(driver, emailTextbox, email);		
	}

	public void inputToPasswordTextbox(String password) {
		senkeyToElement(driver, passwordTextbox, password);		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		senkeyToElement(driver, confirmPasswordTextbox, confirmPassword);		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getTextElement(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, existEmailErrorMessagere);
		return getTextElement(driver, existEmailErrorMessagere);
	}
}
