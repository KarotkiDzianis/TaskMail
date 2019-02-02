package com.epam.linkedin.webdriver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

@Log4j2
public class DriverManager {


    private static final String CHROMEDRIVER_EXE_PATH = "src\\main\\resources\\webdriver\\chromedriver.exe";
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver;
        } else {
            return driver;
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


