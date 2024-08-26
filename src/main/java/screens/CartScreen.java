package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class CartScreen {

    protected AppiumDriver<MobileElement> driver;

    public CartScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private MobileElement getRemoveItemButton() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Remove Item\"]"));
    }

    private MobileElement getTotalPriceLabel() {
        return driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"total price\"]"));
    }

    private MobileElement getFirstRemoveItemButton() {
        return driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Remove Item\"])[1]"));
    }

    private MobileElement getProceedToCheckoutButton() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]"));


    }

    private MobileElement getCartBadgeIcon() {
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"));
    }


    public void manageCartAndCheckout() {
        // Locate the cart badge icon
        MobileElement cartBadgeIcon = getCartBadgeIcon();
        getCartBadgeIcon().click();
        System.out.println("Cart badge icon located.");
        // Locate the "Total Price" label and print the value
        String totalPrice = getTotalPriceLabel().getText();
        System.out.println("Total Price: " + totalPrice);
        // Locate and click the first "Remove Item" button
        getFirstRemoveItemButton().click();
        System.out.println("First item removed from the cart.");

          String totalPriceUpdated = getTotalPriceLabel().getText();
          System.out.println("Total Price: " + totalPriceUpdated);

        // Locate and click the "Proceed to Checkout" button
        getProceedToCheckoutButton().click();
        System.out.println("Proceeded to checkout.");
    }
}
