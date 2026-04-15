package com.srm.hackathon.curahealth.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.srm.hackathon.curahealth.utils.ConfigReader;

public class DriverFactory {

    public static void initDriver() {

        String browser = ConfigReader.getBrowser().toLowerCase();
        WebDriver driver;

        switch (browser) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                prefs.put("profile.password_manager_leak_detection_enabled", false);

                options.setExperimentalOption("prefs", prefs);

                if (ConfigReader.isHeadless()) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }

                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-popup-blocking");

                // 🔥 ADD THIS
                options.addArguments("--disable-save-password-bubble");

                driver = new ChromeDriver(options);
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser in config.properties");
        }

        // Maximize (only works in non-headless)
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            // Ignore for headless mode
        }

        // Set driver to ThreadLocal
        DriverManager.setDriver(driver);
    }
}