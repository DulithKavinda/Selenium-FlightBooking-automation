package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FlightsPage {
    WebDriver driver;
    WebDriverWait wait;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@name='from']")
    WebElement fromInput;

    @FindBy(xpath = "//input[@name='to']")
    WebElement toInput;

    @FindBy(xpath = "//input[@id='departure']")
    WebElement departureDateInput;

    @FindBy(xpath = "//button[@id='flights-search']")
    WebElement searchButton;

    public void enterFlightDetails(String from, String to, String departureDate) {
        wait.until(ExpectedConditions.elementToBeClickable(fromInput)).click();
        fromInput.sendKeys(from);
        wait.until(ExpectedConditions.visibilityOf(fromInput)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(toInput)).click();
        toInput.sendKeys(to);
        wait.until(ExpectedConditions.visibilityOf(toInput)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        departureDateInput.clear();
        departureDateInput.sendKeys(departureDate);
    }

    public void clickSearch() {
        searchButton.click();
    }
}
