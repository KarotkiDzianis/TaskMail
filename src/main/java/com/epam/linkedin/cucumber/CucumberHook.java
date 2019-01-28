package com.epam.linkedin.cucumber;

import com.epam.linkedin.webdriver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.epam.linkedin.webdriver.DriverManager.EnvironmentType.GRID;

public class CucumberHook {

    private final static String MAIN_PAGE_URL = "https://www.linkedin.com/";

    @Before
    public void setUp() {
        DriverManager.setDriver(GRID);
        DriverManager.getDriver().navigate().to(MAIN_PAGE_URL);
    }

    @After
    public void quit() {
        DriverManager.quitDriver();
    }
}
