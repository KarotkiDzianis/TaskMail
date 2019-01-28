package com.epam.linkedin.mobile.pages;

import com.epam.linkedin.mobile.utils.ScrollUtils;
import com.epam.linkedin.mobile.utils.TouchUtilsMobile;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SettingsPageMobile extends BasePageMobile {

    public void exitClick() {
        ScrollUtils.swipeUp();
        ScrollUtils.swipeUp();
        ScrollUtils.swipeUp();
        TouchUtilsMobile.tapOnPosition(110, 1520);
        log.info("Click on 'Exit' button");
    }
}
