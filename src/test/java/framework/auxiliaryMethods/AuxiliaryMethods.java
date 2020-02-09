package framework.auxiliaryMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.driver.GlobalDriverManager.retrieveDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/*
 * This class contains complementary/auxiliary methods of the test automation technology that can be used throughout
 * all the test cases. This can be divided based on numerous criteria in different classes.
 */

public class AuxiliaryMethods {

    public static void openUrl(String url) {
        retrieveDriver().navigate().to(url);
    }

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(retrieveDriver(), 60);
    }

    public static void waitForElementClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(elementToBeClickable(element));
    }

    public static void waitForElementVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(visibilityOf(element));
    }
    public static void maximizeWindow() {
        retrieveDriver().manage().window().maximize();
    }

    public static void scrollIntoElement(WebElement element){
        Actions actions = new Actions(retrieveDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public static void acceptAlert() {
        Alert alert = retrieveDriver().switchTo().alert();
        alert.accept();
    }

}