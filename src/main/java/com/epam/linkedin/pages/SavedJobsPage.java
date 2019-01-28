package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SavedJobsPage extends BasePage {

    @FindBy(xpath = "//*[@class='job-card__company-name']")
    private WebElement savedJobsName;

    @FindBy(xpath = "//*[@data-control-name='saved_job_unsave']")
    private WebElement linkUnsave;

    public SavedJobsPage() {
        super();
    }

    public String getNameJobs() {
        log.info("Saved jobs is :" + savedJobsName.getText());
        return savedJobsName.getText();
    }

    public void unSaveJobs() {
        linkUnsave.click();
        log.info("Click link 'UnSave'");
    }
}
