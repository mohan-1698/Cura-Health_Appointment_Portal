package com.srm.hackathon.curahealth.pages;

import org.openqa.selenium.By;
import com.srm.hackathon.curahealth.base.BasePage;

public class ConfirmationPage extends BasePage {

    private By summaryHeader = By.xpath("//section[@id='summary']//h2");

    private By facility = By.xpath("//section[@id='summary']//p[@id='facility']");
    private By visitDate = By.xpath("//section[@id='summary']//p[@id='visit_date']");
    private By readmission = By.xpath("//section[@id='summary']//p[@id='hospital_readmission']");

    public boolean isConfirmationPageDisplayed() {
        return isDisplayed(summaryHeader);
    }

    public String getFacility() {
        return getText(facility);
    }

    public String getVisitDate() {
        return getText(visitDate);
    }

    public String getReadmission() {
        return getText(readmission);
    }
}