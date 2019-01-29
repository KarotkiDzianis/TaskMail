package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Log4j2
public class EnterPasswordPage extends BasePage {

    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    private WebElement fieldPassword;

    @FindBy(xpath = "//*[@role='button' and @id='passwordNext']")
    private WebElement button;

    public EnterPasswordPage() {
        super();
    }

    /**
     * method fill the field Password and click Button 'Next'
     */
    public MailPage fieldPasswordSendKeys(String pass) {
        log.info("From PassPage");
        fieldPassword.sendKeys(pass);
        log.info("Enter password: " + pass);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='button' and @id='passwordNext']")));
        button.click();
        log.info("Button Next is click ");
        return new MailPage();
    }
}
