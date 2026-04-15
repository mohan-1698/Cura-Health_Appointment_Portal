package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.curahealth.base.BasePage;

public class HistoryPage extends BasePage {

    private By facility = By.id("facility");
    private By dateHeader = By.className("panel-heading");

    public String getFacility() {
        return getText(facility);
    }

    public String getDate() {
        return getText(dateHeader);
    }
}