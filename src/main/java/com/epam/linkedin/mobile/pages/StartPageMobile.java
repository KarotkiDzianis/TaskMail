package com.epam.linkedin.mobile.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StartPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/growth_prereg_fragment_join_button_secondary")
    private MobileElement joinNowButton;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_fragment_join")
    private MobileElement joinButton;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private MobileElement anotherButton;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_prereg_fragment_account_exists")
    private MobileElement signIn;

    public void clickOnJoinNowButton() {
        if (joinNowButton.isDisplayed()) {
            joinNowButton.click();
        } else if (joinButton.isDisplayed()) {
            joinButton.click();
        }
        log.info("Click on 'Join' button");
    }

    public void linkSignInClick() {
        signIn.click();
        log.info("Click on 'Sign In' link");
    }
}

