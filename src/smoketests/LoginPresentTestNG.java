package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {

    WebDriver driver;

    @Test
    public void loginElementsPresent() {

        System.out.println("Running tests");
        boolean loginEmailField = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean loginPasswordField = driver.findElement(By.name("ctl00$MainContent$txtPassword")).isDisplayed();
        Assert.assertTrue(loginEmailField, "Email field present");
        Assert.assertTrue(loginPasswordField, "Password field present");

    }

    @BeforeMethod
    public void setup() {
        System.out.println("Setting up tests");
        System.out.println("Initializing driver");
        driver = utilities.DriverFactory.open("Chrome");
        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        driver.get(webURL);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing driver");
        driver.close();
        System.out.println("Tests complete");
    }
}
