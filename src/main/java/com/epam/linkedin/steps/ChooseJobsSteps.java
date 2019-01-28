package com.epam.linkedin.steps;

import com.epam.linkedin.pages.JobsPage;
import com.epam.linkedin.pages.JobsSearchPage;
import com.epam.linkedin.pages.SavedJobsPage;
import cucumber.api.java.en.Then;

import static org.testng.AssertJUnit.assertEquals;

public class ChooseJobsSteps {

    private JobsSearchPage jobsSearchPage = new JobsSearchPage();
    private JobsPage jobsPage = new JobsPage();
    private SavedJobsPage savedJobsPage = new SavedJobsPage();

    @Then("^the user save job and after unsave this job$")
    public void saveAndUnsaveJobs() {
        String first = jobsSearchPage.getCompanyName();
        jobsSearchPage.clickButtonSave();
        jobsSearchPage.clickLinksJobs();
        jobsPage.clickLinkSavedJobs();
        savedJobsPage.unSaveJobs();
        String second = savedJobsPage.getNameJobs();
        assertEquals(first, second);
    }
}
