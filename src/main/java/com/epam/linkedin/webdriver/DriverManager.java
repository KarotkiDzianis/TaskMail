package com.epam.linkedin.webdriver;

import com.epam.linkedin.properties.UrlsStorage;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Log4j2
public class DriverManager {

    private static final String CHROMEDRIVER_EXE_PATH = "src\\main\\resources\\webdrivers\\chromedriver\\chromedriver.exe";
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public enum EnvironmentType {LOCAL, GRID}

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(EnvironmentType type) {
        switch (type) {
            case GRID:
                threadLocalDriver.set(getRemoteChromeDriver());
                break;
            case LOCAL:
                threadLocalDriver.set(getChromeDriver());
                break;
        }
        log.info(type + " environment is chosen.");
    }

    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            threadLocalDriver.remove();
        }
    }

    private static WebDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        log.info("Browser started!");
        return driver;
    }

    @SneakyThrows(MalformedURLException.class)
    private static RemoteWebDriver getRemoteChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(UrlsStorage.getHubAddress()), options);
        remoteWebDriver.manage().window().maximize();
        remoteWebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        remoteWebDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return remoteWebDriver;
    }
}
