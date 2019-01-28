package com.epam.linkedin.mobile;

import com.epam.linkedin.mobile.steps.LoginStepsMobile;
import com.epam.linkedin.mobile.steps.SearchStepsMobile;
import org.testng.annotations.Test;

public class SearchJobMobileTest extends BaseTestMobile {

    private final static String JOB = "QA automation";
    private final static String LOCATION = "Minsk";
    private LoginStepsMobile loginStepsMobile;
    private SearchStepsMobile searchStepsMobile;

    @Test
    public void searchJobs() {
        loginStepsMobile = new LoginStepsMobile();
        loginStepsMobile.loginFromStartPage();
        loginStepsMobile.login(EMAIL, PASSWORD);
        searchStepsMobile = new SearchStepsMobile();
        searchStepsMobile.fillFormSearch(JOB + LOCATION);
        searchStepsMobile.viewVacancies();
        searchStepsMobile.clickFirstJobs();
        searchStepsMobile.clickButtonSave();
    }
}
