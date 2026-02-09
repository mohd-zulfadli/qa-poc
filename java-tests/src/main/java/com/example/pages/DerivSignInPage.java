package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.qameta.allure.Step;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.example.utils.ScreenshotHelper;

public class DerivSignInPage extends BasePage {
    private ExtentTest test;

    // Locators
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboardTop = By.xpath("//*/div/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    private By dashboardTime = By.xpath("//*/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]");
    private By loginBanner = By.xpath("//*/div/div[1]/div/div[1]/div/div[1]/img");

    public DerivSignInPage(WebDriver driver, ExtentTest test) {
        super(driver); // call BasePage constructor
        this.test = test;
    }

    /** Page‑specific helper to ensure dashboard is fully ready */
    private void waitForDashboardReady() {
        waitForPageLoadComplete();
        waitForNoSpinner();
        waitForElementVisible(dashboardTop);
        waitForStableText(dashboardTop); // ensure header text is final
    }

    @Step("Enter valid credentials: {user} / {pass}")
    public void enterValidCredentials(String user, String pass) {
        waitForElementClickable(usernameField);
        waitForElementClickable(passwordField);

        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);

        test.log(Status.INFO, "Entered username: " + user);
        test.log(Status.INFO, "Entered password: " + pass);
    }

    @Step("Click Login button")
    public void clickLogin() {
        waitForElementClickable(loginButton);
        driver.findElement(loginButton).click();

        test.log(Status.INFO, "Clicked on Login button");
    }

    @Step("Verify dashboard is visible")
    public void verifyDashboardVisible() {
        // ✅ Use the page‑specific helper
        waitForDashboardReady();

        Assert.assertTrue(driver.findElement(dashboardTop).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardTime).isDisplayed());

        // Capture screenshot (Base64 for inline embedding)
        String base64Screenshot = ScreenshotHelper.captureScreenshotBase64(driver);
        if (base64Screenshot != null) {
            test.log(Status.PASS, "Dashboard Visible Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else {
            test.log(Status.PASS, "Dashboard visible, but screenshot capture failed");
        }
    }

    @Step("Verify login page is shown")
    public void verifyLoginPageShown() {
        waitForPageLoadComplete();
        waitForNoSpinner();
        waitForElementVisible(loginBanner);
        waitForElementVisible(usernameField);
        waitForElementVisible(passwordField);

        Assert.assertTrue(driver.findElement(loginBanner).isDisplayed());
        Assert.assertTrue(driver.findElement(usernameField).isDisplayed());
        Assert.assertTrue(driver.findElement(passwordField).isDisplayed());

        test.log(Status.PASS, "Login page is shown after logout");
    }
}
