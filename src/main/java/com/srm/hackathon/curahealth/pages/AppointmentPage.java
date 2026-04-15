package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.curahealth.base.BasePage;

public class AppointmentPage extends BasePage {

    // Locators
    private By menuToggle = By.id("menu-toggle");
    private By logoutLink = By.linkText("Logout");

    // ✅ Add this locator (used to verify appointment page)
    private By facilityDropdown = By.id("combo_facility");

    // Actions

    // Logout action
    public void logout() {
        click(menuToggle);
        click(logoutLink);
    }

    // ✅ ADD THIS METHOD (fix for your error)
    public boolean isAppointmentPageDisplayed() {
        return isDisplayed(facilityDropdown);
    }
}