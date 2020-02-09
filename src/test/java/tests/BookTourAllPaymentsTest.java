package tests;

import org.junit.jupiter.api.Test;
import pages.TourConfirmationPage;
import pages.TourDetailsPage;
import pages.TourPaymentPage;

class BookTourAllPaymentsTest extends MainTest {

    /*
     * @Test identifies the Junit test to be executed.
     * The granularity of the methods invoked from the pages class, can be refined depending on project needs.
     */

    @Test
    void BookTourWithPayOnArrival() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .clickPayAtArrival()
                .acceptToPayAtArrival()
                .successReservedConfirmationIsVisible();
    }

    @Test
    void BookTourWithPayNowStripeCreditCard() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("StripeCreditCard")
                .paymentInfoCompletedAndPayNowDisplayed("StripeCreditCard");

    }

    @Test
    void BookTourWithPayNowCreditCard() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("CreditCard")
                .paymentInfoCompletedAndPayNowDisplayed("CreditCard");

    }

    @Test
    void BookTourWithPayNowSkrillMoneybookers() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("SkrillMoneybookers")
                .paymentInfoCompletedAndPayNowDisplayed("SkrillMoneybookers");

    }

    @Test
    void BookTourWithPayNowPayPal() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("PayPal")
                .paymentInfoCompletedAndPayNowDisplayed("PayPal");

    }

    @Test
    void BookTourWithPayNowCrediMax() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("CrediMax")
                .paymentInfoCompletedAndPayNowDisplayed("CrediMax");

    }

    @Test
    void BookTourWithPayNowPayPalPaymentsPro() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("PayPalPaymentsPro")
                .paymentInfoCompletedAndPayNowDisplayed("PayPalPaymentsPro");

    }

    @Test
    void BookTourWithPayNowVeritrans() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("Veritrans")
                .paymentInfoCompletedAndPayNowDisplayed("Veritrans");

    }

    @Test
    void BookTourWithPayNowPayU() {
        commonBackgroundOfScenarios();
        new TourPaymentPage()
                .dismissCookies()
                .clickPayNow()
                .selectPaymentMethod("PayU")
                .paymentInfoCompletedAndPayNowDisplayed("PayU");

    }

    /*
     * This is the list of common actions for Payments Test, that all the scenarios need to make in the beginning.
     * Can be moved to MainTest in the @BeforeEach if wanted, until other non-payment tests need to be added.
     */

    void commonBackgroundOfScenarios() {
        new TourDetailsPage()
                .dismissCookies()
                .clickBookNow();
        new TourConfirmationPage()
                .successfulConfirmationPageIsVisible()
                .dismissCookies()
                .completeFirstNameField()
                .completeLastNameField()
                .completeEmailField()
                .completeConfirmEmailField()
                .completePhoneField()
                .completeAddressField()
                .selectCountry()
                .clickConfirmButton();
        new TourPaymentPage()
                .successUnpaidConfirmationIsVisible();
    }
}