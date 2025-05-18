package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FlightResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    public FlightResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//input[@id='oneway_flights_0']")
    WebElement directFilter;

    @FindBy(xpath = "(//button[contains(text(),'Select')])[1]")
    WebElement selectFlightButton;

    public void applyDirectFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(directFilter)).click();
    }

    public void selectFirstFlight() {
        wait.until(ExpectedConditions.elementToBeClickable(selectFlightButton)).click();
    }
}
