package com.epam.linkedin.pages;

import com.epam.linkedin.Main.Main;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Log4j2
public class MailPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Создать ярлык')]")
    private WebElement buttonCreateLabel;

    @FindBy(xpath = "//input[@class='xx']")
    private WebElement fieldForNameLabel;

    @FindBy(xpath = "//*[@id=':9r']/span[1]")      //*[@role='button' and @id=':9l']
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

    public MailPage() {
        super();
    }

    /**
     * method creates new Label for groupe messages
     */
    public void createNewLabel(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':9r']/span[1]")));
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
            namesMes.put(i, vowels / consonants);
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
    public Map filterMapsbyValue(Map map) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).forEach(System.out::println);
        log.info("map is sorted");
        Set <Integer> keys = map.keySet();
        System.out.println("All keys are: " + keys);
        return map;
    }

    public Map filterMapsbyValue2(Map map) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
      return   map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).collect(Collectors.toMap(Entry::getKey, Map.Entry::getValue);

    }

    /**
     * method choose necessary checkBox near messages
     */
    public void checkBox(Map map){
        HashSet<Integer> setKey = new HashSet<>();
        Set keys = map.keySet();
        System.out.println("All keys are: " + keys);
// To get all key: value
        for(Object key: keys){
            System.out.println(key + ": " + map.get(key));
        }
        //WebElement checkBox = driver.findElement(By.xpath("/*//*[@role='tabpanel']//tbody/tr[" + i + "]/*//*[@role='checkbox']"));
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
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Удалить ярлык']")));
        linkDeleteLabel.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='ok' and @class='J-at1-atl']")));
        buttonDelete.click();
        log.info("Label with name: " + Main.NAME_LABEL + " is deleted");
    }
}
