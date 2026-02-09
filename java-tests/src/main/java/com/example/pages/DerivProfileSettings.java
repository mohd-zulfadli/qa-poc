package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DerivProfileSettings {
    private WebDriver driver;

    private By settingsElement = By.xpath("//*[@id='root']/div/main/div/div[1]/div/h1");
    private By cityElement = By.xpath("//*[@id='city']");
    private By disclaimerElement = By.xpath("//*[@id='root']/div/div/footer/span[1]");

    public DerivProfileSettings(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyTopPage() {
        Assert.assertTrue(driver.findElement(settingsElement).isDisplayed());
    }

    public void verifyMidPage() {
        Assert.assertTrue(driver.findElement(cityElement).isDisplayed());
    }

    public void verifyBottomPage() {
        Assert.assertTrue(driver.findElement(disclaimerElement).isDisplayed());
    }
}
