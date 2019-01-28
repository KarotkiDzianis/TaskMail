package com.epam.linkedin.mobile.steps;

import com.epam.linkedin.mobile.pages.ConversationPageMobile;
import com.epam.linkedin.mobile.pages.ConversationSearchPageMobile;
import com.epam.linkedin.mobile.pages.HomePageMobile;
import com.epam.linkedin.mobile.pages.MessagesPageMobile;

import static org.testng.Assert.assertTrue;

public class MessagingStepsMobile {

    private HomePageMobile homePageMobile;
    private MessagesPageMobile messagesPageMobile;
    private ConversationPageMobile conversationPageMobile;
    private ConversationSearchPageMobile conversationSearchPageMobile;

    public void clickIconMessages() {
        homePageMobile = new HomePageMobile();
        homePageMobile.clickOnIconMessages();
    }

    public void sendMessage(String name, String message) {
        selectColleagueConversation(name);
        conversationPageMobile = new ConversationPageMobile();
        conversationPageMobile.typeMessage(message);
        conversationPageMobile.buttonSendMessageClick();
    }

    public void goBackToHomePage() {
        conversationPageMobile = new ConversationPageMobile();
        conversationPageMobile.buttonBackClick();
        conversationSearchPageMobile = new ConversationSearchPageMobile();
        conversationSearchPageMobile.buttonBackClick();
        messagesPageMobile.clickOnIconHome();
    }

    public void selectColleagueConversation(String name) {
        messagesPageMobile = new MessagesPageMobile();
        messagesPageMobile.buttonSearchClick();
        conversationSearchPageMobile = new ConversationSearchPageMobile();
        conversationSearchPageMobile.fieldSearchConversationSendKeys(name);
        conversationSearchPageMobile.selectFirstNameFromDropdownList();
    }

    public void messageWasSentCorrect(String message) {
        conversationPageMobile = new ConversationPageMobile();
        assertTrue(conversationPageMobile.lastMessageGetText().contains(message), "Sending message was incorrect");
    }
}
