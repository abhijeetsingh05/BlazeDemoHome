package config;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;

public class UtilityMethods extends BaseTest {

	Logger logger = Logger.getLogger(Log.class.getName());
	
	public void selectDropdownvalue(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (TimeoutException e) {
			logger.error("Element " + element + " not displayed after waiting for 20 seconds", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
	}

	public void waitForElementToDisplay(WebElement element) {
		try {
			logger.info("waiting for specified element to display");
			WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			logger.error("Element " + element + " not displayed after waiting for 20 seconds", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
	}
	
	public String getPageTitle() {
		return getWebDriver().getTitle();
	}

}
