package tests;

import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import screens.HomeScreen;
import screens.LoginScreen;
import utils.BaseTest;
import utils.ExtentReportManager;
import utils.TestData;
import utils.TestListener;

import java.io.FileReader;
import java.util.Map;

@Listeners(TestListener.class)
public class LoginTests extends BaseTest {

    private HomeScreen homePage;
    private LoginScreen loginScreen;

    private JSONObject testData;

    @BeforeMethod
    public void setup() throws Exception {
        super.setUp();

        homePage = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
    }

    @Test
    public void testInvalidLogin() {
        String invalidUsername = TestData.get("loginDetails", "invalidUsername");
        String invalidPassword = TestData.get("loginDetails", "invalidPassword");
        // Log the values for debugging
        System.out.println("Username to enter: " + invalidUsername);
        System.out.println("Password to enter: " + invalidPassword);
        homePage.clickMenuIcon();
        loginScreen.invalidLogin(invalidUsername, invalidPassword);

        MobileElement successMessage = driver.findElement(By.id("com.saucelabs.mydemoapp.rn:id/successMessage"));
        Assert.assertTrue(successMessage.isDisplayed(), "Login was not successful");

        // Add a screenshot after login
        ExtentReportManager.addScreenshot(driver, "Invalid Login Screenshot");
    }

    @Test
    public void testValidLogin() {
        homePage.clickMenuIcon();
        loginScreen.validLogin();

        // Add a screenshot after login
        ExtentReportManager.addScreenshot(driver, "Login successful");
    }
    @Test
    public void testLogout() {
        homePage.clickMenuIcon();
        loginScreen.logout();

        // Add a screenshot after logout
        ExtentReportManager.addScreenshot(driver, "Logout Screenshot");
    }
}
