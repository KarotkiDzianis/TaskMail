package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.utils.TouchUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchResultsMobilePage extends BasePageMobile {

    @AndroidFindBy(id = "ccom.linkedin.android:id/ad_empty_state_title")
    private MobileElement textNoFound;

    @AndroidFindBy(id = "com.linkedin.android:id/search_simple_text")
    private MobileElement countJob;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/" +
            "android.widget.RelativeLayout[1]/android.widget.LinearLayout")
    private MobileElement firstJob;

    public String getTextNoFound() {
        return textNoFound.getText();
    }

    public String getTextFirstJob() {
        log.info("Counter jobs =  " + firstJob.getText());
        return firstJob.getText();
    }

    public void clickFirstJob() {
        TouchUtilsMobile.tapOnPosition(400, 500);
        log.info("Click link 'First Job'");
    }

    public String getCounterText() {
        log.info("Counter jobs =  " + countJob.getText());
        return countJob.getText();
    }

    public Integer counterViewJobs() {
        String str = getCounterText();
        String[] s = str.split(" ");
        int count = Integer.parseInt(s[0]);
        log.info("Count =  " + count);
        return count;
    }
}
