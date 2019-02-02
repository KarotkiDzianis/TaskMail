package com.epam.linkedin.steps;

import com.epam.linkedin.pages.EnterPasswordPage;
import com.epam.linkedin.pages.MailPage;
import com.epam.linkedin.pages.StartPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    private StartPage startPage = new StartPage();
    private EnterPasswordPage enterPasswordPage = new EnterPasswordPage();
    private MailPage mailPage = new MailPage();

    public void login(String email, String password) {
        startPage.fieldEmailSendKeys(email);
        enterPasswordPage.fieldPasswordSendKeys(password);
    }

    public void createNewLabel(String name) {
        mailPage.createNewLabel(name);
    }

    public void workWithMails(int i) {
        Map map = mailPage.makeListName();
        List list = mailPage.filterMapsbyValue(map);
        mailPage.checkBox(list, i);
    }

    public void checkAndMoveMessage() {
        mailPage.moveMessage();
    }


    public void deleteFolder() {
        mailPage.deleteLabel();
    }

}
