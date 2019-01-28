package com.epam.linkedin.mobile;

import com.epam.linkedin.mobile.steps.LoginStepsMobile;
import com.epam.linkedin.mobile.steps.LogoutStepsMobile;
import com.epam.linkedin.mobile.steps.MessagingStepsMobile;
import org.testng.annotations.Test;

public class MessagingMobileTest extends BaseTestMobile {

    private final static String EMAIL_TI = "tatigna11@gmail.com";
    private final static String PASSWORD_TI = "Begemot11";
    private final static String NAME = "Tatiana";
    private final static String MESSAGE = "How are you?";
    private final static String COLLEAGUE_NAME = "Linked";
    private LoginStepsMobile loginStepsMobile;
    private MessagingStepsMobile messagingStepsMobile;
    private LogoutStepsMobile logoutStepsMobile;

    @Test(description = "[EPMFARMATS-5258]: Sending MESSAGE to another user")
    public void messagingTest() {
        loginStepsMobile = new LoginStepsMobile();
        logoutStepsMobile = new LogoutStepsMobile();
        messagingStepsMobile = new MessagingStepsMobile();
        loginStepsMobile.loginFromStartPage();
        loginStepsMobile.login(EMAIL, PASSWORD);
        messagingStepsMobile.clickIconMessages();
        messagingStepsMobile.sendMessage(NAME, MESSAGE);
        messagingStepsMobile.goBackToHomePage();
        logoutStepsMobile.logout();
        loginStepsMobile.login(EMAIL_TI, PASSWORD_TI);
        messagingStepsMobile.clickIconMessages();
        messagingStepsMobile.selectColleagueConversation(COLLEAGUE_NAME);
        messagingStepsMobile.messageWasSentCorrect(MESSAGE);
    }
}
