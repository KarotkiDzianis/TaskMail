package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConversationSearchPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/messaging_conversation_search_list_toolbar_edit_text")
    private MobileElement fieldSearchConversation;

    @AndroidFindBy(id = "com.linkedin.android:id/messaging_conversation_list_item_container")
    private MobileElement colleagueName;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Назад']")
    private MobileElement buttonBack;

    public void fieldSearchConversationSendKeys(String name) {
        fieldSearchConversation.clear();
        fieldSearchConversation.sendKeys(name);
        log.info("Enter name for search: " + name);
    }

    public void selectFirstNameFromDropdownList() {
        WaitUtilsMobile.waitForVisibility(colleagueName);
        colleagueName.click();
        log.info("Select first name from the dropdown list");
    }

    public void buttonBackClick() {
        buttonBack.click();
        log.info("Click on button \"Back\"");
    }
}
