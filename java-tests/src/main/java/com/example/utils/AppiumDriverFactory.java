package com.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {
    public static AppiumDriver<MobileElement> createAndroidDriver(String serverUrl, String deviceName, String platformName,
                                                                  String appPackage, String appActivity) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformName", platformName);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("automationName", "UiAutomator2");

        return new AppiumDriver<>(new URL(serverUrl), caps);
    }
}
