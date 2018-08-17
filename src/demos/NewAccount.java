package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount {

    public static void main(String[] args) {

        String name = "Bill Smith";
        String email = "fake@mail.com";
        String phonenumber = "123456789";
        String gender = "Female";
        String password = "pw";
        String country = "Belgium";
        boolean weeklyEmail = true;
        boolean monthlyEmail = true;
        boolean occasionalEmail = true;
        String browserType = "Chrome";
        WebDriver driver;

        //open browser
        driver = utilities.DriverFactory.open(browserType);

        //go to page
        driver.get("http://sdetuniversity.com/projects/");
        //click account management system
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
        //click new account
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        //define web elements

        WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
        WebElement emailElement = driver.findElement(By.name("ctl00$MainContent$txtEmail"));
        WebElement phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
        WebElement genderRadioMale = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']"));
        WebElement genderRadioFemale = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
        WebElement passwordElement = driver.findElement(By.id("MainContent_txtPassword"));
        WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        WebElement monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        WebElement occasionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
        WebElement submitButtonElement =  driver.findElement(By.id("MainContent_btnSubmit"));

        //enter details
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phonenumber);

        if (gender.equalsIgnoreCase("Male")) {
            genderRadioMale.click();
        } else if (gender.equalsIgnoreCase("Female")){
            genderRadioFemale.click();
        }

        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        if (weeklyEmail) {
            if (!weeklyEmailElement.isSelected()){
                weeklyEmailElement.click();
            }
        } else {
            if (weeklyEmailElement.isSelected()) {
                weeklyEmailElement.click();
            }
        }

        if (monthlyEmail) {
            if (!monthlyEmailElement.isSelected()){
                monthlyEmailElement.click();
            }
        } else {
            if (monthlyEmailElement.isSelected()) {
                monthlyEmailElement.click();
            }
        }

        if (occasionalEmail) {
            if (!occasionalEmailElement.isSelected()){
                occasionalEmailElement.click();
            }
        } else {
            if (occasionalEmailElement.isSelected()) {
                occasionalEmailElement.click();
            }
        }
        //submit
        submitButtonElement.click();

        //check confirmation message
        String success = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + success);

        //close browser
        //driver.close();
    }
}
