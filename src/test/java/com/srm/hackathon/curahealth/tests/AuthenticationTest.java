package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.AppointmentPage;
import com.srm.hackathon.curahealth.pages.HomePage;
import com.srm.hackathon.curahealth.pages.LoginPage;

public class AuthenticationTest extends BaseTest {

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

        // 🔥 Reinitialize after page transition
        appointmentPage = new AppointmentPage();
        loginPage = new LoginPage();

        // Step 3: Validation
        if (expectedResult.equalsIgnoreCase("valid")) {

            Assert.assertTrue(
                appointmentPage.isAppointmentPageDisplayed(),
                "User is not navigated to appointment page after valid login"
            );

        } else {

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

        // 🔥 Reinitialize after login
        appointmentPage = new AppointmentPage();

        // Step 3: Logout
        appointmentPage.logout();

        // 🔥 Reinitialize after navigation
        homePage = new HomePage();

        // Step 4: Validate Home Page
        Assert.assertTrue(
            homePage.isHomePageDisplayed(),
            "User is not navigated to home page after logout"
        );
    }

    @Test
    public void testUnauthorizedAccess() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        // Step 1: Try accessing protected section
        homePage.clickMakeAppointment();

        // 🔥 Reinitialize after navigation
        loginPage = new LoginPage();

        // Step 2: Validate redirected to login
        Assert.assertTrue(
            loginPage.isLoginPageDisplayed(),
            "User is not redirected to login page when accessing without authentication"
        );
    }
}