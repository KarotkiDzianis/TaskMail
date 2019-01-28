package com.epam.linkedin.mobile;

import com.epam.linkedin.mobile.driver.DriverManagerMobile;
import org.testng.annotations.BeforeMethod;

public class BaseTestMobile {

    protected final static String EMAIL = "linked.test11@gmail.com";
    protected final static String PASSWORD = "Begemot11";

    @BeforeMethod
    public void setupDriver() {
        DriverManagerMobile.setDriver();
    }
}