package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver open(String browserType) {

        if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\SDET\\Software\\geckodriver.exe");
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\SDET\\Software\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\SDET\\Software\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
