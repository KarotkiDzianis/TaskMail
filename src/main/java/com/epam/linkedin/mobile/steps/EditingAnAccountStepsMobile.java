package com.epam.linkedin.mobile.steps;

import com.epam.linkedin.mobile.pages.HomePageMobile;
import com.epam.linkedin.mobile.pages.ProfilePageMobile;

import static org.testng.Assert.assertTrue;

public class EditingAnAccountStepsMobile {

    private HomePageMobile homePageMobile;
    private ProfilePageMobile profilePageMobile;

    public void postAMessage(String message) {
        homePageMobile = new HomePageMobile();
        homePageMobile.clickOnPostIcon();
        homePageMobile.enterMessageInTextField(message);
        homePageMobile.clickOnPostButton();
    }

    public void deleteMessage() {
        homePageMobile = new HomePageMobile();
        homePageMobile.scrollDown();
        homePageMobile.clickOnArrowButton();
        homePageMobile.clickOnDeletePostButton();
        homePageMobile.confirmDeletion();
    }

    public void isPostDeleted() {
        homePageMobile = new HomePageMobile();
        assertTrue(homePageMobile.isPostDisappeared());
    }

    public void goToProfilePage() {
        homePageMobile = new HomePageMobile();
        homePageMobile.iconProfileClick();
    }

    public void hideEducationPlace() {
        profilePageMobile = new ProfilePageMobile();
        profilePageMobile.clickOnEditIcon();
        profilePageMobile.clickOnShowEducationCheckbox();
    }

    public void isEducationPlaceHidden() {
        profilePageMobile = new ProfilePageMobile();
        assertTrue(profilePageMobile.isPlaceHidden());
    }

    public void revertChanges() {
        profilePageMobile = new ProfilePageMobile();
        profilePageMobile.clickOnShowEducationCheckbox();
        profilePageMobile.clickOnCrossButton();
    }
}
