package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {

    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occasionalEmail;
    WebElement nameField, emailField, phoneField, maleGenderRadioButton, femaleGenderRadioButton, passwordField, verifyPasswordField, countryField, weeklyEmailBox, monthlyEmailBox, occasionalEmailBox, submitButton;
    WebDriver driver;

    //Test method
    @Test
    public void newAccountTest() {
        System.out.println("New record for test: " + name + " " + email + " " + phone + " " + gender + " " + password
                + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);

        //Define WeElements
        defineWebElements();

        //Define test actions
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        if (gender.equalsIgnoreCase("Male")) {
            maleGenderRadioButton.click();
        } else {
            femaleGenderRadioButton.click();
        }
        passwordField.sendKeys(password);
        verifyPasswordField.sendKeys(password);
        new Select(countryField).selectByVisibleText(country);
        if (weeklyEmail) {
            if (!weeklyEmailBox.isSelected()) {
                weeklyEmailBox.click();
            }
        } else {
            if (weeklyEmailBox.isSelected()) {
                weeklyEmailBox.click();
            }
        }

        if (monthlyEmail) {
            if (!monthlyEmailBox.isSelected()) {
                monthlyEmailBox.click();
            }
        } else {
            if (monthlyEmailBox.isSelected()) {
                monthlyEmailBox.click();
            }
        }

        if (occasionalEmail) {
            if (!occasionalEmailBox.isSelected()) {
                occasionalEmailBox.click();
            }
        } else {
            if (occasionalEmailBox.isSelected()) {
                occasionalEmailBox.click();
            }
        }

        submitButton.click();

        String expectedSuccessMessage = "Customer information added successfully";
        String actualSuccessMessage = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("Created account successfully for user: " + name);
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage, "Success messages do not match");

    }

    //Gets data and passes to constructor
    @Parameterized.Parameters
    public static List<String[]> getData() {
        return utilities.CSV.get("C:\\SDET\\Files\\testdata.txt");
    }

    @Before
    public void setUp() {
        System.out.println("Starting test run and initializing driver");
        String webURL = "http://sdettraining.com/trguitransactions/NewAccount.aspx";
        driver = utilities.DriverFactory.open("Chrome");
        driver.get(webURL);
    }
    @After
    public void teardown() {
        System.out.println("Closing driver after test");
        driver.quit();
    }

    public void defineWebElements() {
        nameField = driver.findElement(By.id("MainContent_txtFirstName"));
        emailField = driver.findElement(By.id("MainContent_txtEmail"));
        phoneField = driver.findElement(By.id("MainContent_txtHomePhone"));
        maleGenderRadioButton = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']"));
        femaleGenderRadioButton = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
        passwordField = driver.findElement(By.id("MainContent_txtPassword"));
        verifyPasswordField = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        countryField = driver.findElement(By.id("MainContent_menuCountry"));
        weeklyEmailBox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        monthlyEmailBox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        occasionalEmailBox = driver.findElement(By.id("MainContent_checkUpdates"));
        submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

    }
    //Constructor that passes to test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
                         String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;
        if (weeklyEmail.equals("TRUE")) {
            this.weeklyEmail = true;
        } else {
            this.weeklyEmail = false;
        }

        if (monthlyEmail.equals("TRUE")) {
            this.monthlyEmail = true;
        } else {
            this.monthlyEmail = false;
        }

        if (occasionalEmail.equals("TRUE")) {
            this.occasionalEmail = true;
        } else {
            this.occasionalEmail = false;
        }

    }
}
