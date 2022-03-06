package pageUIs.orangeHRM;

public class BasePageOrangeUI {
	// Dynamic locator
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_MENU_PAGE_BY_NAME = "xpath=//div[@id='mainMenu']//a[string()='%s']";
	public static final String DYNAMIC_BUTTON_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[text()='%s']//following-sibling::input";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[text()='%s']//preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
	public static final String COLUMN_INDEX_AT_TABLE_ID_BY_NAME = "xpath=//table[@id='%s']//th[string()= '%s']//preceding-sibling::th";
	public static final String ITEM_AT_TABLE_ID_BY_ROW_INDEX_COLUMN_NAME = "xpath=//table[@id='%s']/tbody/tr[%s]/td[%s]";
	public static final String DYNAMIC_SIDE_MENU_PAGE_BY_NAME = "xpath=//div[@id='sidenav']//a[text()='%s']";

	// Hard locator
	public static final String USERNAME_LOGIN_TEXTBOX = "xpath=//input[@id='txtUsername']";
	public static final String PASSWORD_LOGIN_TEXTBOX = "xpath=//input[@id='txtPassword']";
	public static final String LOGIN_BUTTON = "xpath=//input[@id='btnLogin']";
	public static final String WELCOME_LINK = "xpath=//a[@id='welcome']";
	public static final String LOGOUT_LINK = "xpath=//a[text()='Logout']";
	
}
