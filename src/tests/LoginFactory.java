package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPageFactory;

public class LoginFactory {

    WebDriver driver = utilities.DriverFactory.open("Chrome");
    String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
    String username = "jb@mail.com";
    String password = "pw1";

    @Test
    public void testLogin() {
        driver.get(webURL);
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(username, password);
    }
}
