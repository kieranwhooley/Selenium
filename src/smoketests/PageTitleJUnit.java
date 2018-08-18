package smoketests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageTitleJUnit {

    WebDriver driver;
    String webURL = "http://sdetuniversity.com/projects/";

    @Test
    public void PageTitleTest() {
        driver.get(webURL);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
        String expectedTitle = "SDET Training | Account Management";
        System.out.println("Running the test");
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

    }

    @BeforeEach
    public void setup() {
        System.out.println("Setting up the test");
        driver = utilities.DriverFactory.open("Chrome");
    }

    @AfterEach
    public void teardown() {
        System.out.println("Closing driver");
        driver.close();
        System.out.println("Tests complete");
    }
}
