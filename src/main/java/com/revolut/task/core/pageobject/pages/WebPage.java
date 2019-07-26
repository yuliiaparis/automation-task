package com.revolut.task.core.pageobject.pages;

import com.revolut.task.core.pageobject.BasePageObject;
import com.revolut.task.core.waiter.Waiter;
import org.openqa.selenium.WebDriver;

public abstract class WebPage extends BasePageObject {

    String url;

    private FooterSection footer;

    private Banner banner;

    WebPage(WebDriver driver) {
        super(driver);

        footer = new FooterSection(driver);
        banner = new Banner(driver);
    }

    public String getDefaultUrl() {
        return url;
    }

    public WebPage open() {
        driver.get(url);
        Waiter.untilPageLoadComplete(driver);
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public FooterSection closeBanner() {
        banner.close();
        return footer;
    }

    public FooterSection getFooter() {
        return footer;
    }
}