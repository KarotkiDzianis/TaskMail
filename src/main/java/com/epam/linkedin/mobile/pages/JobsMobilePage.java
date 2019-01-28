package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.utils.TouchUtilsMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JobsMobilePage extends BasePageMobile {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/" +
            "android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/" +
            "android.widget.LinearLayout[2]/android.widget.Button[1]")
    private MobileElement buttonSave;

    public boolean clickSave() {
        log.info("Search button 'Save'");
        return buttonSave.isDisplayed();
    }

    public void closePopUPWindow() {
        TouchUtilsMobile.tapOnPosition(200, 1050);
        log.info("Click on button 'No, thanks'");
    }
}
