package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.*;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.TestData;
import utils.TestListener;

@Listeners(TestListener.class)
public class EndToEndTest extends BaseTest {
    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    private ProductScreen productScreen;
    private CartScreen cartScreen;
    private CheckoutScreen checkoutScreen;
    private PaymentScreen paymentScreen;

    @BeforeMethod
    public void setup() throws Exception {
        super.setUp();
        homeScreen = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        productScreen = new ProductScreen(driver);
        cartScreen = new CartScreen(driver);
        checkoutScreen = new CheckoutScreen(driver);
        paymentScreen = new PaymentScreen(driver);
    }

    @Test
    public void testEndToEndTest() {
        // Retrieve payment data from TestData
        String fullName = TestData.get("addressDetails", "fullName");
        String streetAddress = TestData.get("addressDetails", "streetAddress");
        String apartment = TestData.get("addressDetails", "apartment");
        String city = TestData.get("addressDetails", "city");
        String state = TestData.get("addressDetails", "state");
        String zipCode = TestData.get("addressDetails", "zipCode");
        String country = TestData.get("addressDetails", "country");
        String cardHolderName = TestData.get("paymentDetails", "cardHolderName");
        String cardNumber = TestData.get("paymentDetails", "cardNumber");
        String expiryDate = TestData.get("paymentDetails", "expiryDate");
        String cvv = TestData.get("paymentDetails", "cvv");

        // Log values for debugging
        System.out.println("Full Name: " + fullName);
        System.out.println("Street Address: " + streetAddress);
        System.out.println("Apartment: " + apartment);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip Code: " + zipCode);
        System.out.println("Country: " + country);
        System.out.println("Card Holder Name: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("CVV: " + cvv);
        homeScreen.clickMenuIcon();
        ExtentReportManager.addScreenshot(driver, "Home Screen");
        loginScreen.validLogin();
        ExtentReportManager.addScreenshot(driver, "Successfully logged in");
        productScreen.interactWithStoreItems();
        ExtentReportManager.addScreenshot(driver, "Store Items  being added on cart");
        cartScreen.manageCartAndCheckout();
        ExtentReportManager.addScreenshot(driver, "Cart & Checkout");
        checkoutScreen.enterAddressDetails(fullName, streetAddress, apartment, city, state, zipCode, country);
        ExtentReportManager.addScreenshot(driver, "Checkout Screen");
        paymentScreen.enterPaymentDetailsAndVerify(cardHolderName, cardNumber,  expiryDate, cvv);
        ExtentReportManager.addScreenshot(driver, "Successfully placed an order");

    }
}
