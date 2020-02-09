package framework.driver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * Interface class with the local drivers.
 */
public class LocalDriverManager {
    /*
     * Method that initiates the local driver based on specified browser
     */
    public static WebDriver initiateDriverWithLocalBrowser(BrowserSelector browserSelector) {
        switch (browserSelector) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Ooops! Please specify a supported browser!");
        }
    }
}