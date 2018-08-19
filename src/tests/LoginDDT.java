package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {

    WebDriver driver;

    @Test(dataProvider = "getData")
    public void loginTest(String name, String email, String password) {
        System.out.println(name + " " + email + " " + password);
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        driver.findElement(By.id("MainContent_btnLogin")).click();

        String successfulLoginMessage = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION: " + successfulLoginMessage);
    }

   @BeforeMethod
    public void setUp() {
        System.out.println("Setting up driver and opening browser");
        driver = utilities.DriverFactory.open("Chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests complete");
        driver.quit();
    }
    @DataProvider
    public Object[][] getData() {
        return utilities.Excel.get("C:\\SDET\\Files\\UserLogin.xls");
    }
}
