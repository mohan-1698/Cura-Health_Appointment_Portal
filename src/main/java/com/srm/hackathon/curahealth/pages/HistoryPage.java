package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.srm.hackathon.curahealth.base.BasePage;
import com.srm.hackathon.curahealth.factory.DriverManager;

public class HistoryPage extends BasePage {

    private By historyPanels = By.cssSelector(".panel.panel-info");

    // FIXED (important)
    private By facility = By.xpath("(//p[@id='facility'])[1]");
    private By dateHeader = By.className("panel-heading");

    public boolean isHistoryPageDisplayed() {
        return isDisplayed(historyPanels);
    }

    public int getAppointmentCount() {
        List<WebElement> elements = DriverManager.getDriver().findElements(historyPanels);
        return elements.size();
    }

    public String getLatestFacility() {
        return getText(facility);
    }

    public String getLatestDate() {
        return getText(dateHeader);
    }
}