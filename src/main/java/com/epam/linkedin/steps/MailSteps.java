package com.epam.linkedin.steps;


import com.epam.linkedin.pages.MailPage;

import java.util.List;
import java.util.Map;

public class MailSteps{

    private MailPage mailPage = new MailPage();

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
