package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPageVar {
    private WebDriver driver;
    private WebDriverWait wait;

    public LandingPageVar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void loadDerivDemo(String url) {
        wait.until(ExpectedConditions.urlContains(url));
        driver.get(url);
    }

    public void loadDerivMobileResponsive(String url) {
        wait.until(ExpectedConditions.urlContains(url));
        driver.get(url);

    }
}
