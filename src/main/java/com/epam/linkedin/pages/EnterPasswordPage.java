package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class EnterPasswordPage extends BasePage {

    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    private WebElement fieldPassword;

    @FindBy(css = "#passwordNext > content > span")
    private WebElement button;

    public EnterPasswordPage() {
        super();
    }

    /**
     * method fill the field Password and click Button 'Next'
     */
    public void fieldPasswordSendKeys(String pass) {
        log.info("From PassPage");
        fieldPassword.sendKeys(pass);
        log.info("Enter password: " + pass);
        button.click();
        log.info("Button Next is click ");
    }
}
