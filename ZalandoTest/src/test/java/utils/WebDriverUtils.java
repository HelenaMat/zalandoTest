package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
    public static WebDriver getWebDriver() {
        // Set the geckodriver path if needed
        System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
        return new FirefoxDriver();
    }

    public static void quitWebDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
