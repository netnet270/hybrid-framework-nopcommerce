package pageObjects.swaglabs;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static InvestoryPageObject getInvestoryPageObject(WebDriver driver) {
		return new InvestoryPageObject(driver);
	}
}
