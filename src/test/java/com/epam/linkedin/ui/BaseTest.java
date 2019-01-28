package com.epam.linkedin.ui;

import com.epam.linkedin.properties.UrlsStorage;
import com.epam.linkedin.webdriver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.epam.linkedin.webdriver.DriverManager.EnvironmentType.LOCAL;

public abstract class BaseTest {

    protected final static String EMAIL = "linked.test11@gmail.com";
    protected final static String PASSWORD = "Begemot11";

    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver(LOCAL);
        DriverManager.getDriver().get(UrlsStorage.getMainPageUrl());
    }

    @AfterMethod
    public void closeDriver() {
        DriverManager.quitDriver();
    }
}
