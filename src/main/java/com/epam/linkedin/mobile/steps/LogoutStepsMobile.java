package com.epam.linkedin.mobile.steps;

import com.epam.linkedin.mobile.pages.HomePageMobile;
import com.epam.linkedin.mobile.pages.LoginPageMobile;
import com.epam.linkedin.mobile.pages.ProfilePageMobile;
import com.epam.linkedin.mobile.pages.SettingsPageMobile;

public class LogoutStepsMobile {

    private HomePageMobile homePageMobile;
    private LoginPageMobile loginPageMobile;
    private ProfilePageMobile profilePageMobile;
    private SettingsPageMobile settingsPageMobile;

    public void logout() {
        homePageMobile = new HomePageMobile();
        homePageMobile.iconProfileClick();
        profilePageMobile = new ProfilePageMobile();
        profilePageMobile.iconSettingsClick();
        settingsPageMobile = new SettingsPageMobile();
        settingsPageMobile.exitClick();
    }

    public boolean presenseTextForgotPasswordOnThePage() {
        loginPageMobile = new LoginPageMobile();
        return loginPageMobile.forgotPasswordGetText().contains("Забыли пароль?");
    }
}
