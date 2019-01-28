package com.epam.linkedin.steps;

import com.epam.linkedin.pages.HomePage;
import com.epam.linkedin.pages.StartPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class LogoutSteps {

    private StartPage startPage;
    private HomePage homePage;

    @When("^the user logs out from account$")
    public void logout() {
        homePage = new HomePage();
        homePage.clickOnMeButton();
        homePage.signOutClick();
    }

    @Then("^after log out text \"([^\"]*)\" is present on the page$")
    public void isLogoutProcessCorrect(String s) {
        startPage = new StartPage();
        assertTrue(startPage.getText().contains(s), "Sign out process is incorrect.");
    }
}
