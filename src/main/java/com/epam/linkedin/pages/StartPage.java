package com.epam.linkedin.pages;

import com.epam.linkedin.utils.WaitUtils;
import com.epam.linkedin.webdriver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

@Log4j2
public class StartPage extends BasePage {

    private String frameElements = "//*[@id='pagekey-uno-reg-checkpoint-standalone']";
    private String frameXpath = "//*[@id='captcha-dialog']/iframe";

    @FindBy(xpath = "//form[@class='login-form']/input[@id=\"login-email\"]")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement fieldLPass;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement buttonLoginSubmit;

    @FindBy(xpath = "//*[@id='reg-firstname']")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//*[@id='reg-lastname']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//*[@id='reg-email']")
    private WebElement fieldRegEmail;

    @FindBy(xpath = "//*[@id='reg-password']")
    private WebElement fieldRegPassword;

    @FindBy(xpath = "//*[@id='registration-submit']")
    private WebElement buttonRegistSubmit;

    @FindBy(xpath = "//*")
    private WebElement allPage;

    public StartPage() {
        super();
    }

    public void fieldEmailSendKeys(String email) {
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        log.info("Enter email: " + email);
    }

    public void fieldPasswordSendKeys(String pass) {
        WaitUtils.waitForVisibility(buttonLoginSubmit, 5);
        fieldLPass.clear();
        fieldLPass.sendKeys(pass);
        log.info("Enter password: " + pass);
    }

    public void buttonLoginSubmitClick() {
        WaitUtils.waitForVisibility(buttonLoginSubmit, 5);
        buttonLoginSubmit.click();
        log.info("Click on 'Submit login' button");
    }

    public void fieldFirstNameSendKeys() {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        fieldFirstName.clear();
        int length = 4 + (int) (Math.random() * 12);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
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
        fieldLastName.sendKeys(sb.toString());
        log.info("Enter Last name: " + sb.toString());
    }

    public void fieldRegEmailSendKeys() {
        fieldRegEmail.clear();
        String email = 10000001 + (int) (Math.random() * 99999999) + "@gmail.com";
        fieldRegEmail.sendKeys(email);
        log.info("Enter email: " + email);
    }

    public void fieldRegPasswordSendKeys() {
        fieldRegPassword.clear();
        String pass = "" + 10000001 + (int) (Math.random() * 99999999);
        fieldRegPassword.sendKeys(pass);
        log.info("Enter password: " + pass);
    }

    public void buttonRegistSubmitClick() {
        buttonRegistSubmit.click();
        log.info("Click on 'Submit registration' button");
    }

    public String getText() {
        log.info("Get whole page text");
        return allPage.getText();
    }

    public void switchToFrame() {
        WaitUtils.sleep(5);
        DriverManager.getDriver().switchTo().frame(DriverManager.getDriver().findElement(By.xpath(frameXpath)));
        log.info("Switch to frame");
    }

    public String frameElementsGetText() {
        WaitUtils.sleep(3000);
        log.info("Get text from frame elements");
        return DriverManager.getDriver().findElement(By.xpath(frameElements)).getText();
    }
}
