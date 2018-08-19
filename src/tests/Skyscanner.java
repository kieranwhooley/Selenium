package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Skyscanner {

    WebDriver driver;
    String browserType = "Chrome";
    WebElement flightOriginField, flightDestinationField, outbounddateField, cheapestMonthButton, returnDateField, searchForFlightsButton;
    String originCity = "Dublin";
    String destinationCity = "Everywhere";
    @Test
    public void searchForFlights() {

        System.out.println("Starting tests");
        defineWebElements();
        flightOriginField.sendKeys(originCity);
        flightDestinationField.sendKeys(destinationCity);
        //outbounddateField.click();
        //cheapestMonthButton.click();
        //returnDateField.click();
        //cheapestMonthButton.click();
        searchForFlightsButton.click();

    }

    public void defineWebElements() {
        flightOriginField = driver.findElement(By.id("origin-fsc-search"));
        flightDestinationField = driver.findElement(By.id("destination-fsc-search"));
        outbounddateField = driver.findElement(By.id("depart-fsc-datepicker-input"));
        //cheapestMonthButton = driver.findElement(By.className("fsc-datepicker__wholeyear-2bBIy"));
        returnDateField = driver.findElement(By.id("return-fsc-datepicker-input"));
        searchForFlightsButton = driver.findElement(By.className("SubmitButton-WxCV2"));
    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFactory.open(browserType);
        driver.get("https://www.skyscanner.ie/");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Finished tests and closing browser");
        //driver.quit();

    }
}
