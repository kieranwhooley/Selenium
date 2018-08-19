package tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class Login {

    WebDriver driver;
    String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("jb@mail.com");
        loginPage.setPassword("pw1");
        loginPage.clickSubmit();
        DashboardPage dashboardPage = new DashboardPage(driver);
        String validMessage = dashboardPage.getConfirmationMessage();
        String dashboardTitle = dashboardPage.pageTitle();
        
        Assertions.assertTrue(validMessage.contains("Logged"));
        Assertions.assertTrue(dashboardTitle.contains("Account"));
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing driver and opening browser");
        driver = utilities.DriverFactory.open("Chrome");
        driver.get(webURL);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests complete");
        driver.quit();
    }

}
