package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ATagsTest {

    WebDriver driver;

    @Test
    public void loginElementsPresent() {

        System.out.println("Running tests");
        boolean createAccountATagPresent = false;
        List<WebElement> aTagElements = driver.findElements(By.tagName("a"));

        int numberOfAElements = aTagElements.size();
        System.out.println("Number of A elements on page: " + numberOfAElements + "\nThey are:");

        for (WebElement aTagElement : aTagElements) {
            System.out.println(aTagElement.getText());
            if (aTagElement.getText().equalsIgnoreCase("CREATE ACCOUNT")) {
                createAccountATagPresent = true;
                break;
            }
        }

        Assert.assertTrue(createAccountATagPresent);
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
