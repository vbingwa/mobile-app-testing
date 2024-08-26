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
public class CheckoutScreenTest extends BaseTest {
    private HomeScreen homePage;
    private LoginScreen loginScreen;
    private ProductScreen productScreen;
    private CartScreen cartScreen;
    private CheckoutScreen checkoutScreen;

    @BeforeMethod
    public void setup() throws Exception {
        super.setUp();
        homePage = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        productScreen = new ProductScreen(driver);
        cartScreen = new CartScreen(driver);
        checkoutScreen = new CheckoutScreen(driver);
    }

    @Test
    public void testEnterAddressDetails() {
// Retrieve address data from TestData
        String fullName = TestData.get("addressDetails", "fullName");
        String streetAddress = TestData.get("addressDetails", "streetAddress");
        String apartment = TestData.get("addressDetails", "apartment");
        String city = TestData.get("addressDetails", "city");
        String state = TestData.get("addressDetails", "state");
        String zipCode = TestData.get("addressDetails", "zipCode");
        String country = TestData.get("addressDetails", "country");

        // Log values for debugging
        System.out.println("Full Name: " + fullName);
        System.out.println("Street Address: " + streetAddress);
        System.out.println("Apartment: " + apartment);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip Code: " + zipCode);
        System.out.println("Country: " + country);
        homePage.clickMenuIcon();
        loginScreen.validLogin();
        productScreen.interactWithStoreItems();
        cartScreen.manageCartAndCheckout();
        checkoutScreen.enterAddressDetails(fullName, streetAddress, apartment, city, state, zipCode, country);
        ExtentReportManager.addScreenshot(driver, "Checkout Successful");
    }
}
