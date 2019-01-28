package com.epam.linkedin.mobile;

import com.epam.linkedin.mobile.steps.EditingAnAccountStepsMobile;
import com.epam.linkedin.mobile.steps.LoginStepsMobile;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class EditingAnAccountTest extends BaseTestMobile {

    private final static int STRING_LENGTH = 10;
    private EditingAnAccountStepsMobile editingAnAccountStepsMobile;
    private LoginStepsMobile loginStepsMobile;

    @Test(description = "[EPMFARMATS-5248]: Post a message")
    public void postAMessageTest() {
        editingAnAccountStepsMobile = new EditingAnAccountStepsMobile();
        loginStepsMobile = new LoginStepsMobile();
        loginStepsMobile.loginFromStartPage();
        loginStepsMobile.login(EMAIL, PASSWORD);
        editingAnAccountStepsMobile.postAMessage(RandomString.make(STRING_LENGTH));
        editingAnAccountStepsMobile.deleteMessage();
        editingAnAccountStepsMobile.isPostDeleted();
    }

    @Test(description = "[EPMFARMATS-5250]: Hide education place")
    public void hideEducationPlaceTest() {
        editingAnAccountStepsMobile = new EditingAnAccountStepsMobile();
        loginStepsMobile = new LoginStepsMobile();
        loginStepsMobile.loginFromStartPage();
        loginStepsMobile.login(EMAIL, PASSWORD);
        editingAnAccountStepsMobile.goToProfilePage();
        editingAnAccountStepsMobile.hideEducationPlace();
        editingAnAccountStepsMobile.isEducationPlaceHidden();
        editingAnAccountStepsMobile.revertChanges();
    }
}
