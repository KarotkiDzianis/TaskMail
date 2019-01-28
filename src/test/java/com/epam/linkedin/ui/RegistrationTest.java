package com.epam.linkedin.ui;

import com.epam.jira.JIRATestKey;
import com.epam.linkedin.steps.RegistrationSteps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.epam.jira.testng.ExecutionListener.class, com.epam.reportportal.testng.ReportPortalTestNGListener.class})
public class RegistrationTest extends BaseTest {

    private final String CHECK = "Just a quick security check";
    private RegistrationSteps registrationSteps;

    @JIRATestKey(key = "EPMFARMATS-5257")
    @Test(description = "[EPMFARMATS-5257]: Registration new account")
    public void registrationTest() {
        registrationSteps = new RegistrationSteps();
        registrationSteps.registration();
        registrationSteps.presenceTextInPopUp(CHECK);
    }
}