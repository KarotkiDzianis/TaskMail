package com.epam.linkedin.pages;

import com.epam.linkedin.utils.WaitUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CompanyPage extends BasePage {

    @FindBy(xpath = "//input[@id='organization-create-company-name']")
    private WebElement formCompanyName;

    @FindBy(xpath = "//*[@class='text-align-left mb4 mt6 org-create-form-module__representative-label']")
    private WebElement checkBox;

    @FindBy(xpath = "//button[@class='button-primary-large mt6 mb4 org-create-form-module__submit-button']")
    private WebElement buttonCreatePage;

    @FindBy(xpath = "//button[@class='creation-welcome-modal__done-button button-primary-medium ml1 mr1']")
    private WebElement buttonGetStarted;

    @FindBy(xpath = "//*[@class='js-org-admin-page-header__company-name--tall t-24 t-black t-light']")
    private WebElement companyName;

    @FindBy(xpath = "//*[text()='Admin tools']")
    private WebElement linkAdminTools;

    @FindBy(xpath = "//*[@id='deactivate-company-page']")
    private WebElement linkDeleteCompanyPage;

    @FindBy(xpath = "//button[text()='Deactivate']")
    private WebElement linkDeactivate;

    @FindBy(xpath = "//*[text()='Your Page was successfully deactivated!']")
    private WebElement expectedMes;

    @FindBy(xpath = "//button[text()='Go back to LinkedIn']")
    private WebElement linkGoBack;

    public CompanyPage() {
        super();
    }

    public void enterNameCompany(String name) {
        formCompanyName.sendKeys(name);
        log.info("Type message: " + name);
    }

    public void createPage() {
        checkBox.click();
        log.info("Click on 'CheckBox'");
        buttonCreatePage.click();
        log.info("Click on 'buttonCreate'");
    }

    public String getCompName() {
        log.info("'Company name' : " + formCompanyName.getText());
        return formCompanyName.getText();
    }

    public void closePopUpWindow() {
        WaitUtils.sleep(5000);
        buttonGetStarted.click();
        log.info("Click on button 'GetStarted'");
    }

    public String getNameCreateCompany() {
        log.info("'New company name' : " + companyName.getText());
        return companyName.getText();
    }

    public void adminTools() {
        linkAdminTools.click();
        log.info("Click on link 'Admin Tools'");
    }

    public void deleteCompanyPage() {
        linkDeleteCompanyPage.click();
        log.info("Click on link 'Delete Company Page'");
    }

    public void deactivatePage() {
        WaitUtils.sleep(5000);
        linkDeactivate.click();
        log.info("Click on link 'Deactivate'");
    }

    public String getTextAboutDeletePage() {
        log.info("Message : " + expectedMes.getText());
        return expectedMes.getText();
    }

    public void clickLinkGoBack() {
        linkGoBack.click();
        log.info("Click on link 'Go Back'");
    }
}
