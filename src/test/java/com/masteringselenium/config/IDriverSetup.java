package com.masteringselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IDriverSetup {

    WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);
    DesiredCapabilities getDesiredCapabilities();
}
