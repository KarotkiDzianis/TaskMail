package com.epam.linkedin.steps;

import com.epam.linkedin.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;

public class RegistrationSteps {

    private StartPage startPage;

    @Given("^the user goes to start page and types data into fields$")
    public void registration() {
        startPage = new StartPage();
        startPage.fieldFirstNameSendKeys();
        startPage.fieldLastNameSendKeys();
        startPage.fieldRegEmailSendKeys();
        startPage.fieldRegPasswordSendKeys();
        startPage.buttonRegistSubmitClick();
    }

    @Then("^checks presence pop-up and text \"([^\"]*)\"$")
    public void presenceTextInPopUp(String s) {
        startPage.switchToFrame();
        assertTrue(startPage.frameElementsGetText().contains(s), "Registration process was incorrect.");
    }
}
