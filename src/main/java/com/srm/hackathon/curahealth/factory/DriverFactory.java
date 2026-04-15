package com.srm.hackathon.curahealth.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.srm.hackathon.curahealth.utils.ConfigReader;

public class DriverFactory {

    public static void initDriver() {

        String browser = ConfigReader.getBrowser().toLowerCase();
        WebDriver driver;

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser in config.properties");
        }

        driver.manage().window().maximize();

        // Set driver to ThreadLocal
        DriverManager.setDriver(driver);
    }
}