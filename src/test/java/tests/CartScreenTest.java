package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.CartScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.ProductScreen;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class CartScreenTest extends BaseTest {
    private HomeScreen homePage;
    private LoginScreen loginScreen;
    private ProductScreen productScreen;
    private CartScreen cartScreen;


    @BeforeMethod
    public void setup() throws Exception {
        super.setUp();
        homePage = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        productScreen = new ProductScreen(driver);
        cartScreen = new CartScreen(driver);

    }

    @Test
    public void testManageCartAndCheckout() {
        homePage.clickMenuIcon();
        loginScreen.validLogin();
        productScreen.interactWithStoreItems();
        cartScreen.manageCartAndCheckout();
        ExtentReportManager.getTest().info("");
        ExtentReportManager.addScreenshot(driver, "Cart & Checkout");

    }
}
