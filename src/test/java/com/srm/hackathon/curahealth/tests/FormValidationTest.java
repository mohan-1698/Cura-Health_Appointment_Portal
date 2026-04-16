package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.*;

public class FormValidationTest extends BaseTest {

    @Test
    public void testEmptyDateValidation() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AppointmentPage appointmentPage = new AppointmentPage();

        homePage.navigateToLogin();
        loginPage.login("John Doe", "ThisIsNotAPassword");

        appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
        appointmentPage.selectProgram("Medicare");
        appointmentPage.enterComment("No date");

        appointmentPage.bookAppointment();

        Assert.assertTrue(
            appointmentPage.isAppointmentPageDisplayed(),
            "Form submitted without date"
        );
    }

    @Test
    public void testEmptyLogin() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.navigateToLogin();
        loginPage.login("", "");

        Assert.assertTrue(
            loginPage.isLoginPageDisplayed(),
            "Login should fail for empty credentials"
        );
    }

    @Test
    public void testLongComment() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AppointmentPage appointmentPage = new AppointmentPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();

        homePage.navigateToLogin();
        loginPage.login("John Doe", "ThisIsNotAPassword");

        String longText = "A".repeat(500);

        appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
        appointmentPage.selectProgram("Medicare");
        appointmentPage.enterVisitDate("30/04/2026");
        appointmentPage.enterComment(longText);

        appointmentPage.bookAppointment();

        Assert.assertTrue(
            confirmationPage.isConfirmationPageDisplayed(),
            "Long comment caused failure"
        );
    }
}