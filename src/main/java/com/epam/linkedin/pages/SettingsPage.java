package com.epam.linkedin.pages;

import com.epam.linkedin.utils.WaitUtils;
import com.epam.linkedin.webdriver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SettingsPage extends BasePage {

    @FindBy(name = "selectLanguage")
    private WebElement languageList;

    private WebElement languageOption;

    public SettingsPage() {
        super();
    }

    public void clickOnLanguagesList() {
        WaitUtils.waitForVisibility(languageList);
        languageList.click();
        log.info("Click on language list");
    }

    public void chooseNeededLanguage(String language) {
        String languageValue = "//*[@value='" + language + "']";
        languageOption = DriverManager.getDriver().findElement(By.xpath(languageValue));
        languageOption.click();
        log.info("Needed language is chosen: " + language);
        WaitUtils.sleep(5000);
    }

    public boolean getPageLanguage(String language) {
        log.info("Get chosen language");
        return DriverManager.getDriver().findElement(By.xpath("//*[@value='" + language + "' and @selected]")).isDisplayed();
    }
}
