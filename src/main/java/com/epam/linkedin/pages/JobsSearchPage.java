package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class JobsSearchPage extends BasePage {

    @FindBy(xpath = "//*[@class='Sans-13px-black-55%']")
    private WebElement counterJobs;

    @FindBy(xpath = "//*[contains(text(),'No matching jobs found.')]")
    private WebElement textAboutNotFoundJobs;

    @FindBy(xpath = "//button[@data-control-name='jobs_save_button__save']")
    private WebElement buttonSave;

    @FindBy(xpath = "//*[@id='jobs-tab-icon']")
    private WebElement linkJobs;

    @FindBy(xpath = "//*[@data-control-name='company_link']")
    private WebElement companyName;

    public JobsSearchPage() {
        super();
    }

    public String getCounterText() {
        log.info("Counter jobs =  " + counterJobs.getText());
        return counterJobs.getText();
    }

    public Integer counterViewJobs() {
        String str = getCounterText();
        String[] s = str.split(" result");
        int count = Integer.parseInt(s[0]);
        log.info("Count =  " + count);
        return count;
    }

    public String getTextAboutJobs() {
        log.info("Show message : No matching jobs found.");
        return textAboutNotFoundJobs.getText();
    }

    public void clickButtonSave() {
        buttonSave.click();
        log.info("Click on button 'Save'");
    }

    public void clickLinksJobs() {
        linkJobs.click();
        log.info("open link Jobs");
    }

    public String getCompanyName() {
        log.info("Company name  " + companyName.getText());
        return companyName.getText();
    }
}
