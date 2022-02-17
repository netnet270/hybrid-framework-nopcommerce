package pageUIs.jQuery.uploadFile;

import common.BaseTest;

public class HomePageUI extends BaseTest {

	public static final String START_BUTTON = "css=table button.start";
	public static final String FILE_LOADED = "xpath=//p[@class='name' and text()='%s']";
	public static final String LINK_FILE_ULOADED = "xpath=//p[@class='name']/a[text()='%s']";
	public static final String IMAGE_FILE_ULOADED = "xpath=//table//td//a[@title='%s']/img";

}
