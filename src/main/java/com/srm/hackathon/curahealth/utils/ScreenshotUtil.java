package com.srm.hackathon.curahealth.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.srm.hackathon.curahealth.factory.DriverManager;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        File src = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/screenshots/"
                + testName + "_" + timestamp + ".png";

        try {
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            src.renameTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}