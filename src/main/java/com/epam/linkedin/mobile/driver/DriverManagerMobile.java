package com.epam.linkedin.mobile.driver;

import com.epam.linkedin.mobile.data.MobileStorage;
import com.epam.linkedin.properties.UrlsStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

@Log4j2
public class DriverManagerMobile {

    private static final String APP_PROPERTIES = "mobile/xiaomiOreoDevice.properties";
    private static final String PROJECT_NAME = "EPM-TSTF";
    private static final String API_KEY = "45a97a97-8b3b-41d5-86b3-f2c93f1c182b";
    private static final String APPIUM_HUB = "mobilecloud.epam.com:8080";
    private static final String PLATFORM_NAME = "Android";
    private static final String PLATFORM_VERSION = "7.0";
    private static final String DEVICE_NAME = "SAMSUNG SM-T813";
    private static final String UDID = "68d46040051cd756";
    private static final String APP_PACKAGE = "com.linkedin.android";
    private static final String APP_ACTIVITY = "com.linkedin.android.authenticator.LaunchActivity";

    private static ThreadLocal<AppiumDriver<MobileElement>> threadLocalDriver = new ThreadLocal<>();

    public static AppiumDriver<MobileElement> getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver() {
        threadLocalDriver.set(getAndroidFarmDriver());
    }

    @SneakyThrows(IOException.class)
    private static AppiumDriver<MobileElement> getAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        MobileStorage.getDataFromAndroidProperty(APP_PROPERTIES).forEach(capabilities::setCapability);
        return new AppiumDriver<>(new URL(UrlsStorage.getAndroidHubAddress()), capabilities);
    }

    @SneakyThrows(MalformedURLException.class)
    private static AppiumDriver<MobileElement> getAndroidFarmDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("udid", UDID);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        return new AppiumDriver<>(new URL(format("http://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)), capabilities);
    }
}