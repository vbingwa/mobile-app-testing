package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.ProductScreen;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class ProductScreenTest extends BaseTest {
    private ProductScreen productScreen;

    @BeforeMethod
    public void setup() throws Exception {
        super.setUp();
        productScreen = new ProductScreen(driver);
    }

    @Test
    public void testProductInteractions() {
        productScreen.interactWithStoreItems();
        //productScreen.clickCatalog();
        // Add assertions if needed to verify interactions

        ExtentReportManager.addScreenshot(driver, "Catalog Screenshot");
    }
}
