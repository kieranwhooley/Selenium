package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public void setUsername(String username) {
        driver.findElement(By.id("MainContent_txtUserName"));
    }

    public void setPassword(String password) {
        driver.findElement(By.id("MainContent_txtPassword"));
    }

    public void clickSubmit() {
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


}
