package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import config.BrowserSetup;
import config.ConfigReader;
import config.UtilityMethods;
import pages.BlazeDemoHomePage;
import pages.BlazeFlightReservePage;

public class BlazeDemoHomeTest extends BrowserSetup {

	Logger logger = Logger.getLogger(BlazeDemoHomeTest.class);
	UtilityMethods util = new UtilityMethods();
	
	/*
	 * Verify the user is able to select and choose the departure city from drop-down.
	 * Verify the user is able to select and choose the destination city from drop-down.
	 * Verify use is able to click on Find Flight button.
	 * After clicking on Flight Button application should redirect to flights listing page.
	 * Verify that search results have flight details, timings and availability based on the selection criteria.
	 * Verify that clicking the Chose a Flight button open complete details for flight.
	 * Verify that the pricing of the selected flight is same as flight listing page.
	 * Verify the validation of the requiered field for flight booking.
	 * Verify that after entering passenger details, payment details and after clicking the Purchase Flight button seat get booked.
	 * Verify that on successful booking the ticket details should be visible with all the details. 
	 */

	@Test(priority=0)
	public void searchFlight() {
		
		BlazeDemoHomePage homePage = new BlazeDemoHomePage();

		homePage.assertDemoPage()
				.selectDeparatureCity(ConfigReader.departureCity)
				.selectDestinationCity(ConfigReader.destinationCity)
				.clickOnFindFlights()
				.validateFlightSearchDetails(ConfigReader.departureCity, ConfigReader.destinationCity);
	}
	
	@Test(priority=1)
	public void bookFlight() {
	
		BlazeFlightReservePage reserverFlight = new BlazeFlightReservePage();
		
	  reserverFlight.assertReservePage()
					.chooseFilghtbtn()
					.assertPurchasePage()
					.clickOnPurchaseFlight()
					.validateConfirmationId();
	}
	
	@BeforeTest
	public void browserSetup() throws Exception {
		// method used to read properties file values
		ConfigReader.readConfigData();
		System.out.println(ConfigReader.browser);
		InitializeBrowser(ConfigReader.browser);
		getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		logger.info("-----maximizing the browser window-----");
		BaseTest.getWebDriver().manage().window().maximize();
		logger.info("Navigated to Blaze Demo Website");
		BaseTest.getWebDriver().get(ConfigReader.url);
	}

	@AfterTest
	public void tearDown() {
		logger.info("-----closing down browser window-----");
		BaseTest.getWebDriver().quit();
	}
}
