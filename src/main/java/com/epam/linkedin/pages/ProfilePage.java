package com.epam.linkedin.pages;

import com.epam.linkedin.utils.ActionsUtils;
import com.epam.linkedin.utils.ScrollUtils;
import com.epam.linkedin.utils.WaitUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*/a[contains(@id, 'ember')]//li-icon[@type='pencil-icon']")
    private WebElement editIcon;

    @FindBy(xpath = "//*[@class='label-text ']")
    private WebElement showEducationCheckbox;

    @FindBy(xpath = "//div/button[@type = 'submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[contains(@class, 'label--disabled')]")
    private WebElement educationPlace;

    @FindBy(xpath = "//*[@class = 'confirmation-modal__secondary-action-btn mr2 button-secondary-medium']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//*[@data-control-name = 'edit_skills_add']")
    private WebElement addANewSkillButton;

    @FindBy(xpath = "//input[@class = 'ember-text-field ember-view']")
    private WebElement skillTextField;

    @FindBy(xpath = "//button[@class='button-primary-medium ml2 fr ember-view']")
    private WebElement addButton;

    @FindBy(xpath = "//*[contains(@class, 'pv-add-with-suggestions__error')]")
    private WebElement skillMessage;

    @FindBy(xpath = "//button[@class='Sans-17px-black-70%']")
    private WebElement shareField;

    @FindBy(css = "div.mentions-texteditor__contenteditable")
    private WebElement shareTextField;

    @FindBy(className = "sharing-share-box__post-button-container")
    private WebElement postButton;

    @FindBy(css = "artdeco-dropdown-trigger > li-icon > svg > path")
    private WebElement threeDotsButton;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]")
    private WebElement deletePostButton;

    @FindBy(xpath = "//*[@class='feed-shared-decision-modal__confirm-button button-tertiary-large']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@class='feed-shared-hidden-update-v2 update Elevation-2dp mh0 p4 ember-view']")
    private WebElement postDeletedMessage;

    @FindBy(xpath = "//a[@href='/jobs/']")
    private WebElement linkJobs;

    @FindBy(xpath = "//button[@class='nav-item__link nav-panel__trigger ']")
    private WebElement linkWork;

    @FindBy(xpath = "//*[@id='create-company-nav-link']")
    private WebElement linkCreateACompanyPage;

    private WebElement pencilIcon;

    public void clickLinkJobs() {
        WaitUtils.sleep(5000);
        linkJobs.click();
        log.info("Click on link 'Jobs'");
    }

    public void openMenuWork() {
        WaitUtils.sleep(5000);
        linkWork.click();
        log.info("Click on menu 'Work'");
    }

    public void openCreateCompanyPage() {
        linkCreateACompanyPage.click();
        log.info("Click on link 'Create Company Page'");
    }

    public void clickOnEditIcon() {
        ActionsUtils.moveToElementAndClick(editIcon);
        log.info("Click on 'Edit'");
    }

    public void clickOnShowEducationCheckbox() {
        showEducationCheckbox.click();
        log.info("Click on 'Show Education'");
    }

    public void clickOnSaveButton() {
        saveButton.click();
        log.info("Click on 'Save'");
    }

    public boolean isPlaceHidden() {
        log.info("Education place is hidden");
        return educationPlace.isDisplayed();
    }

    public void clickOnAddANewSkillButton() {
        WaitUtils.sleep(5000);
        ScrollUtils.scrollToBottomOfAPage();
        addANewSkillButton.click();
        log.info("Click on 'Add a new skill'");
    }

    public void enterSkillToTheTextField(String skill) {
        skillTextField.sendKeys(skill);
        log.info("Enter skill: " + skill);
    }

    public void clickOnAddButton() {
        addButton.click();
        log.info("Click on 'Add'");
    }

    public boolean isSkillMessageAppeared() {
        log.info("Message 'Skill have already added' is displayed");
        return skillMessage.isDisplayed();
    }
}
