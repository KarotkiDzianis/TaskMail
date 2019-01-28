package com.epam.linkedin.pages;

import com.epam.linkedin.utils.WaitUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='messaging-nav-item']/a")
    private WebElement iconMessages;

    @FindBy(xpath = "//button[@class='t-16 t-black--light t-normal']")
    private WebElement shareField;

    @FindBy(css = "div.mentions-texteditor__contenteditable")
    private WebElement shareTextField;

    @FindBy(className = "sharing-share-box__post-button-container")
    private WebElement postButton;

    @FindBy(xpath = "//li-icon[@aria-label='Open control menu']")
    private WebElement threeDotsButton;

    @FindBy(xpath = "//*[@class='option-delete']")
    private WebElement deletePostButton;

    @FindBy(xpath = "//*[@class='feed-shared-decision-modal__confirm-button button-tertiary-large']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@class='feed-shared-hidden-update-v2 update Elevation-2dp mh0 p4 ember-view']")
    private WebElement postDeletedMessage;

    @FindBy(xpath = "//*[@id='nav-settings__dropdown-trigger']")
    private WebElement meButton;

    @FindBy(xpath = "//*[@class='nav-settings__linkcard-link button-tertiary-medium']")
    private WebElement viewProfileButton;

    @FindBy(xpath = "//*[@data-control-name='nav.settings_account_manage_account']")
    private WebElement settingsButton;

    @FindBy(xpath = "//*")
    private WebElement allPage;

    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    private WebElement signOut;

    public HomePage() {
        super();
    }

    public void clickOnShareField() {
        shareField.click();
        log.info("Click on 'Share an...' field");
    }

    public void enterMessageInTextField(String message) {
        shareTextField.sendKeys(message);
        log.info("Enter message: " + message);
    }

    public void clickOnPostButton() {
        postButton.click();
        log.info("Click on 'Post' button");
    }

    public void clickOnThreeDots() {
        WaitUtils.sleep(5000);
        threeDotsButton.click();
        log.info("Click on three dots button");
    }

    public void clickOnDeletePostButton() {
        deletePostButton.click();
        log.info("Click on 'Delete' button");
    }

    public void confirmDeletion() {
        deleteButton.click();
        log.info("Confirm deletion");
    }

    public boolean isPostDeletedMessageDisplayed() {
        log.info("Post is deleted");
        return postDeletedMessage.isDisplayed();
    }

    public void clickOnMeButton() {
        meButton.click();
        log.info("Click on 'Me'");
    }

    public void clickOnViewProfileButton() {
        viewProfileButton.click();
        log.info("Click on 'View Profile'");
    }

    public String allPageGetText() {
        log.info("Get whole page text");
        return allPage.getText();
    }

    public void signOutClick() {
        log.info("Sign out");
        signOut.click();
    }

    public void clickIconMessages() {
        log.info("Click on 'Messages'");
        iconMessages.click();
    }
}
