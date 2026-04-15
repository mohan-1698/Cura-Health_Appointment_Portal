package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.*;

public class AppointmentTest extends BaseTest {

	@Test
	public void testBookAppointment() {

	    HomePage homePage = new HomePage();
	    LoginPage loginPage = new LoginPage();
	    AppointmentPage appointmentPage = new AppointmentPage();
	    ConfirmationPage confirmationPage = new ConfirmationPage();

	    homePage.navigateToLogin();
	    loginPage.login("John Doe", "ThisIsNotAPassword");

	    appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
	    appointmentPage.selectReadmission();
	    appointmentPage.selectProgram("Medicare");
	    appointmentPage.enterVisitDate("30/04/2026");
	    appointmentPage.enterComment("Test Booking");

	    appointmentPage.bookAppointment();

	    Assert.assertTrue(
	        confirmationPage.isConfirmationPageDisplayed(),
	        "Confirmation page not displayed"
	    );
	}
	
	@Test
	public void testPastDateValidation() {

	    HomePage homePage = new HomePage();
	    LoginPage loginPage = new LoginPage();
	    AppointmentPage appointmentPage = new AppointmentPage();
	    

	    // Login
	    homePage.navigateToLogin();
	    loginPage.login("John Doe", "ThisIsNotAPassword");

	    // Fill form with past date
	    appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
	    appointmentPage.selectReadmission();
	    appointmentPage.selectProgram("Medicare");
	    appointmentPage.enterVisitDate("01/01/2020");
	    appointmentPage.enterComment("Past Date Test");

	    appointmentPage.bookAppointment();

	    // Better validation
	    Assert.assertTrue(
	    	    appointmentPage.isAppointmentPageDisplayed(),
	    	    "Past date was accepted and user navigated to confirmation page, but it should be rejected"
	    	);
	}
	
	@Test
	public void testAppointmentHistory() {

	    HomePage homePage = new HomePage();
	    LoginPage loginPage = new LoginPage();
	    AppointmentPage appointmentPage = new AppointmentPage();
	    ConfirmationPage confirmationPage = new ConfirmationPage();
	    HistoryPage historyPage = new HistoryPage();

	    // Login
	    homePage.navigateToLogin();
	    loginPage.login("John Doe", "ThisIsNotAPassword");

	    // Book appointment
	    appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
	    appointmentPage.selectProgram("Medicare");
	    appointmentPage.enterVisitDate("25/04/2026");
	    appointmentPage.enterComment("History Test");

	    appointmentPage.bookAppointment();

	    // Ensure confirmation
	    Assert.assertTrue(confirmationPage.isConfirmationPageDisplayed());

	    // Go to history
	    appointmentPage.goToHistory();

	    // Validate history page
	    Assert.assertTrue(historyPage.isHistoryPageDisplayed());

	    // Validate latest entry
	    Assert.assertEquals(
	        historyPage.getLatestFacility(),
	        "Tokyo CURA Healthcare Center"
	    );
	}
	
	@Test
	public void testMultipleAppointments() {

	    HomePage homePage = new HomePage();
	    LoginPage loginPage = new LoginPage();
	    AppointmentPage appointmentPage = new AppointmentPage();
	    HistoryPage historyPage = new HistoryPage();

	    homePage.navigateToLogin();
	    loginPage.login("John Doe", "ThisIsNotAPassword");

	    // First booking
	    appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
	    appointmentPage.selectProgram("Medicare");
	    appointmentPage.enterVisitDate("26/04/2026");
	    appointmentPage.enterComment("First Booking");
	    appointmentPage.bookAppointment();

	    // Navigate back
	    appointmentPage.goToHomeFromMenu();

	    // 🔥 Reinitialize (VERY IMPORTANT)
	    homePage = new HomePage();
	    appointmentPage = new AppointmentPage();

	    // Scroll to form
	    appointmentPage.scrollToAppointmentForm();
	    appointmentPage.waitForAppointmentForm();

	    // Second booking
	    appointmentPage.selectFacility("Seoul CURA Healthcare Center");
	    appointmentPage.selectProgram("None");
	    appointmentPage.enterVisitDate("27/04/2026");
	    appointmentPage.enterComment("Second Booking");
	    appointmentPage.bookAppointment();

	    // Validate history
	    appointmentPage.goToHistory();

	    Assert.assertTrue(
	        historyPage.getAppointmentCount() >= 2,
	        "Multiple appointments not found"
	    );
	}
}