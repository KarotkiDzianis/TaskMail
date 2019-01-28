package com.epam.linkedin.ui;

import com.epam.jira.JIRATestKey;
import com.epam.linkedin.steps.CompanyPageSteps;
import com.epam.linkedin.steps.LoginSteps;
import com.epam.linkedin.utils.RandomUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.epam.jira.testng.ExecutionListener.class, com.epam.reportportal.testng.ReportPortalTestNGListener.class})
public class CompanyPageTest extends BaseTest {

    private LoginSteps loginSteps;
    private CompanyPageSteps companyPageSteps;

    @JIRATestKey(key = "EPMFARMATS-5260")
    @Test(description = "[EPMFARMATS-5260]: Company page")
    public void ViewVacanciesTest() {
        loginSteps = new LoginSteps();
        loginSteps.login(EMAIL, PASSWORD);
        companyPageSteps = new CompanyPageSteps();
        companyPageSteps.openLinkWork();
        companyPageSteps.openCreateCompPage();
        companyPageSteps.enterNameCompany(RandomUtils.getRandomString(6));
        companyPageSteps.theUserCreateCompanyPageAndThenDeleteThisPage();
    }
}
