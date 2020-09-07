package pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseTest;
import config.UtilityMethods;

public class BlazeDemoPurchasePage extends BaseTest {
	
	UtilityMethods util = new UtilityMethods();
	Logger logger = Logger.getLogger(Log.class.getName());
	
	@FindBy(xpath="//input[@value='Purchase Flight']")
	WebElement purchaseFlight;
	
	public BlazeDemoConfirmationPage clickOnPurchaseFlight() {
		util.waitForElementToDisplay(purchaseFlight);
		purchaseFlight.click();	
		return new BlazeDemoConfirmationPage();
	}
	
	public BlazeDemoPurchasePage assertPurchasePage() {
		Assert.assertEquals(getWebDriver().getTitle(), "BlazeDemo Purchase");
		return this;
	}

}
