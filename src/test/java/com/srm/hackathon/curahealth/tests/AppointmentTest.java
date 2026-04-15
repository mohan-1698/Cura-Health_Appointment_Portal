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

	    // Login
	    homePage.navigateToLogin();
	    loginPage.login("John Doe", "ThisIsNotAPassword");

	    // Fill form
	    appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
	    appointmentPage.selectReadmission();
	    appointmentPage.selectProgram("Medicare");
	    appointmentPage.enterVisitDate("30/04/2026");
	    appointmentPage.enterComment("Test Booking");

	    appointmentPage.bookAppointment();

	    // ✅ ADD THIS (VERY IMPORTANT)
	    Assert.assertTrue(
	        confirmationPage.isConfirmationPageDisplayed(),
	        "Confirmation page not displayed"
	    );

	    // Validate confirmation
	    Assert.assertEquals(
	        confirmationPage.getFacility(),
	        "Hongkong CURA Healthcare Center"
	    );

	    Assert.assertEquals(
	        confirmationPage.getVisitDate(),
	        "30/04/2026"
	    );

	    Assert.assertEquals(
	        confirmationPage.getReadmission(),
	        "Yes"
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
}