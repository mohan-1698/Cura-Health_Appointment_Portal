package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.AppointmentPage;
import com.srm.hackathon.curahealth.pages.HistoryPage;
import com.srm.hackathon.curahealth.pages.HomePage;
import com.srm.hackathon.curahealth.pages.LoginPage;
import com.srm.hackathon.curahealth.utils.ConfigReader;

public class MultipleAppointmentsTest extends BaseTest {
	
	@Test
	public void testMultipleAppointments() {

	    HomePage homePage = new HomePage();
	    LoginPage loginPage = new LoginPage();
	    AppointmentPage appointmentPage = new AppointmentPage();
	    HistoryPage historyPage = new HistoryPage();

	    homePage.navigateToLogin();
	    loginPage.login(
	    	    ConfigReader.getUsername(),
	    	    ConfigReader.getPassword()
	    	);

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
