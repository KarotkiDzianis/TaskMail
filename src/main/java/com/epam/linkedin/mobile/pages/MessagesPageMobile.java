package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.utils.WaitUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessagesPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/conversation_search_image")
    private MobileElement buttonSearch;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Значок панели вкладок'])[1]")
    private MobileElement iconHome;

    public void buttonSearchClick() {
        WaitUtilsMobile.waitForVisibility(buttonSearch);
        buttonSearch.click();
        log.info("Click on button \"Search\"");
    }

    public void clickOnIconHome() {
        iconHome.click();
        log.info("Click on icon \"Home\"");
    }
}
