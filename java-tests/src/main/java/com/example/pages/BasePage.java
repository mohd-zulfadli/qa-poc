package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /** Wait until the DOM is fully loaded */
    protected void waitForPageLoadComplete() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                .equals("complete"));
    }

    /** Wait until no loading spinner is visible */
    protected void waitForNoSpinner() {
        By spinner = By.cssSelector(".loading-spinner");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    }

    /** Generic helper: wait until element is visible */
    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** ✅ NEW: Wait until element is clickable */
    protected void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /** ✅ NEW: Wait until element text stops changing */
    protected void waitForStableText(By locator) {
        wait.until(driver -> {
            String text1 = driver.findElement(locator).getText();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            String text2 = driver.findElement(locator).getText();
            return !text1.isEmpty() && text1.equals(text2);
        });
    }

}
