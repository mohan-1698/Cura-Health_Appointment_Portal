package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.curahealth.base.BasePage;

public class HomePage extends BasePage {

    private By menuToggle = By.id("menu-toggle");
    private By loginLink = By.linkText("Login");
    private By makeAppointmentBtn = By.id("btn-make-appointment");

    public void openMenu() {
        waitForVisibility(menuToggle);
        click(menuToggle);
    }

    public void clickLogin() {
        waitForVisibility(loginLink);
        click(loginLink);
    }

    public void navigateToLogin() {
        openMenu();
        clickLogin();
    }

    public void clickMakeAppointment() {
        waitForVisibility(makeAppointmentBtn);
        click(makeAppointmentBtn);
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(makeAppointmentBtn);
    }
}