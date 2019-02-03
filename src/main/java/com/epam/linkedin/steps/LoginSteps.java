package com.epam.linkedin.steps;

import com.epam.linkedin.pages.EnterPasswordPage;
import com.epam.linkedin.pages.MailPage;
import com.epam.linkedin.pages.StartPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    private StartPage startPage = new StartPage();
    private EnterPasswordPage enterPasswordPage = new EnterPasswordPage();

    public void login(String email, String password) {
        startPage.fieldEmailSendKeys(email);
        enterPasswordPage.fieldPasswordSendKeys(password);
    }

}
