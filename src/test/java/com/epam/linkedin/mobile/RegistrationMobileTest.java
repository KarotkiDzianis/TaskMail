package com.epam.linkedin.mobile;

import com.epam.linkedin.mobile.steps.RegistrationStepsMobile;
import org.testng.annotations.Test;

public class RegistrationMobileTest extends BaseTestMobile {

    private RegistrationStepsMobile registrationStepsMobile;

    @Test(description = "[EPMFARMATS-5257]: Registration new account")
    public void registrationTest() {
        registrationStepsMobile = new RegistrationStepsMobile();
        registrationStepsMobile.registration();
        registrationStepsMobile.presenceOfWelcomeText();
    }
}
