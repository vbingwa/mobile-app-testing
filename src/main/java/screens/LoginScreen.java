package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginScreen {
    protected AppiumDriver<MobileElement> driver;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    // Initialize elements within methods to avoid null issues
    private MobileElement getLogin() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Log In']"));
    }
    private MobileElement getLogout() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Log Out']"));
    }
    private MobileElement getActiveUser() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"bob@example.com\"]"));
    }

    private MobileElement getLoginButton() {
        return driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Login\"])[2]"));
    }

    private MobileElement getUsernameField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
    }

    private MobileElement getPasswordField() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));
    }

    private MobileElement getSuccessMessage() {
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='generic-error-message']"));
    }



    public void validLogin() {
        getLogin().click();
        getActiveUser().click();
        getLoginButton().click();
    }

    public void invalidLogin(String username, String password) {
        getLogin().click();
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    public void logout() {
        getLogout().click();

    }

}
