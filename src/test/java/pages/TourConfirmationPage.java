package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.auxiliaryMethods.AuxiliaryMethods.waitForElementClickable;
import static framework.auxiliaryMethods.AuxiliaryMethods.waitForElementVisible;

public class TourConfirmationPage extends CommonPage {

    /*
     * Identifying the elements on the page. Best practices should be followed where possible while choosing them.
     * In the selected page to automate, the selection strategy is pretty random, as there is standard coding pattern
     * to identify the elements. In a project with access to the repository, I'd edit the code myself and add a qa
     * label to the interesting elements.
     */

    @FindBy(className = "success-box")
    private WebElement successfulConfirmationPage;

    @FindBy(name = "firstname")
    private WebElement firstNameField;

    @FindBy(name = "lastname")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "confirmemail")
    private WebElement confirmEmailField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(name = "address")
    private WebElement addressField;

    @FindBy(className = "chosen-single")
    private WebElement countryDropDown;

    @FindBy(css = "li.active-result:nth-child(3)")
    private WebElement countryOptionAlbania;

    @FindBy(name = "guest")
    private WebElement confirmBookingButton;

    @FindBy(css = ".cc-btn.cc-dismiss")
    private WebElement dismissCookiesButton;

    /*
     * Data that is fed into the forms. For simplicity is put here, but in a real project it:
     * - should be separated in another package/class/even in another dependency, as this data can be reused between
     * test cases and even projects
     * - if separated into another class, this class can handle how to get important data (eg: insert/read from DB)
     * - should be generated randomly if not important for test case (eg: name/address)
     */
    String firstName = "FirstName";
    String lastName = "LastName";
    String email = "e@mail.com";
    String phone = "0034611222333";
    String address = "Barcelona";

    /*
     * Methods over the elements that are used by the Test Classes
     */

    public TourConfirmationPage successfulConfirmationPageIsVisible() {
        waitForElementVisible(successfulConfirmationPage);
        return this;
    }

    public TourConfirmationPage completeFirstNameField() {
        firstNameField.sendKeys(this.firstName);
        return this;
    }
    public TourConfirmationPage completeLastNameField() {
        lastNameField.sendKeys(this.lastName);
        return this;
    }

    public TourConfirmationPage completeEmailField() {
        emailField.sendKeys(this.email);
        return this;
    }

    public TourConfirmationPage completeConfirmEmailField() {
        confirmEmailField.sendKeys(this.email);
        return this;
    }

    public TourConfirmationPage completePhoneField() {
        phoneField.sendKeys(this.phone);
        return this;
    }
    public TourConfirmationPage completeAddressField() {
        addressField.sendKeys(this.address);
        return this;
    }
    public TourConfirmationPage selectCountry() {
        countryDropDown.click();
        countryOptionAlbania.click();
        return this;
    }

    public TourConfirmationPage clickConfirmButton() {
        confirmBookingButton.click();
        return this;
    }


    public TourConfirmationPage dismissCookies() {
        waitForElementClickable(dismissCookiesButton);
        dismissCookiesButton.click();
        return this;
    }

}