package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "C:\\SDET\\Software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Go to page
        //http://sdetuniversity.com/projects/
        driver.get("http://sdetuniversity.com/projects/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
        //Enter email
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testmail.com");
        //Enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
        //Click login
        driver.findElement(By.id("MainContent_btnLogin")).click();
        //Confirm login is successful
        String successfulLoginMessage = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION: " + successfulLoginMessage);

        String pageTitle = driver.getTitle();
        if(pageTitle.equals("SDET Training | Account Management")) {
            System.out.println("CORRECT EXPECTED TITLE: " + pageTitle);
        } else {
            System.out.println("INCORRECT TITLE DISPLAYED" + pageTitle);
        }
        //Close browser
        driver.close();
    }
}
