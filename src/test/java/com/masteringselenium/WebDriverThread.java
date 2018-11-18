package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverThread {
    private WebDriver webDriver;

    public WebDriver getDriver() {
        if (webDriver == null) {

            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
