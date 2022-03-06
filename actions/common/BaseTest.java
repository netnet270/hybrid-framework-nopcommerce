package common;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
  private WebDriver driver;
  protected final Log log;
  
  protected BaseTest() {
    log = LogFactory.getLog(getClass());
  }
  
  public WebDriver getDriver() {
    return this.driver;
  }
  
  public enum BrowserList {
    CHROME, FIREFOX, IE, EDGE, SAFARI, OPERA, H_CHROME, H_FIREFOX;
  }
  
  public enum EnviromentList {
	  DEV, TESTING, STAGING;
  }
  
  protected WebDriver getBrowserName(String browserName) {
    BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
    
    if (browser == BrowserList.FIREFOX) {
      WebDriverManager.firefoxdriver().setup();
      
      FirefoxProfile profile = new FirefoxProfile();
      File extensionFile = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\translate-4.2.0-fx.xpi");
      profile.addExtension(extensionFile);
      FirefoxOptions options = new FirefoxOptions();
      options.setProfile(profile);
      
      driver = new FirefoxDriver(options);
      
    } else if (browser == BrowserList.H_FIREFOX) {
      WebDriverManager.chromedriver().setup();
      FirefoxOptions options = new FirefoxOptions();
      options.setHeadless(true);
      
      driver = new FirefoxDriver(options);
    } else if (browser == BrowserList.CHROME) {
      WebDriverManager.chromedriver().setup();
      
      File extensionFile = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\translate_2_0_11_0.crx");
      ChromeOptions options = new ChromeOptions();
      options.addExtensions(extensionFile);
      
      driver = new ChromeDriver(options);
    } else if (browser == BrowserList.H_CHROME) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless");
      options.addArguments("window-size=1366x768");
      
      driver = new ChromeDriver(options);
    } else if (browser == BrowserList.EDGE) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    } else if (browser == BrowserList.IE) {
      WebDriverManager.iedriver().arch32().setup();
      driver = new InternetExplorerDriver();
    } else {
      throw new RuntimeException("Invalid browser name.");
    }
    
    driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(GlobalConstants.USER_NOPCOMMERCE_PAGE_URL);
    return driver;
  }
  
  protected WebDriver getBrowserName(String browserName, String url) {
    BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
    
    if (browser == BrowserList.FIREFOX) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
      
    } else if (browser == BrowserList.H_FIREFOX) {
      WebDriverManager.chromedriver().setup();
      FirefoxOptions options = new FirefoxOptions();
      options.setHeadless(true);
      
      driver = new FirefoxDriver(options);
    } else if (browser == BrowserList.CHROME) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser == BrowserList.H_CHROME) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless");
      options.addArguments("window-size=1366x768");
      
      driver = new ChromeDriver(options);
    } else if (browser == BrowserList.EDGE) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    } else if (browser == BrowserList.IE) {
      WebDriverManager.iedriver().arch64().setup();
      driver = new EdgeDriver();
    } else {
      throw new RuntimeException("Invalid browser name.");
    }
    
    driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(url);
    return driver;
  }
  
  protected String getEnviroment(String envName) {
	String url = null;
	EnviromentList enviroment = EnviromentList.valueOf(envName.toUpperCase());
	
	if(enviroment == EnviromentList.DEV) {
		url = "https://www.demo.guru99.com/v1";
	} else if (enviroment == EnviromentList.TESTING) {
		url = "https://www.demo.guru99.com/v2";
	}  else if (enviroment == EnviromentList.STAGING) {
	  url = "https://www.demo.guru99.com/v3";
	} 
	return url;
  }
  
  protected int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(999);
  }
  
  protected boolean verifyTrue(boolean condition) {
    boolean pass = true;
    try {
      Assert.assertTrue(condition);
      log.info(" -------------------------- PASSED -------------------------- ");
    } catch (Throwable e) {
      pass = false;
      log.info(" -------------------------- FAILED -------------------------- ");
      VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
      Reporter.getCurrentTestResult().setThrowable(e);
    }
    return pass;
  }
  
  protected boolean verifyFalse(boolean condition) {
    boolean pass = true;
    try {
      Assert.assertFalse(condition);
      log.info(" -------------------------- PASSED -------------------------- ");
    } catch (Throwable e) {
      pass = false;
      log.info(" -------------------------- FAILED -------------------------- ");
      VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
      Reporter.getCurrentTestResult().setThrowable(e);
    }
    return pass;
  }
  
  protected boolean verifyEquals(Object actual, Object expected) {
    boolean pass = true;
    try {
      Assert.assertEquals(actual, expected);
      log.info(" -------------------------- PASSED -------------------------- ");
    } catch (Throwable e) {
      pass = false;
      log.info(" -------------------------- FAILED -------------------------- ");
      VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
      Reporter.getCurrentTestResult().setThrowable(e);
    }
    return pass;
  }
  
  protected void cleanBrowserAndDriver() {
    String cmd = "";
    try {
      String osName = System.getProperty("os.name").toLowerCase();
      log.info("OS name = " + osName);
      
      String driverInstanceName = driver.toString().toLowerCase();
      log.info("Driver instance name = " + osName);
      
      if (driverInstanceName.contains("chrome")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
        } else {
          cmd = "pkill chromedriver";
        }
      } else if (driverInstanceName.contains("internetexplorer")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
        }
      } else if (driverInstanceName.contains("firefox")) {
        if (osName.contains("windows")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
        } else {
          cmd = "pkill geckodriver";
        }
      } else if (driverInstanceName.contains("edge")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
        } else {
          cmd = "pkill msedgedriver";
        }
      } else if (driverInstanceName.contains("opera")) {
        if (osName.contains("window")) {
          cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
        } else {
          cmd = "pkill operadriver";
        }
      } else if (driverInstanceName.contains("safari")) {
        if (osName.contains("mac")) {
          cmd = "pkill safaridriver";
        }
      }
      
      if (driver != null) {
        driver.manage().deleteAllCookies(); // IE browser
        driver.quit();
        System.out.println("Close driver instance");
      }
    } catch (Exception e) {
      log.info(e.getMessage());
    } finally {
      try {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        System.out.println("Run command line");
        
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
