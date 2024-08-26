package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ProductScreen {
    protected AppiumDriver<MobileElement> driver;

    public ProductScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private MobileElement getCartBadgeIcon() {
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"));
    }

    private MobileElement getCatalog() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Catalog']"));
    }

    private MobileElement getAddToCartButton() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]"));
    }

    private MobileElement getStoreItemImage2() {
        return driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[2]/android.view.ViewGroup[1]/android.widget.ImageView"));
    }
    private MobileElement getStoreItemImage() {
        return driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView"));
    }

    private MobileElement getOpenMenuIcon() {
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
    }

    public void interactWithStoreItems() {
        // Locate and interact with the store item image (e.g., click it to view details)
        getStoreItemImage().click();
        System.out.println("Clicked on the store item image.");
        // Locate and click the "Add To Cart" button
        getAddToCartButton().click();
        System.out.println("Clicked the 'Add To Cart' button.");

        getOpenMenuIcon().click();
        System.out.println("Clicked the open menu icon.");
        getCatalog().click();
        System.out.println("Clicked on the 'Catalog' text view.");

        getStoreItemImage2().click();
        System.out.println("Clicked on the store item image 2.");

        // Locate and click the "Add To Cart" button
        getAddToCartButton().click();
        System.out.println("Clicked the 'Add To Cart' button.");

        // Locate the cart badge icon
        MobileElement cartBadgeIcon = getCartBadgeIcon();
        System.out.println("Cart badge icon located.");


    }

    public void clickCatalog() {
        // Locate and click the open menu icon
        getOpenMenuIcon().click();
        System.out.println("Clicked the open menu icon.");
        getCatalog().click();
        System.out.println("Clicked on the 'Catalog' text view.");
    }
}
