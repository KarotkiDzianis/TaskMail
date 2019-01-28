package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.driver.DriverManagerMobile;
import com.epam.linkedin.utils.WaitUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_join_fragment_email_address")
    private MobileElement fieldEmail;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_join_fragment_password")
    private MobileElement fieldPassword;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_fragment_sign_in")
    private MobileElement buttonSubmit;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private MobileElement anotherButton;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_fragment_forgot_password")
    private MobileElement forgotPassword;

    public void fieldEmailSendKeys(String email) {
        WaitUtils.sleep(3000);
        if (DriverManagerMobile.getDriver().getPageSource().contains("Выберите аккаунт") |
                DriverManagerMobile.getDriver().getPageSource().contains("Choose an account") |
                DriverManagerMobile.getDriver().getPageSource().contains("Continue with")) {
            anotherButton.click();
        }
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        log.info("Enter Email: " + email);
    }

    public void fieldPasswordSendKeys(String password) {
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        log.info("Enter Password: " + password);
    }

    public void clickSubmitButton() {
        buttonSubmit.click();
        log.info("Click on 'Submit' button");
    }

    public String forgotPasswordGetText() {
        return forgotPassword.getText();
    }
}
