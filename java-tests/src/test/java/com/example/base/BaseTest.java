package com.example.base;

import com.example.utils.WebDriverFactory;
import com.example.config.TestConfig;
import com.example.utils.ExtentManager;   // <-- new utility
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        // Initialize global ExtentReports instance
        extent = ExtentManager.getInstance();
    }

    @BeforeClass
    public void setUp() {
        // Create driver using factory (default Chrome, can be parameterized)
        driver = WebDriverFactory.createDriver(TestConfig.BROWSER);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void startTest(Method method) {
        // Each test method gets its own ExtentTest entry
        test = extent.createTest(method.getName());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        // Write out the report at the end of the suite
        extent.flush();
    }
}
