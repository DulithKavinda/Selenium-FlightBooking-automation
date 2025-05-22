package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class ConfirmationPage {
    WebDriver driver;
    WebDriverWait wait;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // Example receipt elements — adjust the locators based on actual DOM
    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/th[1]")
    WebElement bookingId;

    @FindBy(xpath = "//table[contains(@class, 'table-bordered')]//th[@class='text-end']/strong")
    WebElement totalAmount;

    @FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[3]/table[2]/tbody[1]/tr[1]/th[3]")
    WebElement passengerName;

    /* Verifies if booking receipt and extracts key details*/

    public boolean verifyReceiptDetails() {
        try {
            return bookingId.isDisplayed() && totalAmount.isDisplayed() && passengerName.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*Logs booking details */
    public void printReceiptDetails() {
        System.out.println("Booking ID: " + bookingId.getText());
        System.out.println("Passenger Name: " + passengerName.getText());
        System.out.println("Total Amount: " + totalAmount.getText());
    }

    /*Captures a screenshot of the confirmation receipt.*/
    public void captureScreenshot(String filePath) {
        File destFile = new File(filePath);
        File parentDir = destFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
