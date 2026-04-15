package com.srm.hackathon.curahealth.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    // Get Browser
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    // Get Base URL
    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    // Get Timeout
    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
    
    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }
}