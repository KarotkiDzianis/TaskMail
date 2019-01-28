package com.epam.linkedin.ui;

import com.epam.jira.JIRATestKey;
import com.epam.linkedin.steps.ChooseJobsSteps;
import com.epam.linkedin.steps.LoginSteps;
import com.epam.linkedin.steps.ViewVacanciesSteps;
import com.epam.linkedin.utils.RandomUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.epam.jira.testng.ExecutionListener.class, com.epam.reportportal.testng.ReportPortalTestNGListener.class})
public class JobsTest extends BaseTest {

    private final static String JOBS_POSITIVE = "junior QA";
    private final static String LOCATION = "Belarus";
    private LoginSteps loginSteps;
    private ViewVacanciesSteps viewVacanciesSteps;
    private ChooseJobsSteps chooseJobsSteps;

    @JIRATestKey(key = "EPMFARMATS-5398")
    @Test(description = "[EPMFARMATS-5398]: Choose jobs")
    public void chooseJobsTest() {
        loginSteps = new LoginSteps();
        loginSteps.login(EMAIL, PASSWORD);
        viewVacanciesSteps = new ViewVacanciesSteps();
        viewVacanciesSteps.openJobs();
        viewVacanciesSteps.enterDataSearchJobs(JOBS_POSITIVE);
        viewVacanciesSteps.enterDataSearchLocation(LOCATION);
        viewVacanciesSteps.pushButtonSearch();
        chooseJobsSteps = new ChooseJobsSteps();
        chooseJobsSteps.saveAndUnsaveJobs();
    }

    @JIRATestKey(key = "EPMFARMATS-5259")
    @Test(description = "[EPMFARMATS-5259]: View vacancies")
    public void ViewVacanciesTest() {
        loginSteps = new LoginSteps();
        loginSteps.login(EMAIL, PASSWORD);
        viewVacanciesSteps = new ViewVacanciesSteps();
        viewVacanciesSteps.openJobs();
        viewVacanciesSteps.enterDataSearchJobs(RandomUtils.getRandomString(2));
        viewVacanciesSteps.enterDataSearchLocation(LOCATION);
        viewVacanciesSteps.pushButtonSearch();
        viewVacanciesSteps.getResult();
    }
}
