package com.epam.linkedin.ui;

import com.epam.jira.JIRATestKey;
import com.epam.linkedin.steps.EditingAnAccountSteps;
import com.epam.linkedin.steps.LoginSteps;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.epam.jira.testng.ExecutionListener.class, com.epam.reportportal.testng.ReportPortalTestNGListener.class})
public class EditingAnAccountTest extends BaseTest {

    private final static String SKILL = "Java";
    private final static String LANGUAGE_RU = "ru_RU";
    private final static String LANGUAGE_EN = "en_US";
    private final static int STRING_LENGTH = 10;
    private EditingAnAccountSteps editingAnAccountSteps;
    private LoginSteps loginSteps;

    @JIRATestKey(key = "EPMFARMATS-5248")
    @Test(description = "[EPMFARMATS-5248]: Post a message")
    public void postAMessageTest() {
        loginSteps = new LoginSteps();
        editingAnAccountSteps = new EditingAnAccountSteps();
        loginSteps.login(EMAIL, PASSWORD);
        editingAnAccountSteps.postAMessage(RandomString.make(STRING_LENGTH));
        editingAnAccountSteps.deleteMessage();
        editingAnAccountSteps.isPostDeleted();
    }

    @JIRATestKey(key = "EPMFARMATS-5249")
    @Test(description = "[EPMFARMATS-5249]: Change language")
    public void changeLanguage() {
        loginSteps = new LoginSteps();
        editingAnAccountSteps = new EditingAnAccountSteps();
        loginSteps.login(EMAIL, PASSWORD);
        editingAnAccountSteps.goToSettingsPage();
        editingAnAccountSteps.changeLanguageTo(LANGUAGE_RU);
        editingAnAccountSteps.isPageLanguageChangedTo(LANGUAGE_RU);
        editingAnAccountSteps.changeLanguageTo(LANGUAGE_EN);
    }

    @JIRATestKey(key = "EPMFARMATS-5250")
    @Test(description = "[EPMFARMATS-5250]: Hide education place")
    public void hideEducationPlaceTest() {
        loginSteps = new LoginSteps();
        editingAnAccountSteps = new EditingAnAccountSteps();
        loginSteps.login(EMAIL, PASSWORD);
        editingAnAccountSteps.goToProfilePage();
        editingAnAccountSteps.hideEducationPlace();
        editingAnAccountSteps.isEducationPlaceHidden();
        editingAnAccountSteps.revertChanges();
    }

    @JIRATestKey(key = "EPMFARMATS-5251")
    @Test(description = "[EPMFARMATS-5251]: Add existing skill to profile")
    public void addExistingSkillToProfile() {
        loginSteps = new LoginSteps();
        editingAnAccountSteps = new EditingAnAccountSteps();
        loginSteps.login(EMAIL, PASSWORD);
        editingAnAccountSteps.goToProfilePage();
        editingAnAccountSteps.addANewSkill(SKILL);
        editingAnAccountSteps.isSkillMessageAppeared();
    }
}
