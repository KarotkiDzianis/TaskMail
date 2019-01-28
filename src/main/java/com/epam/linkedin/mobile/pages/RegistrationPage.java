package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.driver.DriverManagerMobile;
import com.epam.linkedin.utils.WaitUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

@Log4j2
public class RegistrationPage extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/growth_join_fragment_first_name")
    private MobileElement fieldFirstName;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_join_fragment_last_name")
    private MobileElement fieldLastName;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_join_fragment_email_address")
    private MobileElement fieldRegEmail;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_login_join_fragment_password")
    private MobileElement fieldRegPassword;

    @AndroidFindBy(id = "com.linkedin.android:id/growth_join_fragment_join")
    private MobileElement buttonApproveAndJoin;

    @AndroidFindBy(id = "android:id/content")
    private MobileElement frameAccounts;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private MobileElement anotherButton;

    @AndroidFindBy(id = "com.linkedin.android:id/action_bar_root")
    private MobileElement allPage;

    public void fieldFirstNameSendKeys() {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        int length = 4 + (int) (Math.random() * 12);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        fieldFirstName.clear();
        fieldFirstName.sendKeys(sb.toString());
        log.info("Enter First name: " + sb.toString());
    }

    public void fieldLastNameSendKeys() {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        fieldLastName.clear();
        int length = 4 + (int) (Math.random() * 12);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        fieldLastName.clear();
        fieldLastName.sendKeys(sb.toString());
        log.info("Enter Last name: " + sb.toString());
    }

    public void fieldEmailSendKeys() {
        fieldRegEmail.clear();
        String email = 10000001 + (int) (Math.random() * 99999999) + "@gmail.com";
        fieldRegEmail.sendKeys(email);
        log.info("Enter email: " + email);
    }

    public void fieldPasswordSendKeys() {
        fieldRegPassword.clear();
        String pass = "" + 10000001 + (int) (Math.random() * 99999999);
        fieldRegPassword.sendKeys(pass);
        log.info("Enter password: " + pass);
    }

    public void clickOnApproveAndJoinButton() {
        buttonApproveAndJoin.click();
        log.info("Click on 'Approve and join' button");
    }

    public boolean presenseOfWelcomeText() {
        WaitUtils.sleep(2000);
        boolean b = false;
        if (DriverManagerMobile.getDriver().getPageSource().contains("безопасности")) {
            b = true;
        } else if (DriverManagerMobile.getDriver().getPageSource().contains("пожаловать")) {
            b = true;
        } else if (DriverManagerMobile.getDriver().getPageSource().contains("выполняемой")) {
            b = true;
        }
        return b;
    }
}
