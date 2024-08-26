package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CheckoutScreen {
    protected AppiumDriver<MobileElement> driver;

    public CheckoutScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private MobileElement getFullNameField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]"));
    }

    private MobileElement getAddressLine1Field() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]"));
    }

    private MobileElement getAddressLine2Field() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 2 input field\"]"));
    }

    private MobileElement getCityField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]"));
    }

    private MobileElement getStateRegionField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]"));
    }

    private MobileElement getZipCodeField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]"));
    }

    private MobileElement getCountryField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]"));
    }

    private MobileElement getToPaymentButton() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]"));
    }

    public void enterAddressDetails(String fullName, String addressLine1, String addressLine2, String city, String stateRegion, String zipCode, String country) {
        // Input address details
        getFullNameField().sendKeys(fullName);
        getAddressLine1Field().sendKeys(addressLine1);
        getAddressLine2Field().sendKeys(addressLine2);
        getCityField().sendKeys(city);
        getStateRegionField().sendKeys(stateRegion);
        getZipCodeField().sendKeys(zipCode);
        getCountryField().sendKeys(country);
        getToPaymentButton().click();
    }
}
