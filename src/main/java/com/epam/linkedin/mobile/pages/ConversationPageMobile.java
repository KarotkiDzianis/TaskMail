package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConversationPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/msglib_keyboard_text_input_container")
    private MobileElement fieldTypeMesage;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Назад\"]")
    private MobileElement buttonBack;

    @AndroidFindBy(id = "com.linkedin.android:id/messaging_envelope_keyboard_send_button")
    private MobileElement buttonSendMessage;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc=\"Список сообщений\"]/android.view.ViewGroup[9]/android.widget.TextView[2]")
    private MobileElement lastMessage;

    public void typeMessage(String message) {
        fieldTypeMesage.click();
        fieldTypeMesage.sendKeys(message);
        log.info("Enter message: " + message);
    }

    public void buttonSendMessageClick() {
        WaitUtilsMobile.waitForVisibility(buttonSendMessage);
        buttonSendMessage.click();
        log.info("Click on button \"Send message\"");
    }

    public void buttonBackClick() {
        buttonBack.click();
        log.info("Click on button \"Back\"");
    }

    public String lastMessageGetText() {
        WaitUtilsMobile.waitForVisibility(lastMessage);
        return lastMessage.getText();
    }
}
