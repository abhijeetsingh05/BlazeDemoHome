package pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BaseTest;
import config.UtilityMethods;

public class BlazeDemoHomePage extends BaseTest {

	UtilityMethods util = new UtilityMethods();
	Logger logger = Logger.getLogger(Log.class.getName());

	@FindBy(xpath = "//select[@name='fromPort']")
	public WebElement departureCity;

	@FindBy(xpath = "//select[@name='toPort']")
	public WebElement destinationCity;

	@FindBy(xpath = "//input[@value='Find Flights']")
	public WebElement findFlightsBtn;
	
	@FindBy(xpath="//div[@class='container']/h1")
	public WebElement pageTitle;
	
	public BlazeDemoHomePage selectDeparatureCity(String city) {
		util.waitForElementToDisplay(departureCity);
		util.selectDropdownvalue(departureCity, city);
		return this;
	}
	
	public BlazeDemoHomePage selectDestinationCity(String city) {
		util.waitForElementToDisplay(destinationCity);
		util.selectDropdownvalue(destinationCity, city);
		return this;
	}
	
	public BlazeFlightReservePage clickOnFindFlights() {
		findFlightsBtn.click();
		return new BlazeFlightReservePage();
	}
	
	public BlazeDemoHomePage assertDemoPage() {
		util.waitForElementToDisplay(departureCity);
		Assert.assertEquals(getWebDriver().getTitle(), "BlazeDemo");
		return this;
	}
	
}
