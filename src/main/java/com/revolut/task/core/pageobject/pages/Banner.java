package com.revolut.task.core.pageobject.pages;

import com.revolut.task.core.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.revolut.task.core.pageobject.enums.Locator.*;

class Banner extends BasePageObject {

    Banner(WebDriver webDriver) {
        super(webDriver);
    }

    void close() {
        By bannerLocator = By.xpath(BANNER_XPATH.getValue());
        By bannerTextWrapperLocator = By.xpath(BANNER_TEST_WRAPPER_XPATH.getValue());
        By bannerCrossIcon = By.xpath(BANNER_CLOSE_ICON_XPATH.getValue());

        if (isElementDisplayed(bannerLocator) && isElementDisplayed(bannerTextWrapperLocator)) {
            moveToSlidingElement(bannerLocator);
            click(findElementWithWait(bannerCrossIcon));
        }
    }
}