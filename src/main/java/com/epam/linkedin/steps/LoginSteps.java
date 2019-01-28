package com.epam.linkedin.steps;

import com.epam.linkedin.pages.HomePage;
import com.epam.linkedin.pages.StartPage;
import com.epam.linkedin.utils.WaitUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private StartPage startPage;
    private HomePage homePage;

    @Given("^the user logs in to LinkedIn with login \"([^\"]*)\" and password \"([^\"]*)\" on Start page$")
    public void login(String email, String password) {
        startPage = new StartPage();
        startPage.fieldEmailSendKeys(email);
        startPage.fieldPasswordSendKeys(password);
        startPage.buttonLoginSubmitClick();
    }

    @Then("^after log in text \"([^\"]*)\" is present on the page$")
    public void isLoginProcessCorrect(String s) {
        homePage = new HomePage();
        WaitUtils.sleep(3);
        assertTrue(this.homePage.allPageGetText().contains(s), "Sign in process is incorrect.");
    }
}
