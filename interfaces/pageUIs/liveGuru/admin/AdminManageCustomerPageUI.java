package pageUIs.liveGuru.admin;

public class AdminManageCustomerPageUI {
	public static final String SEARCH_BUTTON = "css=button[title='Search']";
	public static final String COLUMN_INDEX_BY_NAME= "xpath=//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String TEXBOX_HEADER_BY_LABEL = "xpath=//thead/tr[@class='filter']/th[%s]//input";
	public static final String ACCOUNT_CUSTOMER = "xpath=//td[contains(text(), '%s')]/following-sibling::td[contains(text(), '%s']";
	public static final String POPUP = "css=#message-popup-window";
	public static final String CLOSE_POPUP_BUTTON = "css=#message-popup-window a[title='close']";
}
