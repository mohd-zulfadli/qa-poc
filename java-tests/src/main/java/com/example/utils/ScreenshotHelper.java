package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    /**
     * Capture screenshot and save to target/screenshots/<testCaseId>_screen/<stepName>_<timestamp>.png
     * Returns the relative path for ExtentReports embedding.
     */
    public static String captureScreenshot(WebDriver driver, String testCaseId, String stepName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Directory: target/screenshots/Deriv_SC1TC1_screen/
            String dirPath = "target/screenshots/" + testCaseId + "_screen/";
            Files.createDirectories(Paths.get(dirPath));

            // Add timestamp to avoid overwriting
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destPath = dirPath + stepName + "_" + timestamp + ".png";

            Files.copy(srcFile.toPath(), Paths.get(destPath));

            // Return relative path for ExtentReports
            return destPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Capture screenshot and return Base64 string for inline embedding in ExtentReports.
     */
    public static String captureScreenshotBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
