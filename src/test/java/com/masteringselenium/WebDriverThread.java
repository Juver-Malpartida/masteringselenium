package com.masteringselenium;

import com.masteringselenium.config.DriverSetup;
import com.masteringselenium.config.IDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverThread {
    private WebDriver webDriver;
    private IDriverSetup selectedDriverType;
    private final IDriverSetup defaultDriverType = DriverSetup.FIREFOX;
    private final String browser = System.getProperty("browser").toUpperCase();
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch").toUpperCase();

    public WebDriver getDriver() {
        if (webDriver == null) {
            selectedDriverType = determineEffectiveDriverType();
            DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
            instantiateWebDriver(desiredCapabilities);
        }
        return webDriver;
    }

    private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
        System.out.println(" ");
        System.out.println("Current Operating System: " + operatingSystem);
        System.out.println("Current Architecture: " + systemArchitecture);
        System.out.println("Current Browser Selection: " + selectedDriverType);
        System.out.println(" ");
        webDriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
    }

    private IDriverSetup determineEffectiveDriverType() {
        IDriverSetup driverType = defaultDriverType;
        try {
            driverType = DriverSetup.valueOf(browser);
        } catch (IllegalArgumentException ignored){
            System.err.println("Unknow Driver Specified using default to " + driverType);
        } catch (NullPointerException ignored) {
            System.err.println("No Driver Specified using default to " + driverType);
        }
        return  driverType;
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
