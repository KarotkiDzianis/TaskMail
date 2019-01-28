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

    @FindBy(xpath = "//*[@class='CL W']")
    private WebElement buttonCreateLabel;

    @FindBy(xpath = "//*[@id=':ec.na']")
    private WebElement fieldForNameLabel;

    @FindBy(xpath = "//*[@id=':9a']/span[2]/div")
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
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':9a']/span[2]/div")));
        linkYet.click();
        log.info("Link Yet click");
        buttonCreateLabel.click();
        fieldForNameLabel.clear();
        fieldForNameLabel.sendKeys(name);
        log.info("Label name entered: " + name);
        buttonCreate.click();
    }

    public void createNewLabelJS(String name) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement el = (WebElement) javascriptExecutor.executeScript("document.getElementByXpath('//*[@class='CJ']')");
        el.click();
        buttonCreateLabel.click();
        fieldForNameLabel.clear();
        fieldForNameLabel.sendKeys(name);
        buttonCreate.click();
    }

    /**
     * method delete  Label by Name
     */
   /* public void deleteLabel(){
        driver.findElement(By.xpath("//div[@class = 'container body-content']//tr[" + n + "]/td[2]/a")).click();
    }*/
}
