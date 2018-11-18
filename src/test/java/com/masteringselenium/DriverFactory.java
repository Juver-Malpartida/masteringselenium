package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {
    private  static ThreadLocal<WebDriverThread> driverThread;
    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    @BeforeSuite
    public static void BeforeSuite(){
        driverThread = new ThreadLocal<WebDriverThread>(){
            @Override
            protected WebDriverThread initialValue(){
                WebDriverThread webDriverThread = new WebDriverThread();
                return  webDriverThread;
            }
        };
    }

    @AfterMethod
    public static void quitDriver() throws Exception {
        driverThread.get().quitDriver();
    }
}
