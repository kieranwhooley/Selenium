package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        String gender;
        String password = "pw";
        String country = "Belgium";
        String weeklyEmail;
        String monthlyEmail;
        String occasionalEmail;
        String browserType = "Chrome";
        WebDriver driver;

        //open browser
        driver = utilities.DriverFactory.open(browserType);
        //go to page
        driver.get("http://sdetuniversity.com/projects/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
        //click new account
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        //enter details
        //name
        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
        //email
        driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys(email);
        //phone
        driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(phonenumber);
        //gender
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']")).click();
        //password
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
        driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
        //country
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
        //subscriptions
        driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
        driver.findElement(By.id("MainContent_checkUpdates")).click();
        //click submit
        driver.findElement(By.id("MainContent_btnSubmit")).click();
        //check confirmation message
        String success = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + success);
        //close browser
        driver.close();
    }
}
