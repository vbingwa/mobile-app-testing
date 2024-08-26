package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomeScreen {
    protected AppiumDriver<MobileElement> driver;

    // Constructor to initialize the driver
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        // Initialize MobileElement variables
        initializeElements();
    }

    // Method to initialize MobileElement variables
    private void initializeElements() {
        openMenuIcon = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
    }

    private MobileElement openMenuIcon;

    public void clickMenuIcon() {
        openMenuIcon.click();
        System.out.println("Clicked the open menu icon.");
    }
}
