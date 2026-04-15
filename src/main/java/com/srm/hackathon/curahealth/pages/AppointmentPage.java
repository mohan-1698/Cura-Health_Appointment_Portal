package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.srm.hackathon.curahealth.base.BasePage;

public class AppointmentPage extends BasePage {

    private By menuToggle = By.id("menu-toggle");
    private By historyLink = By.linkText("History");
    private By homeLink = By.linkText("Home");

    private By facilityDropdown = By.id("combo_facility");
    private By readmissionCheckbox = By.id("chk_hospotal_readmission");
    private By medicareRadio = By.id("radio_program_medicare");
    private By medicaidRadio = By.id("radio_program_medicaid");
    private By noneRadio = By.id("radio_program_none");
    private By visitDate = By.id("txt_visit_date");
    private By commentBox = By.id("txt_comment");
    private By bookBtn = By.id("btn-book-appointment");

    public boolean isAppointmentPageDisplayed() {
        return isDisplayed(facilityDropdown);
    }

    public void selectFacility(String facility) {
        Select select = new Select(waitForVisibility(facilityDropdown));
        select.selectByVisibleText(facility);
    }

    public void selectReadmission() {
        click(readmissionCheckbox);
    }

    public void selectProgram(String program) {
        switch (program.toLowerCase()) {
            case "medicare":
                click(medicareRadio);
                break;
            case "medicaid":
                click(medicaidRadio);
                break;
            case "none":
                click(noneRadio);
                break;
        }
    }

    public void enterVisitDate(String date) {
        WebElement element = waitForVisibility(visitDate);
        element.clear();
        element.sendKeys(date);
        element.sendKeys(Keys.TAB);
    }

    public void enterComment(String comment) {
        type(commentBox, comment);
    }

    public void bookAppointment() {
        click(bookBtn);
    }

    public void goToHistory() {
        waitForVisibility(menuToggle);
        click(menuToggle);

        waitForVisibility(historyLink);
        click(historyLink);
    }

    public void goToHomeFromMenu() {
        waitForVisibility(menuToggle);
        click(menuToggle);

        waitForVisibility(homeLink);
        click(homeLink);
    }

    public void scrollToAppointmentForm() {
        scrollToElement(facilityDropdown);
    }

    public void waitForAppointmentForm() {
        waitForVisibility(facilityDropdown);
    }
    
    private By logoutLink = By.linkText("Logout");

    public void logout() {
        waitForVisibility(menuToggle);
        click(menuToggle);

        waitForVisibility(logoutLink);
        click(logoutLink);
    }
}