package com.epam.linkedin.steps;

import com.epam.linkedin.pages.EnterPasswordPage;
import com.epam.linkedin.pages.StartPage;

public class LoginSteps {

    private StartPage startPage;
    private EnterPasswordPage enterPasswordPage;

    public void login(String email, String password) {
        startPage = new StartPage();
        startPage.fieldEmailSendKeys(email);
        enterPasswordPage = new EnterPasswordPage();
        enterPasswordPage.fieldPasswordSendKeys(password);

    }


}
