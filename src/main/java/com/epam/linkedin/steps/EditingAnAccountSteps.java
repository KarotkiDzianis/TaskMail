package com.epam.linkedin.steps;

import com.epam.linkedin.pages.HomePage;
import com.epam.linkedin.pages.ProfilePage;
import com.epam.linkedin.pages.SettingsPage;
import com.epam.linkedin.webdriver.DriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class EditingAnAccountSteps {

    private final static String SETTINGS_PAGE_URL = "https://www.linkedin.com/psettings/select-language";
    private final static String MAIN_PAGE_URL = "https://www.linkedin.com/";
    private HomePage homePage = new HomePage();
    private ProfilePage profilePage = new ProfilePage();
    private SettingsPage settingsPage = new SettingsPage();

    @When("^the user posts a \"([^\"]*)\" on the Home page$")
    public void postAMessage(String message) {
        homePage.clickOnShareField();
        homePage.enterMessageInTextField(message);
        homePage.clickOnPostButton();
    }

    @And("^the user deletes a message on the Home page$")
    public void deleteMessage() {
        homePage.clickOnThreeDots();
        homePage.clickOnDeletePostButton();
        homePage.confirmDeletion();
    }

    @Then("^the user sees a message that the post is deleted on the Home page$")
    public void isPostDeleted() {
        assertTrue(homePage.isPostDeletedMessageDisplayed());
    }

    @When("^the user goes to Profile page$")
    public void goToProfilePage() {
        homePage.clickOnMeButton();
        homePage.clickOnViewProfileButton();
    }

    @And("^the user hide his education place$")
    public void hideEducationPlace() {
        profilePage.clickOnEditIcon();
        profilePage.clickOnShowEducationCheckbox();
    }

    @Then("^the user revert changes back$")
    public void revertChanges() {
        profilePage.clickOnShowEducationCheckbox();
        profilePage.clickOnSaveButton();
    }

    @And("^the user sees that education place is hidden$")
    public void isEducationPlaceHidden() {
        assertTrue(profilePage.isPlaceHidden());
    }

    @And("^the user adds a \"([^\"]*)\" to his profile$")
    public void addANewSkill(String skill) {
        profilePage.clickOnAddANewSkillButton();
        profilePage.enterSkillToTheTextField(skill);
        profilePage.clickOnAddButton();
    }

    @Then("^the user sees a message that the skill have already added$")
    public void isSkillMessageAppeared() {
        assertTrue(profilePage.isSkillMessageAppeared());
    }

    @When("^the user goes to Settings Page$")
    public void goToSettingsPage() {
        DriverManager.getDriver().navigate().to(SETTINGS_PAGE_URL);
    }

    @Then("^the user goes to Main page$")
    public void goToMainPage() {
        DriverManager.getDriver().navigate().to(MAIN_PAGE_URL);
    }

    @And("^the user changes language to \"([^\"]*)\"$")
    public void changeLanguageTo(String language) {
        settingsPage.clickOnLanguagesList();
        settingsPage.chooseNeededLanguage(language);
    }

    @And("^the user sees that the page title is changed to \"([^\"]*)\"$")
    public void isPageLanguageChangedTo(String language) {
        assertTrue(settingsPage.getPageLanguage(language));
    }
}
