package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;

import com.srm.hackathon.curahealth.base.BasePage;

public class LoginPage extends BasePage {

    // ================= LOCATORS =================

    private By usernameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginBtn = By.id("btn-login");
    private By errorMessage = By.cssSelector(".text-danger");

    // ================= ACTION METHODS =================

    // Enter username
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    // Enter password
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    // Click login button
    public void clickLogin() {
        click(loginBtn);
    }

    // Perform login (ONLY login logic, no navigation)
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Get error message (invalid login)
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    // Check if login page is displayed
    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginBtn);
    }
}