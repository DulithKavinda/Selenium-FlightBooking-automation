package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class BookingPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    // Personal Information
    @FindBy(name = "user[first_name]")
    WebElement firstName;

    @FindBy(name = "user[last_name]")
    WebElement lastName;

    @FindBy(name = "user[email]")
    WebElement email;

    @FindBy(name = "user[phone]")
    WebElement phone;

    @FindBy(name = "user[address]")
    WebElement address;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select nationality w-100']//div[@class='filter-option']")
    WebElement nationalitylist;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//input[@aria-label='Search']")
    WebElement nationality;

    @FindBy(xpath = "//span[contains(text(),'Sri Lanka')]")
    WebElement nationalityselect;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select country w-100']//div[@class='filter-option']")
    WebElement countrylist;
    @FindBy(xpath = "//div[@class='dropdown-menu show']//input[@aria-label='Search']")
    WebElement country;

    @FindBy(xpath = "//a[@id='bs-select-2-200']//span[@class='text-dark'][normalize-space()='Sri Lanka']")
    WebElement countryselect;


    // Traveller Information
    @FindBy(name = "first_name_1")
    WebElement travellerFirstName;

    @FindBy(name = "last_name_1")
    WebElement travellerLastName;
    @FindBy(name = "nationality_1")
    WebElement nationalitydropdown;



    // Similarly for DOB dropdowns
    @FindBy(name = "dob_month_1")
    WebElement dobdropdown;

    @FindBy(name = "dob_day_1")
    WebElement daydropdown;

    @FindBy(name = "dob_year_1")
    WebElement yeardropdown;






    @FindBy(name = "passport_1")
    WebElement travellerPassport;

    @FindBy(name = "email_1")
    WebElement travellerEmail;

    @FindBy(name = "phone_1")
    WebElement travellerPhone;

    // Payment
    @FindBy(xpath = "//div[@class='col-md-12 mb-1 gateway_pay_later']//div[@id='pills-home-tab']")
    WebElement payLaterOption;

    @FindBy(xpath = "//input[@id='agreechb']")
    WebElement agreeTerms;

    @FindBy(xpath = "//div[@class='btn-box mt-3']")
    WebElement confirmBookingButton;

    public void enterPersonalInformation(String fName, String lName, String emailAddr, String phoneNo, String addr, String nationalityValue, String countryValue) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(emailAddr);
        phone.sendKeys(phoneNo);
        address.sendKeys(addr);
        js.executeScript("window.scrollBy(0, 300)");
        nationalitylist.click();
        Thread.sleep(2000);
        nationality.sendKeys(nationalityValue);

        Thread.sleep(2000);
        nationalityselect.click();
        Thread.sleep(2000);

        countrylist.click();
        country.sendKeys(countryValue);
        countryselect.click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.name("first_name_1"));  // Replace with your locator
        js.executeScript("arguments[0].scrollIntoView(true);", element);


        //Select nationalitySelect = new Select(nationality);
        //nationalitySelect.selectByVisibleText(nationalityValue);

        //Select countrySelect = new Select(country);
        //countrySelect.selectByVisibleText(countryValue);
    }

    public void enterTravellerInformation(String tFirstName, String tLastName, String nationalityText,String dob, String day, String year, String tPassport, String tEmail, String tPhone) throws InterruptedException {
        travellerFirstName.sendKeys(tFirstName);
        travellerLastName.sendKeys(tLastName);

        // Select nationality
        new Select(nationalitydropdown).selectByVisibleText(nationalityText);

        new Select(dobdropdown).selectByVisibleText(dob);
        Thread.sleep(3000);
        new Select(daydropdown).selectByVisibleText(day);
        Thread.sleep(3000);
        new Select(yeardropdown).selectByVisibleText(year);
        Thread.sleep(3000);

        travellerPassport.sendKeys(tPassport);
        Thread.sleep(3000);

        travellerEmail.sendKeys(tEmail);
        Thread.sleep(3000);

        travellerPhone.sendKeys(tPhone);
        Thread.sleep(3000);

    }

    public void selectPaymentMethod() throws InterruptedException {
        payLaterOption.click();
        Thread.sleep(3000);
        agreeTerms.click();
        Thread.sleep(3000);
    }

    public void confirmBooking() throws InterruptedException {
        confirmBookingButton.click();
        Thread.sleep(3000);
    }
}
