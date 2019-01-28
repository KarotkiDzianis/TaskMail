package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.driver.DriverManagerMobile;
import com.epam.linkedin.utils.WaitUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePageMobile {

    protected WebDriver driver;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private MobileElement anotherButton;

    public BasePageMobile() {
        this.driver = DriverManagerMobile.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(DriverManagerMobile.getDriver(), Duration.ofSeconds(20)), this);
        WaitUtils.sleep(2000);
        if (DriverManagerMobile.getDriver().getPageSource().contains("Выберите аккаунт") ||
                DriverManagerMobile.getDriver().getPageSource().contains("Google Smart Lock")) {
            if (DriverManagerMobile.getDriver().getPageSource().contains("Google")) {
                anotherButton.click();
            }
        }
    }
}
