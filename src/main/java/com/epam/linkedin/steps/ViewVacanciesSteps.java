package com.epam.linkedin.steps;

import com.epam.linkedin.pages.JobsPage;
import com.epam.linkedin.pages.JobsSearchPage;
import com.epam.linkedin.pages.ProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ViewVacanciesSteps {

    private ProfilePage profilePage = new ProfilePage();
    private JobsPage jobsPage = new JobsPage();
    private JobsSearchPage jobsSearchPage = new JobsSearchPage();

    @When("^the user open JobsPage$")
    public void openJobs() {
        profilePage.clickLinkJobs();
    }

    @And("^the user fill form 'Search jobs' random value$")
    public void enterDataSearchJobs(String mes) {
        jobsPage.fillFormSearchJobs(mes);
    }

    @And("^the user fill form 'Search jobs' \"([^\"]*)\"$")
    public void theUserFillFormSearchJobs(String arg0) {
        jobsPage.fillFormSearchJobs(arg0);
    }

    @And("^the user fill form 'Search location' \"([^\"]*)\"$")
    public void enterDataSearchLocation(String mes) {
        jobsPage.fillFormSearchLocation(mes);
    }

    @And("^the user push the button 'Search'$")
    public void pushButtonSearch() {
        jobsPage.clickButtonsearch();
    }

    public Integer getJobsCount() {
        return jobsSearchPage.counterViewJobs();
    }

    public String getJobsText() {
        return jobsSearchPage.getTextAboutJobs();
    }

    public boolean findJobs() {
        if (getJobsCount() > 0 || getJobsText().equals("No matching jobs found.")) {
            return true;
        }
        return false;
    }

    @Then("^the user sees a counter jobs or message \"([^\"]*)\"$")
    public void getResult() {
        Assert.assertTrue(findJobs());
    }
}
