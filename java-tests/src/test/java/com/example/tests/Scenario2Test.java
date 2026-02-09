package com.example.tests;

import com.example.base.BaseTest;
import com.example.config.TestConfig;
import com.example.utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Scenario2Test {
    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = AppiumDriverFactory.createAndroidDriver(
                TestConfig.APPIUM_SERVER,
                TestConfig.DEVICE_NAME,
                TestConfig.PLATFORM,
                TestConfig.APP_PACKAGE,
                TestConfig.APP_ACTIVITY
        );
    }

    @Test(priority = 1, groups = {"mobile"})
    public void testAddition() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='clear']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(result, "3");
    }

    @Test(priority = 2, groups = {"mobile"})
    public void testSubtraction() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='clear']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='minus']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(result, "-1");
    }

    @Test(priority = 3, groups = {"mobile"})
    public void testMultiplication() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='clear']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='multiply']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(result, "2");
    }

    @Test(priority = 4, groups = {"mobile"})
    public void testDivision() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='clear']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='divide']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(result, "0.5");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
