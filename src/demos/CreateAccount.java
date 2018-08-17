package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

    public static void main(String[] args) {
        //open browser
        System.setProperty("webdriver.chrome.driver", "C:\\SDET\\Software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //go to page
        driver.get("http://sdetuniversity.com/projects/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
        //click new account
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        //enter details
        //name
        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Rudiger Jones");
        //email
        driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("test@mail.com");
        //phone
        driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("123456789");
        //gender
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']")).click();
        //password
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys("pw");
        driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("pw");
        //country
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByIndex(5);
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
