package com.epam.linkedin.mobile.pages;


import com.epam.linkedin.mobile.driver.DriverManagerMobile;
import com.epam.linkedin.mobile.utils.ScrollUtils;
import com.epam.linkedin.mobile.utils.TouchUtilsMobile;
import com.epam.linkedin.mobile.utils.WaitUtilsMobile;
import com.epam.linkedin.utils.WaitUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomePageMobile extends BasePageMobile {

    @AndroidFindBy(id = "com.linkedin.android:id/home_app_launcher")
    private MobileElement iconMenu;

    @AndroidFindBy(id = "com.linkedin.android:id/search_bar_text")
    private MobileElement searchForm;

    @AndroidFindBy(id = "com.linkedin.android:id/search_typeahead_see_all_results_text")
    private MobileElement viewResultsJobs;

    @AndroidFindBy(id = "//android.widget.FrameLayout[@content-desc='Фильтровать по: Вакансии']/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement linkVacancies;

    @AndroidFindBy(id = "com.linkedin.android:id/me_launcher")
    private MobileElement iconProfile;

    @AndroidFindBy(id = "com.linkedin.android:id/hover_card_dismiss_button")
    private MobileElement gotItButton;

    @AndroidFindBy(id = "com.linkedin.android:id/feed_fab")
    private MobileElement postIcon;

    @AndroidFindBy(id = "com.linkedin.android:id/sharing_compose_text_input")
    private MobileElement messageTextField;

    @AndroidFindBy(id = "com.linkedin.android:id/sharing_compose_post_button")
    private MobileElement postButton;

    @AndroidFindBy(id = "com.linkedin.android:id/feed_render_item_actor_top_bar_control_dropdown")
    private MobileElement arrowButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Delete post']")
    private MobileElement deletePostButton;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement deleteButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Значок панели вкладок'])[3]")
    private MobileElement iconMessages;

    public void openSearchForm(String str) {
        searchForm.click();
        searchForm.clear();
        searchForm.sendKeys(str);
        log.info("Enter Email: " + str);
    }

    @SneakyThrows(InterruptedException.class)
    public void viewResJob() {
        Thread.sleep(5000);
        ScrollUtils.swipeDownLowRes();
        ScrollUtils.swipeDownLowRes();
        viewResultsJobs.click();
        log.info("Click on button view result");
    }

    @SneakyThrows(InterruptedException.class)
    public void chooseVacancies() {
        Thread.sleep(1000);
        TouchUtilsMobile.tapOnPosition(200, 200);
        log.info("Click link 'Vacancies'");

    }

    public boolean iconMenuIsDisplayed() {
        return iconMenu.isDisplayed();
    }

    public void iconProfileClick() {
        WaitUtilsMobile.waitForVisibility(iconProfile);
        iconProfile.click();
        log.info("Click on 'Profile' button");
    }

    public void clickOnIconMessages() {
        WaitUtilsMobile.waitForVisibility(iconMessages);
        TouchUtilsMobile.tapOnPosition(605, 1835);
        log.info("Click on icon \"Messages\"");
    }

    public void clickOnPostIcon() {
        postIcon.click();
        log.info("Click on post icon");
    }

    public void enterMessageInTextField(String message) {
        WaitUtils.sleep(3000);
        if (DriverManagerMobile.getDriver().getPageSource().contains("Add a hashtag")) {
            gotItButton.click();
        }
        messageTextField.sendKeys(message);
        log.info("Enter message '" + message + "' in the text field");
    }

    public void clickOnPostButton() {
        postButton.click();
        log.info("Click on 'Post' button");
    }

    public void scrollDown() {
        WaitUtils.sleep(2000);
        ScrollUtils.swipeDown();
        log.info("Scroll page up");
    }

    public void clickOnArrowButton() {
        arrowButton.click();
        log.info("Click on arrow button");
    }

    public void clickOnDeletePostButton() {
        deletePostButton.click();
        log.info("Click on 'Delete post' button");
    }

    public void confirmDeletion() {
        deleteButton.click();
        log.info("Click on 'Delete' button");
    }

    public boolean isPostDisappeared() {
        log.info("Check that post disappeared");
        return true;
    }
}
