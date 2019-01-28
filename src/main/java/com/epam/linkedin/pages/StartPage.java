package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class StartPage extends BasePage {


    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private WebElement buttonNext;


    public StartPage() {
        super();
    }

    /**
     * method fill the field Email and click Button 'Next'
     */
    public EnterPasswordPage fieldEmailSendKeys(String email) {
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        log.info("Enter email: " + email);
        buttonNext.click();
        log.info("Button Next is click ");
        return new EnterPasswordPage();
    }

}
