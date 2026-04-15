package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.HomePage;
import com.srm.hackathon.curahealth.pages.LoginPage;
import com.srm.hackathon.curahealth.pages.AppointmentPage;

public class LoginTest extends BaseTest {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = com.srm.hackathon.curahealth.dataproviders.LoginDataProvider.class
    )
    public void testLogin(String username, String password, String expectedResult) {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AppointmentPage appointmentPage = new AppointmentPage();

        // Step 1: Navigate to Login Page
        homePage.navigateToLogin();

        // Step 2: Perform login
        loginPage.login(username, password);

        // Step 3: Validation
        if (expectedResult.equalsIgnoreCase("valid")) {

            // Validate using page element (NOT URL)
            Assert.assertTrue(
                appointmentPage.isAppointmentPageDisplayed(),
                "User is not navigated to appointment page after valid login"
            );

        } else {

            // Invalid login → Error message
            Assert.assertTrue(
                loginPage.getErrorMessage().contains("Login failed"),
                "Error message not displayed for invalid login"
            );
        }
    }

    @Test
    public void testLogout() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AppointmentPage appointmentPage = new AppointmentPage();

        // Step 1: Navigate to Login
        homePage.navigateToLogin();

        // Step 2: Login
        loginPage.login("John Doe", "ThisIsNotAPassword");

        // Step 3: Logout
        appointmentPage.logout();

        // Step 4: Validate Home Page using element
        Assert.assertTrue(
            homePage.isHomePageDisplayed(),
            "User is not navigated to home page after logout"
        );
    }

    @Test
    public void testUnauthorizedAccess() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        // REAL user action
        homePage.clickMakeAppointment();

        // Validate login page
        Assert.assertTrue(
            loginPage.isLoginPageDisplayed(),
            "User is not redirected to login page when trying to access appointment without login"
        );
    }
}