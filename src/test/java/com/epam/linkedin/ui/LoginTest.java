package com.epam.linkedin.ui;

import com.epam.jira.JIRATestKey;
import com.epam.linkedin.steps.LoginSteps;
import com.epam.linkedin.steps.LogoutSteps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.epam.jira.testng.ExecutionListener.class, com.epam.reportportal.testng.ReportPortalTestNGListener.class})
public class LoginTest extends BaseTest {

    private LoginSteps loginSteps;
    private LogoutSteps logoutSteps;

    @JIRATestKey(key = "EPMFARMATS-5254")
    @Test(description = "[EPMFARMATS-5254]: Log in with existing account")
    public void loginTest() {
        loginSteps = new LoginSteps();
        loginSteps.login(EMAIL, PASSWORD);
        loginSteps.isLoginProcessCorrect("Share an article, photo, video or idea");
    }

    @JIRATestKey(key = "EPMFARMATS-5255")
    @Test(description = "[EPMFARMATS-5255]: Log out from account")
    public void logoutTest() {
        loginSteps = new LoginSteps();
        logoutSteps = new LogoutSteps();
        loginSteps.login(EMAIL, PASSWORD);
        logoutSteps.logout();
        logoutSteps.isLogoutProcessCorrect("Be great at what you do");
    }
}
