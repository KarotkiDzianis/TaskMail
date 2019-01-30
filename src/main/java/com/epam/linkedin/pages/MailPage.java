package com.epam.linkedin.pages;

import com.epam.linkedin.Main.Main;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//*[@id=':bu']/div")
    private WebElement linkTOP5;

    @FindBy(xpath = " //*[@data-label-name='TOP5']/child::node()")
    private WebElement flagTOP5;

    @FindBy(xpath = "//*[text()='Удалить ярлык']")
    private WebElement linkDeleteLabel;

    @FindBy(xpath = "//button[@name='ok' and @class='J-at1-atl']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//*[@jscontroller='ZdOxDb']/td[5]//span/span")
    private List<WebElement> listMailsName;



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

public void makeListName(){
        int count =listMailsName.size();
        List<String> namesMes= new ArrayList<>();
        for(int i=0; i<count; i++){
            WebElement el = listMailsName.get(i);
            namesMes.add( el.getText());
        }
    System.out.println(namesMes.toString());
}
    /**
     * method delete  Label by Name
     */
    public void deleteLabel(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':bu']/div")));
        Actions action = new Actions(driver);
        action.moveToElement(linkTOP5).build().perform();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-label-name='TOP5']/child::node()")));
        flagTOP5.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Удалить ярлык']")));
        linkDeleteLabel.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='ok' and @class='J-at1-atl']")));
        buttonDelete.click();
        log.info("Label with name: " + Main.NAME_LABEL +" is deleted");
    }
}
