package config;

import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup extends BaseTest {

	RemoteWebDriver driver = null;
	Logger logger = Logger.getLogger(Log.class.getName());

	public void InitializeBrowser(String type) throws MalformedURLException {
		try {
			switch (type.toLowerCase()) {
			case "chrome":
				logger.info("-----browser invoking-----");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				// setting up chrome driver exe through Webdriver manager
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				BaseTest.setWebDriverLocal(driver);
				break;
			case "firefox":
				logger.info("-----browser invoking-----");
				// setting up firefox driver exe through Webdriver manager
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				BaseTest.setWebDriverLocal(driver);
				break;
			default:
				logger.error("Please configure your browser in the globalConfig file");
			}
		} catch (NullPointerException ne) {
			// TODO Auto-generated catch block
			logger.error("Please configure your browser in the globalConfig file", ne);
		} catch (Exception e) {
			logger.error("Please configure your browser in the globalConfig file", e);
		}
	}

}
