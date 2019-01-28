package com.epam.linkedin.mobile.steps;

import com.epam.linkedin.mobile.pages.RegistrationPage;
import com.epam.linkedin.mobile.pages.StartPageMobile;
import com.epam.linkedin.mobile.utils.ScrollUtils;

import static org.testng.Assert.assertTrue;

public class RegistrationStepsMobile {

    private StartPageMobile startPageMobile;
    private RegistrationPage registrationPage;

    public void registration() {
        startPageMobile = new StartPageMobile();
        startPageMobile.clickOnJoinNowButton();
        registrationPage = new RegistrationPage();
        ScrollUtils.swipeUp();
        registrationPage.fieldFirstNameSendKeys();
        registrationPage.fieldLastNameSendKeys();
        registrationPage.fieldEmailSendKeys();
        registrationPage.fieldPasswordSendKeys();
        registrationPage.clickOnApproveAndJoinButton();
    }

    public void presenceOfWelcomeText() {
        assertTrue(registrationPage.presenseOfWelcomeText(), "Registration was incorrect.");
    }
}
