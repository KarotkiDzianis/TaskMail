package com.epam.linkedin.mobile.steps;

import com.epam.linkedin.mobile.pages.HomePageMobile;
import com.epam.linkedin.mobile.pages.LoginPageMobile;
import com.epam.linkedin.mobile.pages.StartPageMobile;
import com.epam.linkedin.utils.WaitUtils;

public class LoginStepsMobile {

    private StartPageMobile startPageMobile;
    private LoginPageMobile loginPageMobile;
    private HomePageMobile homePageMobile;

    public void login(String email, String password) {
        loginPageMobile = new LoginPageMobile();
        loginPageMobile.fieldEmailSendKeys(email);
        loginPageMobile.fieldPasswordSendKeys(password);
        loginPageMobile.clickSubmitButton();
    }

    public boolean presenceOfIconMenuOnThePage() {
        homePageMobile = new HomePageMobile();
        WaitUtils.sleep(3);
        return homePageMobile.iconMenuIsDisplayed();
    }

    public void loginFromStartPage() {
        startPageMobile = new StartPageMobile();
        startPageMobile.linkSignInClick();
    }
}
