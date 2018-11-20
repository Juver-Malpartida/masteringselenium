package com.masteringselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum DriverSetup implements IDriverSetup {
    FIREFOX {
        public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
            FirefoxOptions options = new FirefoxOptions();
            options.merge(desiredCapabilities);
            return new FirefoxDriver(options);
        }

        public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            return  capabilities;
        }
    },
    CHROME {
        public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
            ChromeOptions options = new ChromeOptions();
            options.merge(desiredCapabilities);
            return new ChromeDriver(options);
        }

        public DesiredCapabilities getDesiredCapabilities() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            return  capabilities;
        }
    };
}
