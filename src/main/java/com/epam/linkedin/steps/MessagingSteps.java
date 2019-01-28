package com.epam.linkedin.steps;

import com.epam.linkedin.pages.HomePage;
import com.epam.linkedin.pages.MessagingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class MessagingSteps {

    private HomePage homePage;
    private MessagingPage messagingPage;

    @And("^the user types name \"([^\"]*)\", selects colleague from list and sends message \"([^\"]*)\"$")
    public void sendMessage(String name, String message) {
        messagingPage = new MessagingPage();
        messagingPage.clickIconNewMessage();
        messagingPage.typeName(name);
        messagingPage.selectFirstNameFromDropdownList();
        messagingPage.typeMessage(message);
        messagingPage.sendMessageButtonClick();
    }

    @When("^clicks icon \"Messaging\"$")
    public void clickIconMessages() {
        homePage = new HomePage();
        homePage.clickIconMessages();
    }

    @When("^logs out from account$")
    public void signOut() {
        messagingPage.clickOnMeButton();
        messagingPage.signOutClick();
        messagingPage.messagingPageLogout();
    }

    @And("^the user selects colleague name \"([^\"]*)\" from list$")
    public void selectColleagueName(String name) {
        messagingPage = new MessagingPage();
        for (WebElement colleagueName : messagingPage.getColleagueNames()) {
            if (colleagueName.getText().contains(name)) {
                colleagueName.click();
            }
        }
    }

    @Then("^check of message text \"([^\"]*)\" is presented on the page$")
    public void messageWasSentCorrect(String message) {
        assertTrue(messagingPage.messagingWindowGetText().contains(message), "Message was sent incorrect.");
    }
}
