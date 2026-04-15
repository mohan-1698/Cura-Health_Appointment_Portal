package com.srm.hackathon.curahealth.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.srm.hackathon.curahealth.factory.DriverFactory;
import com.srm.hackathon.curahealth.factory.DriverManager;
import com.srm.hackathon.curahealth.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize driver
        DriverFactory.initDriver();

        // Get driver from DriverManager
        driver = DriverManager.getDriver();

        // Open application URL
        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        // Quit driver
        DriverManager.quitDriver();
    }
}