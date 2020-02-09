package framework.driver;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * Interface class with the remote drivers.
 */
public class RemoteDriverManager {
    /*
     * Method that initiates the remote driver based on specified browser and the specified gridUrl
     */
    public static RemoteWebDriver initiateDriverWithRemoteBrowser(BrowserSelector browserSelector) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browserSelector) {
            case CHROME:
                capabilities.setBrowserName(BrowserType.CHROME);
                break;
            case FIREFOX:
                capabilities.setBrowserName(BrowserType.FIREFOX);
                break;
            case EDGE:
                capabilities.setBrowserName(BrowserType.EDGE);
                break;
            default:
                throw new IllegalStateException("Ooops! You specified a non-supported RemoteBrowser!");
        }
        URL gridUrl = null;
        try {
            gridUrl = new URL(System.getProperty("grid.url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(gridUrl, capabilities);
    }
}