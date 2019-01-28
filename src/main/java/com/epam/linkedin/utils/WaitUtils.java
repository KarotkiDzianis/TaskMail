package com.epam.linkedin.utils;

import com.epam.linkedin.webdriver.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class allows to wait until an element shows up.
 */
public class WaitUtils {

    /**
     * Default timeout value
     */
    private static final int DEFAULT_TIMEOUT = 20;

    /**
     * This method create WebDriverWait object
     *
     * @param timeOut is a value of timeout that you want to set up
     * @return WebDriverWait object with certain timeout
     */
    private static WebDriverWait createWait(int timeOut) {
        return new WebDriverWait(DriverManager.getDriver(), timeOut);
    }

    /**
     * Overload waitForVisibility method
     *
     * @param webElement is a field that doesn't changes when method overloads
     */
    public static void waitForVisibility(WebElement webElement) {
        waitForVisibility(webElement, DEFAULT_TIMEOUT);
    }

    /**
     * Allows to wait until an element appears
     *
     * @param webElement    is a field that doesn't changes when method overloads
     * @param wantedTimeOut is a value of timeout that you want to set up
     */
    public static void waitForVisibility(WebElement webElement, int wantedTimeOut) {
        createWait(wantedTimeOut).until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Overload waitUntilPageIsLoaded method with default timeout
     */
    public static void waitUntilPageIsLoaded() {
        waitUntilPageIsLoaded(DEFAULT_TIMEOUT);
    }

    /**
     * Allows to wait until a page is loaded
     *
     * @param wantedTimeOut is a value of timeout that you want to set up
     */
    private static void waitUntilPageIsLoaded(int wantedTimeOut) {
        createWait(wantedTimeOut).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Allows to wait until a page is loaded
     *
     * @param wantedTimeOutInMilliseconds is a value of timeout that you want to set up
     */
    @SneakyThrows(InterruptedException.class)
    public static void sleep(int wantedTimeOutInMilliseconds) {
        TimeUnit.MILLISECONDS.sleep(wantedTimeOutInMilliseconds);
    }
}