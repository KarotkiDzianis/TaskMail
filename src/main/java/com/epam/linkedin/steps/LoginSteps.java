package com.epam.linkedin.steps;

import com.epam.linkedin.pages.EnterPasswordPage;
import com.epam.linkedin.pages.MailPage;
import com.epam.linkedin.pages.StartPage;

public class LoginSteps {

    private StartPage startPage;
    private EnterPasswordPage enterPasswordPage;
    private MailPage mailPage;

    public void login(String email, String password) throws InterruptedException {
        startPage = new StartPage();
        startPage.fieldEmailSendKeys(email);
        enterPasswordPage = new EnterPasswordPage();
        enterPasswordPage.fieldPasswordSendKeys(password);
    }

    public void createNewLabel(String name) {
        mailPage.createNewLabel(name);
    }

}
