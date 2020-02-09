package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.auxiliaryMethods.AuxiliaryMethods.waitForElementClickable;
import static framework.auxiliaryMethods.AuxiliaryMethods.waitForElementVisible;
import static framework.auxiliaryMethods.AuxiliaryMethods.*;

public class TourPaymentPage extends CommonPage {

    /*
     * Identifying the elements on the page. Best practices should be followed where possible while choosing them.
     * In the selected page to automate, the selection strategy is pretty random, as there is standard coding pattern
     * to identify the elements. In a project with access to the repository, I'd edit the code myself and add a qa
     * label to the interesting elements.
     */

    @FindBy(css = ".success-box.unpaid")
    private WebElement successUnpaidConfirmation;

    @FindBy(css = ".btn.btn-default.arrivalpay")
    private WebElement payAtArrivalButton;

    @FindBy(css = "[data-target='#pay']")
    private WebElement payNowButton;

    @FindBy(css = ".success-box.reserved")
    private WebElement successReservedConfirmation;

    @FindBy(id = "gateway_chosen")
    private WebElement paymentMethodDropDown;

    @FindBy(css = "li.active-result:nth-child(2)")
    private WebElement StripeCreditCardOption;

    @FindBy(css = "li.active-result:nth-child(4)")
    private WebElement CreditCardOption;

    @FindBy(css = "li.active-result:nth-child(5)")
    private WebElement SkrillMoneybookersOption;

    @FindBy(css = "li.active-result:nth-child(8)")
    private WebElement PayPalOption;

    @FindBy(css = "li.active-result:nth-child(9)")
    private WebElement CrediMaxOption;

    @FindBy(css = "li.active-result:nth-child(10)")
    private WebElement PayPalPaymentsProOption;

    @FindBy(css = "li.active-result:nth-child(11)")
    private WebElement VeritransOption;

    @FindBy(css = "li.active-result:nth-child(12)")
    private WebElement PayUOption;

    @FindBy(css = ".btn.paynowbtn")
    private WebElement payNowPaymentFormButton;

    @FindBy(className = "paybtn")
    private WebElement skrillMoneybookersPayNowButton;

    @FindBy(className = "paybtn")
    private WebElement payPalPayNowButton;

    @FindBy(id = "showPaymentPage")
    private WebElement crediMaxPayNowButton;

    @FindBy(id = "pay-button")
    private WebElement veritransPayNowButton;

    @FindBy(css = "#frmTransaction > input:nth-child(16)")
    private WebElement payUPayNowButton;

    @FindBy(css = ".cc-btn.cc-dismiss")
    private WebElement dismissCookiesButton;

    /*
     * Methods over the elements that are used by the Test Classes
     */

    public TourPaymentPage successUnpaidConfirmationIsVisible() {
        waitForElementVisible(successUnpaidConfirmation);
        return this;
    }

    public TourPaymentPage successReservedConfirmationIsVisible() {
        waitForElementVisible(successReservedConfirmation);
        return this;
    }

    public TourPaymentPage clickPayAtArrival() {
        payAtArrivalButton.click();
        return this;
    }

    public TourPaymentPage clickPayNow() {
        payNowButton.click();
        return this;
    }

    public TourPaymentPage acceptToPayAtArrival() {
        acceptAlert();
        return this;
    }

    public TourPaymentPage clickPaymentMethodDropDown() {
        waitForElementVisible(paymentMethodDropDown);
        paymentMethodDropDown.click();
        return this;
    }
    /*
     * The type string can be changed to an ENUM, such as in the BrowserSelector class
     */
    public TourPaymentPage selectPaymentMethod(String paymentMethod){
        clickPaymentMethodDropDown();
        switch (paymentMethod){
            case "StripeCreditCard":
                StripeCreditCardOption.click();
                break;
            case "CreditCard":
                CreditCardOption.click();
                break;
            case "SkrillMoneybookers":
                SkrillMoneybookersOption.click();
                break;
            case "PayPal":
                PayPalOption.click();
                break;
            case "CrediMax":
                CrediMaxOption.click();
                break;
            case "PayPalPaymentsPro":
                PayPalPaymentsProOption.click();
                break;
            case "Veritrans":
                VeritransOption.click();
                break;
            case "PayU":
                PayUOption.click();
                break;
            default:
                throw new IllegalStateException("Ooops! You specified a non-supported Payment Option!");
        }
            return this;
    }

    public TourPaymentPage paymentInfoCompletedAndPayNowDisplayed(String paymentMethod){
        switch (paymentMethod){
            case "PayPalPaymentsPro":
            case "CreditCard":
            case "StripeCreditCard":
                waitForElementVisible(payNowPaymentFormButton);
                break;
            case "SkrillMoneybookers":
                waitForElementVisible(skrillMoneybookersPayNowButton);
                break;
            case "PayPal":
                waitForElementVisible(payPalPayNowButton);
                break;
            case "CrediMax":
                waitForElementVisible(crediMaxPayNowButton);
                break;
            case "Veritrans":
                waitForElementVisible(veritransPayNowButton);
                break;
            case "PayU":
                waitForElementVisible(payUPayNowButton);
                break;
            default:
                throw new IllegalStateException("Ooops! You specified a non-supported Payment Option!");

        }
        return this;

    }

    public TourPaymentPage dismissCookies() {
        waitForElementClickable(dismissCookiesButton);
        dismissCookiesButton.click();
        return this;
    }

}