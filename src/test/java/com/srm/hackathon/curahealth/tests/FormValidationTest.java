package com.srm.hackathon.curahealth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.curahealth.base.BaseTest;
import com.srm.hackathon.curahealth.pages.*;
import com.srm.hackathon.curahealth.utils.ConfigReader;
import com.google.gson.JsonObject;
import com.srm.hackathon.curahealth.dataproviders.AppointmentDataProvider;

public class FormValidationTest extends BaseTest {

    @Test
    public void testEmptyDateValidation() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AppointmentPage appointmentPage = new AppointmentPage();

        homePage.navigateToLogin();
        loginPage.login(
        	    ConfigReader.getUsername(),
        	    ConfigReader.getPassword()
        	);

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

    @Test(
    	    dataProvider = "appointmentData",
    	    dataProviderClass = AppointmentDataProvider.class
    	)
    	public void testLongComment(JsonObject data) {

    	    HomePage homePage = new HomePage();
    	    LoginPage loginPage = new LoginPage();
    	    AppointmentPage appointmentPage = new AppointmentPage();
    	    ConfirmationPage confirmationPage = new ConfirmationPage();

    	    homePage.navigateToLogin();
    	    loginPage.login(
    	        ConfigReader.getUsername(),
    	        ConfigReader.getPassword()
    	    );

    	    // Override only comment with long text
    	    String longText = "A".repeat(500);

    	    appointmentPage.selectFacility(data.get("facility").getAsString());
    	    appointmentPage.selectProgram(data.get("program").getAsString());
    	    appointmentPage.enterVisitDate(data.get("date").getAsString());
    	    appointmentPage.enterComment(longText);

    	    appointmentPage.bookAppointment();

    	    Assert.assertTrue(
    	        confirmationPage.isConfirmationPageDisplayed(),
    	        "Long comment caused failure"
    	    );
    	}
}