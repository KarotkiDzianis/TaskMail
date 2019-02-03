package com.epam.linkedin.pages;

import com.epam.linkedin.Main.Main;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Log4j2
public class MailPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Создать ярлык')]")
    private WebElement buttonCreateLabel;

    @FindBy(xpath = "//input[@class='xx']")
    private WebElement fieldForNameLabel;

    @FindBy(xpath = "//*[@class='CJ']")
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

    @FindBy(xpath = "//*[@jscontroller='ZdOxDb']/td[6]")
    private List<WebElement> listMailsName;

    @FindBy(xpath = "//*[@id=':2q']/div[1]")
    private WebElement linkMoveTo;

    @FindBy(xpath = "//*[@role='menuitem' and @title='TOP5']")
    private WebElement chooseFolder;


    public MailPage() {
        super();
    }

    /**
     * method creates new Label for group messages
     */
    public void createNewLabel(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='CJ']")));
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
     * method fills the list  by NamesMes with just only litters, then create map witk key= nember messega on page & value= relation vowels/consonans
     */
    public Map<Integer, Double> makeListName() {
        int count = listMailsName.size();
        log.info("Count letters is " + listMailsName.size());
        Map<Integer, Double> namesMes = new HashMap<>();
        for (int i = 0; i < count; i++) {
            double vowels = 0;
            double consonants = 0;
            WebElement el = listMailsName.get(i);
            String sentence = el.getText().replaceAll("(?u)[^a-zA-zа-яА-Я]", "").toLowerCase();
            for (int j = 0; j < sentence.length(); j++) {
                char ch = sentence.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u' || ch == 'y' || ch == 'а' || ch == 'е' || ch == 'ё'
                        || ch == 'и' || ch == 'о' || ch == 'у' || ch == 'э' || ch == 'ю' || ch == 'я') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            namesMes.put(i + 1, vowels / consonants);
        }
        log.info("Map is created key=number message, value=vowels/consonants");
        for (Entry<Integer, Double> e : namesMes.entrySet()) {
            namesMes.put(e.getKey(), e.getValue());
            System.out.print(e.getKey());
            System.out.print(",");
            System.out.println(e.getValue());
        }
        return namesMes;
    }

    /**
     * method sorted Map by value
     */
    public List filterMapsbyValue(Map map) {
        List list = (List) map.entrySet().stream()
                .sorted(Entry.<Integer, Double>comparingByValue().reversed()).collect(Collectors.toList());
        log.info("map is sorted by value and save as list");
        return list;
    }

    /**
     * method choose necessary messages and click checkBox
     */
    public void checkBox(List list, int i) {
        for (int j = 0; j < i; j++) {
            String senc = list.get(j).toString();
            String[] number = senc.split("\\=");
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*//*[@role='tabpanel']//tbody/tr[" + number[0] + "]/*//*[@role='checkbox']")));
            WebElement checkBox = driver.findElement(By.xpath("/*//*[@role='tabpanel']//tbody/tr[" + number[0] + "]/*//*[@role='checkbox']"));
            checkBox.click();
            log.info("Click checkBox near the message number " + number[0]);
        }
    }

    /**
     * method transfer message to the folder
     */
    public void moveMessage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':2q']/div[1]")));
        linkMoveTo.click();
        log.info("Click link MoveTo");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='menuitem' and @title='TOP5']")));
        chooseFolder.click();
        log.info("Transfer message to the folder");
    }

    /**
     * method deletes  Label by Name
     */
    public void deleteLabel() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':bu']/div")));
        Actions action = new Actions(driver);
        action.moveToElement(linkTOP5).build().perform();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-label-name='TOP5']/child::node()")));
        flagTOP5.click();
        log.info("Drop menu for Folder TOP5 is opened");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Удалить ярлык']")));
        linkDeleteLabel.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='ok' and @class='J-at1-atl']")));
        buttonDelete.click();
        log.info("Label with name: " + Main.NAME_LABEL + " is deleted");
    }
}
