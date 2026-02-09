package com.example.tests;

import com.example.base.BaseTest;
import com.example.config.TestConfig;
import com.example.pages.DerivSignInPage;
import com.example.pages.DerivAdminPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class Scenario1Test extends BaseTest {
    private DerivSignInPage signInPage;
    private DerivAdminPage adminPage;

    @BeforeMethod
    public void initPages() {
        // Pass both driver and Extent report test objects
        signInPage = new DerivSignInPage(driver, test);
        adminPage = new DerivAdminPage(driver, test);
    }

    @Test(priority = 1, groups = {"web", "smoke"})
    public void testLogin() {
        driver.get(TestConfig.DD_URL);
        signInPage.enterValidCredentials(TestConfig.DERIV_USER, TestConfig.DERIV_PASS);
        signInPage.clickLogin();
        signInPage.verifyDashboardVisible();
    }

    @Test(priority = 2, groups = {"web"})
    public void testUpdateDOB() {
        adminPage.clickMyInfo();
        adminPage.verifyMyInfoLoaded();
        adminPage.verifyDOBFilled();
        adminPage.updateDOB("1992-12-12");
        adminPage.clickSave();
    }

    @Test(priority = 3, groups = {"web", "smoke"})
    public void testLogout() {
        adminPage.openProfileDropdown();
        adminPage.clickLogout();
        signInPage.verifyLoginPageShown();
    }
}
