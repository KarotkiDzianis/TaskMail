package com.epam.linkedin.ui;

import com.epam.jira.JIRATestKey;
import com.epam.linkedin.steps.LoginSteps;
import com.epam.linkedin.steps.MessagingSteps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.epam.jira.testng.ExecutionListener.class, com.epam.reportportal.testng.ReportPortalTestNGListener.class})
public class MessagingTest extends BaseTest {

    private final static String EMAIL_TI = "tatigna11@gmail.com";
    private final static String PASSWORD_TI = "Begemot11";
    private final static String NAME = "Tatiana";
    private final static String MESSAGE = "How are you?";
    private final static String COLLEAGUE_NAME = "Linked";
    private LoginSteps loginSteps;
    private MessagingSteps messagingSteps;

    @JIRATestKey(key = "EPMFARMATS-5258")
    @Test(description = "[EPMFARMATS-5258]: Sending MESSAGE to another user")
    public void messagingTest() {
        loginSteps = new LoginSteps();
        messagingSteps = new MessagingSteps();
        loginSteps.login(EMAIL, PASSWORD);
        messagingSteps.clickIconMessages();
        messagingSteps.sendMessage(NAME, MESSAGE);
        messagingSteps.signOut();
        loginSteps.login(EMAIL_TI, PASSWORD_TI);
        messagingSteps.clickIconMessages();
        messagingSteps.selectColleagueName(COLLEAGUE_NAME);
        messagingSteps.messageWasSentCorrect(MESSAGE);
    }
}
