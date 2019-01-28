package com.epam.linkedin.mobile;

import com.epam.linkedin.mobile.steps.LoginStepsMobile;
import com.epam.linkedin.mobile.steps.LogoutStepsMobile;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginMobileTest extends BaseTestMobile {

    private LoginStepsMobile loginStepsMobile;
    private LogoutStepsMobile logoutStepsMobile;

    @Test(description = "[EPMFARMATS-5254]: Log in with existing account")
    public void loginTest() {
        loginStepsMobile = new LoginStepsMobile();
        loginStepsMobile.loginFromStartPage();
        loginStepsMobile.login(EMAIL, PASSWORD);
        assertTrue(loginStepsMobile.presenceOfIconMenuOnThePage(), "Logout was incorrect.");
    }

    @Test(description = "[EPMFARMATS-5255]: Log out from account")
    public void logoutTest() {
        loginStepsMobile = new LoginStepsMobile();
        loginStepsMobile.loginFromStartPage();
        loginStepsMobile.login(EMAIL, PASSWORD);
        logoutStepsMobile = new LogoutStepsMobile();
        logoutStepsMobile.logout();
        assertTrue(logoutStepsMobile.presenseTextForgotPasswordOnThePage(), "Logout was incorrect.");
    }
}
