package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class JobsPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder=\"Search jobs\"]")
    private WebElement formSearchJobs;

    @FindBy(xpath = "//input[@placeholder=\"Search location\"]")
    private WebElement formSearchLocation;

    @FindBy(xpath = "//button[@class=\"jobs-search-box__submit-button button-secondary-large-inverse\"]")
    private WebElement buttonSearch;

    @FindBy(xpath = " //*[@href='/jobs/saved/'] ")
    private WebElement linkSaveJobs;

    public JobsPage() {
        super();
    }

    public void fillFormSearchJobs(String mes) {
        formSearchJobs.clear();
        formSearchJobs.sendKeys(mes);
        log.info("Type search jobs: " + mes);
    }

    public void fillFormSearchLocation(String loc) {
        formSearchLocation.clear();
        formSearchLocation.sendKeys(loc);
        log.info("Type search location: " + loc);
    }

    public void clickButtonsearch() {
        buttonSearch.click();
        log.info("Click button 'Search'");
    }


    public void clickLinkSavedJobs() {
        linkSaveJobs.click();
        log.info("Click link 'Save' for save job");
    }
}
