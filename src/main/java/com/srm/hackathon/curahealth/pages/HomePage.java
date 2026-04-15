package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.curahealth.base.BasePage;

public class HomePage extends BasePage {

    // Locators
    private By menuToggle = By.id("menu-toggle");
    private By loginLink = By.linkText("Login");
    private By makeAppointmentBtn = By.id("btn-make-appointment");

    // Actions

    public void openMenu() {
        click(menuToggle);
    }

    public void clickLogin() {
        click(loginLink);
    }

    public void navigateToLogin() {
        openMenu();
        clickLogin();
    }

    // ✅ Used for unauthorized access test
    public void clickMakeAppointment() {
        click(makeAppointmentBtn);
    }

    // ✅ Used for logout validation
    public boolean isHomePageDisplayed() {
        return isDisplayed(makeAppointmentBtn);
    }
}