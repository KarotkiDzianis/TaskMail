package com.epam.linkedin.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class MailPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Создать ярлык')]")
    private WebElement buttonCreateLabel;

    @FindBy(xpath = "//input[@class='xx']")
    private WebElement fieldForNameLabel;

    @FindBy(xpath = "//*[@role='button' and @id=':9l']")
    private WebElement linkYet;

    @FindBy(xpath = "//button[@name='ok']")
    private WebElement buttonCreate;

    public MailPage() {
        super();
    }

    /**
     * method create new Label for groupe messages
     */
    public void createNewLabel(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='button' and @id=':9l']")));
        linkYet.click();
        log.info("Link Yet click");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='CL Wj']")));
        buttonCreateLabel.click();
        log.info("Link Create click");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='xx']")));
        fieldForNameLabel.clear();
        fieldForNameLabel.sendKeys(name);
        log.info("Label name entered: " + name);
        buttonCreate.click();
    }


    /**
     * method delete  Label by Name
     */
   /* public void deleteLabel(){
        driver.findElement(By.xpath("//div[@class = 'container body-content']//tr[" + n + "]/td[2]/a")).click();
    }*/
}
