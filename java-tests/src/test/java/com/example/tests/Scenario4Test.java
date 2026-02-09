package com.example.tests;

import com.example.base.BaseTest;
import com.example.config.TestConfig;
import com.example.pages.DerivMain;
import com.example.pages.DerivProfileSettings;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario4Test extends BaseTest {
    private DerivMain mainPage;
    private DerivProfileSettings profileSettings;

    @BeforeMethod
    public void initPages() {
        mainPage = new DerivMain(driver);
        profileSettings = new DerivProfileSettings(driver);
    }

    @Test(priority = 1, groups = {"web", "responsive"})
    public void testResponsiveSite() {
        mainPage.goToResponsiveSite(TestConfig.MR_URL);
        profileSettings.verifyTopPage();
        profileSettings.verifyMidPage();
        profileSettings.verifyBottomPage();
    }
}
