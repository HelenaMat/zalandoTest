package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

package com.example.webapp.utils;

        import com.microsoft.playwright.Browser;
        import com.microsoft.firefox();


public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            // Add any additional options if needed
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
