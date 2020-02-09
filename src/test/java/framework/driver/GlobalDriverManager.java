package framework.driver;

import org.openqa.selenium.WebDriver;

import static framework.driver.LocalDriverManager.initiateDriverWithLocalBrowser;
import static framework.driver.RemoteDriverManager.initiateDriverWithRemoteBrowser;
import static framework.config.PropertyRetriever.*;

/*
 * This is the interface class for creating, retrieving and closing the webdriver.
 */

public class GlobalDriverManager {

    private static WebDriver driver;

    private GlobalDriverManager() {
    }

    /*
     * Based on the Test Execution Type (If Remote or Local) we initialize the driver differently.
     */
    public static WebDriver retrieveDriver() {
        if (driver == null) {
        switch (System.getProperty("test.execution.type")) {
            case "local":
                driver = initiateDriverWithLocalBrowser(BrowserSelector.valueOf(getDesiredBrowser()));
                break;
            case "remote":
                driver = initiateDriverWithRemoteBrowser(BrowserSelector.valueOf(getDesiredBrowser()));
                break;
            default:
                throw new IllegalStateException("Ooops! You specified a non-supported Test Execution Type!");
        }
        }
        return driver;
    }

    /*
     * Method that is gracefully closing the driver and then null-ing it, to allow it's re-creation.
     */
    public static void resetDriver() {
        driver.close();
        driver = null;
    }
}