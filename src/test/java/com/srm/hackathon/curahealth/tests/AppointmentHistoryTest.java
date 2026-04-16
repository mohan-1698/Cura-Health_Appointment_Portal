package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.*;

public class AppointmentHistoryTest extends BaseTest {

    @Test
    public void testAppointmentHistory() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AppointmentPage appointmentPage = new AppointmentPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();
        HistoryPage historyPage = new HistoryPage();

        homePage.navigateToLogin();
        loginPage.login("John Doe", "ThisIsNotAPassword");

        appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
        appointmentPage.selectProgram("Medicare");
        appointmentPage.enterVisitDate("25/04/2026");
        appointmentPage.enterComment("History Test");

        appointmentPage.bookAppointment();

        Assert.assertTrue(confirmationPage.isConfirmationPageDisplayed());

        appointmentPage.goToHistory();

        Assert.assertTrue(historyPage.isHistoryPageDisplayed());

        Assert.assertEquals(
            historyPage.getLatestFacility(),
            "Tokyo CURA Healthcare Center"
        );

        // 🔥 HEADER VALIDATION (important)
        Assert.assertTrue(
            historyPage.getAppointmentCount() > 0,
            "No history records found"
        );
    }
}