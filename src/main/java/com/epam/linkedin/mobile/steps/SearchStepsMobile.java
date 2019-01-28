package com.epam.linkedin.mobile.steps;

import com.epam.linkedin.mobile.pages.HomePageMobile;
import com.epam.linkedin.mobile.pages.JobsMobilePage;
import com.epam.linkedin.mobile.pages.SearchResultsMobilePage;

import static org.testng.Assert.assertTrue;


public class SearchStepsMobile {

    private HomePageMobile homePage;
    private SearchResultsMobilePage searchResultsPage = new SearchResultsMobilePage();
    private JobsMobilePage jobsMobilePage = new JobsMobilePage();

    public void fillFormSearch(String mes) {
        homePage = new HomePageMobile();
        homePage.openSearchForm(mes);
    }

    public void viewVacancies() {
        homePage.viewResJob();
        homePage.chooseVacancies();
    }

    public void clickFirstJobs() {
        searchResultsPage.clickFirstJob();
    }

    public void clickButtonSave() {
        assertTrue(jobsMobilePage.clickSave());
    }
}
