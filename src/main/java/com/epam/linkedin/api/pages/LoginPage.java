package com.epam.linkedin.api.pages;

import com.epam.linkedin.pages.BasePage;
import com.epam.linkedin.utils.WaitUtils;
import com.epam.linkedin.webdriver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='session_key']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement allowButton;

    public String deliverVerifierCode(String url, String login, String password) {
        DriverManager.getDriver().get(url);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        allowButton.click();
        log.info("The user is logged in");
        WaitUtils.sleep(1000);
        return DriverManager.getDriver().getCurrentUrl();
    }
}
