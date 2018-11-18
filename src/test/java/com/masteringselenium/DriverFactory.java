package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverFactory {

    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
    private static ThreadLocal<WebDriverThread> driverThread;

    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    @BeforeSuite
    public static void BeforeSuite(){
        System.out.println("BEFORE SUITE!!!!");
        driverThread = new ThreadLocal<WebDriverThread>(){
            @Override
            protected WebDriverThread initialValue(){
                System.out.println("CREATE DRIVER");
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread);
                return  webDriverThread;
            }
        };
    }

    @AfterMethod
    public static void quitDriver() throws Exception {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public static void AfterSuite(){
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }
}
