package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.WebDriverSetup;

public class FlightBookingTest {
    WebDriver driver;
    HomePage homePage;
    FlightsPage flightsPage;
    FlightResultsPage resultsPage;
    BookingPage bookingPage;
    ConfirmationPage confirmationPage;

    @BeforeClass
    public void setup() {
        // Initialize WebDriver and page objects
        driver = WebDriverSetup.getDriver();
        driver.manage().window().maximize();
        driver.get("https://phptravels.net/");
        driver.manage().deleteAllCookies();

        // Refresh or continue with your test
        driver.navigate().refresh();

        // Page object initialization
        homePage = new HomePage(driver);
        flightsPage = new FlightsPage(driver);
        resultsPage = new FlightResultsPage(driver);
        bookingPage = new BookingPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @Test
    public void bookFlightTest() throws InterruptedException {
        // Step 1: Go to Flights tab and enter flight details
        homePage.clickFlightsTab();
        flightsPage.enterFlightDetails("LHR - London Heathrow Airport", "DXB - Dubai International Airport", "2025-05-22");
        flightsPage.clickSearch();

        // Step 2: Apply direct filter and select first flight
        resultsPage.applyDirectFilter();
        resultsPage.selectFirstFlight();

        // Step 3: Fill in personal and traveler details
        bookingPage.enterPersonalInformation("Amal", "Perera", "amal@example.com", "0123456789", "123 Main St", "Sri Lanka", "Sri Lanka");
        bookingPage.enterTravellerInformation("Amal", "Perera", "Sri Lanka","07 Jul", "14", "1990", "N1234567", "amal@example.com", "0123456789");

        // Step 4: Select Pay Later and confirm booking
        bookingPage.selectPaymentMethod();
        bookingPage.confirmBooking();

        confirmationPage.verifyReceiptDetails();
        confirmationPage.printReceiptDetails();
        confirmationPage.captureScreenshot("D:\\QA\\HotelGuestBooking-automation\\phptravels-automation\\src\\screenshots");

    }

    @AfterClass
    public void tearDown() {
        // Close the driver after the test
        if (driver != null) {
            driver.quit();
        }
    }


}
