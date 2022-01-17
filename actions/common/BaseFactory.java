package common;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFactory {
	public static BaseFactory getBasePageObject() {
		return new BaseFactory();
	}
	
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getTile(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void ForwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}


	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void senkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getTextElement(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected WebElement waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		return explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected List<WebElement> waitForAllElementVisible(WebDriver driver, List<WebElement> listElement) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		return explicitWait.until(ExpectedConditions.visibilityOfAllElements(listElement));
	}
	
	protected Boolean waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		return explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected Boolean waitForElementAllInvisible(WebDriver driver, List<WebElement> listElement) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(listElement));
	}
	
	protected WebElement waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private int longTime = 30;
}
