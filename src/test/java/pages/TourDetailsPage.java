package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.auxiliaryMethods.AuxiliaryMethods.waitForElementClickable;
import static framework.auxiliaryMethods.AuxiliaryMethods.scrollIntoElement;

public class TourDetailsPage extends CommonPage {

    /*
     * Identifying the elements on the page. Best practices should be followed where possible while choosing them.
     * In the selected page to automate, the selection strategy is pretty random, as there is standard coding pattern
     * to identify the elements. In a project with access to the repository, I'd edit the code myself and add a qa
     * label to the interesting elements.
     */

    @FindBy(css = ".btn.btn-secondary.btn-block")
    private WebElement bookNowButton;

    @FindBy(css = ".cc-btn.cc-dismiss")
    private WebElement dismissCookiesButton;

    /*
     * Methods over the elements that are used by the Test Classes
     */

    public TourDetailsPage dismissCookies() {
        waitForElementClickable(dismissCookiesButton);
        dismissCookiesButton.click();
        return this;
    }

    public TourDetailsPage clickBookNow() {
        waitForElementClickable(bookNowButton);
        scrollIntoElement(bookNowButton);
        bookNowButton.click();
        return this;
    }

}