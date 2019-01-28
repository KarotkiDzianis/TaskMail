package com.epam.linkedin.mobile.utils;

import com.epam.linkedin.mobile.driver.DriverManagerMobile;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriverException;

@Log4j2
public class KeyboardUtilsMobile {

    /**
     * Use this method to hide keyboard
     */
    @SneakyThrows(WebDriverException.class)
    public static void hideKeyboard() {
        DriverManagerMobile.getDriver().hideKeyboard();
    }

    /**
     * Use this method for navigate to back.
     */
    public static void clickBackButton() {
        DriverManagerMobile.getDriver().navigate().back();
    }
}