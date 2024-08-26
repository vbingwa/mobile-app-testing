package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentScreen {
    protected AppiumDriver<MobileElement> driver;

    public PaymentScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private MobileElement getToPaymentButton() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]"));
    }

    private MobileElement getFullNameField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]"));
    }

    private MobileElement getCardNumberField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]"));
    }

    private MobileElement getExpirationDateField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]"));
    }

    private MobileElement getSecurityCodeField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]"));
    }

    private MobileElement getReviewOrderText() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Review Order\"]"));
    }

    private MobileElement getPlaceOrderText() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Place Order\"]"));
    }

    private MobileElement getOrderDispatchedText() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\" Your order has been dispatched and will arrive as fast as the pony gallops!\"]"));
    }

    public void enterPaymentDetailsAndVerify(String fullName, String cardNumber, String expirationDate, String securityCode) {
        // Enter payment details

        WebDriverWait wait = new WebDriverWait(driver, 10);
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(getFullNameField()));
               // getFullNameField().click();
                getFullNameField().sendKeys(fullName);
                break;
            } catch (StaleElementReferenceException e) {

                System.out.println("StaleElementReferenceException caught. Retrying...");
            }
            attempts++;
        }
            getCardNumberField().sendKeys(cardNumber);
            getExpirationDateField().sendKeys(expirationDate);
            getSecurityCodeField().sendKeys(securityCode);

            // Verify the presence of the "Review Order" text
            if (getReviewOrderText().isDisplayed()) {
                System.out.println("Review Order text is displayed.");
            } else {
                System.out.println("Review Order text is not displayed.");
            }
            getReviewOrderText().click();

            // Verify the presence of the "Place Order" text
            if (getPlaceOrderText().isDisplayed()) {
                System.out.println("Review Order text is displayed.");
            } else {
                System.out.println("Review Order text is not displayed.");
            }
            getPlaceOrderText().click();
            // Verify the presence of the order dispatched message
            if (getOrderDispatchedText().isDisplayed()) {
                System.out.println("Order dispatched message is displayed.");
            } else {
                System.out.println("Order dispatched message is not displayed.");
            }
        }
    }

