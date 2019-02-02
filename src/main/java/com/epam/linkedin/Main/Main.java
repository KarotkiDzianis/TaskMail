package com.epam.linkedin.Main;

import com.epam.linkedin.steps.LoginSteps;
import com.epam.linkedin.webdriver.DriverManager;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Main {

    protected final static String EMAIL = "linked.test11@gmail.com";
    protected final static String PASSWORD = "Begemot11";
    private final static String BASE_URL = "http://gmail.com/";
    public final static String NAME_LABEL = "TOP5";
    public final static Integer NUMBER_MESSAGE_FOR_TRANSFER = 2;


    public static void main(String[] args) {
        log.debug("Create driver");
        DriverManager.getDriver().get(BASE_URL);
        log.info("Open URL: " + BASE_URL);
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(EMAIL, PASSWORD);
        loginSteps.workWithMails(NUMBER_MESSAGE_FOR_TRANSFER);
        loginSteps.createNewLabel(NAME_LABEL);
        loginSteps.checkAndMoveMessage();
        loginSteps.deleteFolder();
        DriverManager.closeDriver();
        log.debug("Close driver");
    }
}
