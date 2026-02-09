package com.example.pages;

import org.openqa.selenium.WebDriver;

public class DerivMain {
    private WebDriver driver;

    public DerivMain(WebDriver driver) {
        this.driver = driver;
    }

    public void goToDemoSite(String url) {
        driver.get(url);
    }

    public void goToResponsiveSite(String url) {
        driver.get(url);
    }
}
