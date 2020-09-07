package pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseTest;
import config.UtilityMethods;

public class BlazeFlightReservePage extends BaseTest {
	
	UtilityMethods util = new UtilityMethods();
	Logger logger = Logger.getLogger(Log.class.getName());

	@FindBy(xpath = "//table/thead/tr/th[4]")
	WebElement departsColumn;

	@FindBy(xpath = "//table/thead/tr/th[5]")
	WebElement arrivesColumn;
	
	@FindBy(xpath="(//input[@value='Choose This Flight'])[1]")
	WebElement chooseFlight;
	

	public void validateFlightSearchDetails(String departure, String arrival) {
		Assert.assertTrue(departsColumn.getText().contains(departure) && arrivesColumn.getText().contains(arrival));
	}
	
	public BlazeFlightReservePage assertReservePage() {
		Assert.assertEquals(getWebDriver().getTitle(), "BlazeDemo - reserve");
		return this;
	}
	
	public BlazeDemoPurchasePage chooseFilghtbtn() {
		util.waitForElementToDisplay(chooseFlight);
		chooseFlight.click();
		return new BlazeDemoPurchasePage();		
	}
	
}
