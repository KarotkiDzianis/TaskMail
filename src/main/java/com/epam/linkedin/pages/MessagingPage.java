package com.epam.linkedin.pages;

import com.epam.linkedin.utils.ScrollUtils;
import com.epam.linkedin.utils.WaitUtils;
import com.epam.linkedin.webdriver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class MessagingPage extends BasePage {

    private String firstName = "//*[contains(@id, 'suggestions-menu')]/li[1]";
    private String conversationNamesXpath = "//div[2]/div[1]/h3";
    private String messagingPageLogoutXpath = "//*[contains(@class, 'msg-modal__button button-primary-large')]";
    private String iconPopUpCancelXpath = "//button[contains(., 'Got it')]";

    @FindBy(xpath = "//input[contains(@id, 'search-field')]")
    private WebElement fieldNames;

    @FindBy(xpath = "//*[contains(@title, 'Compose a new message')]/span/li-icon")
    private WebElement iconNewMessage;

    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    private WebElement signOut;

    @FindBy(xpath = "//*[@id='messaging']/div/div/div[2]")
    private WebElement messagingWindow;

    @FindBy(xpath = "//div[contains(@id, 'ember')]/button[@class='msg-form__send-button button-primary-small']")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//*[@id='nav-settings__dropdown-trigger']")
    private WebElement meButton;

    @FindBy(css = "div.msg-form__contenteditable.t-14.t-black--light.t-normal.flex-grow-1")
    private WebElement inputField;

    @FindBy(xpath = "//*")
    private WebElement allPage;

    public MessagingPage() {
        super();
    }

    public void typeName(String name) {
        fieldNames.clear();
        fieldNames.sendKeys(name);
        log.info("Type name: " + name);
    }

    public void clickIconNewMessage() {
        WaitUtils.waitUntilPageIsLoaded();
        WaitUtils.waitForVisibility(iconNewMessage);
        iconNewMessage.click();
        log.info("Click on 'New message'");
    }

    public void selectFirstNameFromDropdownList() {
        WaitUtils.waitForVisibility(DriverManager.getDriver().findElement(By.xpath(firstName)));
        DriverManager.getDriver().findElement(By.xpath(firstName)).click();
        log.info("Select first name from the dropdown list");
    }

    public void signOutClick() {
        WaitUtils.waitForVisibility(signOut, 3000);
        signOut.click();
        log.info("Click on 'Sign Out'");
    }

    public void clickOnMeButton() {
        meButton.click();
        log.info("Click on 'Me'");
    }

    public List<WebElement> getColleagueNames() {
        List<WebElement> conversationNames = DriverManager.getDriver().findElements(By.xpath(conversationNamesXpath));
        log.info("Get colleague names");
        return conversationNames;
    }

    public String messagingWindowGetText() {
        log.info("Get text from messaging window");
        return messagingWindow.getText();
    }

    public void sendMessageButtonClick() {
        WaitUtils.waitForVisibility(sendMessageButton, 3000);
        sendMessageButton.click();
        log.info("Click on 'Send message'");
    }

    public void typeMessage(String message) {
        ScrollUtils.scrollToBottomOfAPage();
        inputField.sendKeys(message);
        log.info("Type message: " + message);
    }

    public void messagingPageLogout() {
        WaitUtils.sleep(3);
        if (allPage.getText().contains("Yes, leave")) {
            DriverManager.getDriver().findElement(By.xpath(messagingPageLogoutXpath)).click();
        }
        log.info("Click on 'Cancel'");
    }
}
