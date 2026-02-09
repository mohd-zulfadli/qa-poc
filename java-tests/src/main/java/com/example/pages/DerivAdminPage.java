package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.qameta.allure.Step;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.utils.ScreenshotHelper;

public class DerivAdminPage extends BasePage {
    private ExtentTest test;

    // Locators
    private By myInfoLink           = By.xpath("//*/div/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span");
    private By personalDetailsLabel = By.xpath("//*/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6");
    private By dobTextbox           = By.xpath("//*/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input");
    private By saveButton           = By.xpath("//*/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button");
    private By profileTab           = By.xpath("//*/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span");
    private By logoutButton         = By.xpath("//*/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a");

    public DerivAdminPage(WebDriver driver, ExtentTest test) {
        super(driver);   // call BasePage constructor
        this.test = test;
    }

    @Step("Click My Info link")
    public void clickMyInfo() {
        waitForElementClickable(myInfoLink);
        driver.findElement(myInfoLink).click();
        test.log(Status.INFO, "Clicked on My Info link");
    }

    @Step("Verify My Info page is loaded")
    public void verifyMyInfoLoaded() {
        waitForPageLoadComplete();
        waitForNoSpinner();
        waitForElementVisible(personalDetailsLabel);

        Assert.assertTrue(driver.findElement(personalDetailsLabel).isDisplayed());

        // Capture screenshot for Extent Report
        String base64Screenshot = ScreenshotHelper.captureScreenshotBase64(driver);
        test.log(Status.PASS, "Verified My Info page is loaded",
                 MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    @Step("Verify DOB field is filled")
    public void verifyDOBFilled() {
        waitForElementClickable(dobTextbox);
        String dobValue = driver.findElement(dobTextbox).getAttribute("value");
        Assert.assertFalse(dobValue.isEmpty(), "DOB field should not be empty");

        test.log(Status.INFO, "Verified DOB field is filled with value: " + dobValue);
    }

    @Step("Update DOB to {newDob}")
    public void updateDOB(String newDob) {
        waitForElementClickable(dobTextbox);
        driver.findElement(dobTextbox).clear();
        driver.findElement(dobTextbox).sendKeys(newDob);

        test.log(Status.INFO, "Updated DOB field with new value: " + newDob);
    }

    @Step("Click Save button")
    public void clickSave() {
        waitForElementClickable(saveButton);
        driver.findElement(saveButton).click();
        test.log(Status.INFO, "Clicked on Save button");
    }

    @Step("Open profile dropdown")
    public void openProfileDropdown() {
        waitForElementClickable(profileTab);
        driver.findElement(profileTab).click();
        test.log(Status.INFO, "Opened profile dropdown");
    }

    @Step("Click Logout button")
    public void clickLogout() {
        waitForElementClickable(logoutButton);
        driver.findElement(logoutButton).click();
        test.log(Status.INFO, "Clicked on Logout button");
    }
}
