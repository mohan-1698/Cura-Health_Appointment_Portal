package com.srm.hackathon.curahealth.factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Set driver
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Get driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // VERY IMPORTANT (memory leak prevention)
        }
    }
}