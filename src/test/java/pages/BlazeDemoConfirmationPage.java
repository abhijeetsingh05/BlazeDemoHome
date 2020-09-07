package pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseTest;
import config.UtilityMethods;

public class BlazeDemoConfirmationPage extends BaseTest{
	
	UtilityMethods util = new UtilityMethods();
	Logger logger = Logger.getLogger(Log.class.getName());
	
	@FindBy(xpath="//td[contains(text(),'Id')]/../td[2]")
	WebElement getIdConfirmation;
	
	public void validateConfirmationId() {
		Assert.assertFalse(getIdConfirmation.getText().isEmpty());
	}
	
	public void assertPurchasePage() {
		Assert.assertEquals(getWebDriver().getTitle(), "BlazeDemo Purchase");
	}

}
