package com.epam.linkedin.api;

import com.epam.linkedin.webdriver.DriverManager;
import org.testng.annotations.BeforeMethod;

import static com.epam.linkedin.webdriver.DriverManager.EnvironmentType.LOCAL;

public abstract class BaseTestApi {

    protected final static String EMAIL = "linked.test11@gmail.com";
    protected final static String PASSWORD = "Begemot11";
    protected final static String KEY = "86y8p41r0ad0gt";
    protected final static String SECRET = "qPYPM8oLC5fCnllu";

    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver(LOCAL);
    }
}
