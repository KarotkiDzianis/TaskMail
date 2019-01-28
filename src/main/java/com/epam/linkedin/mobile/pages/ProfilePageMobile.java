package com.epam.linkedin.mobile.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProfilePageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/profile_toolbar_settings_button")
    private MobileElement iconSettings;

    @AndroidFindBy(id = "com.linkedin.android:id/profile_view_top_card_redesign_edit_btn")
    private MobileElement editProfileIcon;

    @AndroidFindBy(id = "com.linkedin.android:id/identity_profile_edit_checkbox")
    private MobileElement showEducationCheckbox;

    @AndroidFindBy(id = "com.linkedin.android:id/identity_profile_edit_spinner")
    private MobileElement educationPlace;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    private MobileElement crossButton;

    public void iconSettingsClick() {
        iconSettings.click();
        log.info("Click on 'Settings' button");
    }

    public void clickOnEditIcon() {
        editProfileIcon.click();
        log.info("Click on 'Edit Profile' button");
    }

    public void clickOnShowEducationCheckbox() {
        showEducationCheckbox.click();
        log.info("Click on 'Show education...' checkbox");
    }

    public boolean isPlaceHidden() {
        log.info("Check that place is hidden");
        return !educationPlace.isEnabled();
    }

    public void clickOnCrossButton() {
        log.info("Click on cross button");
        crossButton.click();
    }
}
