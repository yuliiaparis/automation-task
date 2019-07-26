package com.revolut.task.core.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.revolut.task.core.pageobject.enums.Locator.COMMUNITY_TOPIC_PAGE_TITLE_XPATH;

public class TopicPage extends WebPage {

    TopicPage(WebDriver driver) {
        super(driver);
    }

    public String getTopicTitle() {
        return findElementWithWait(By.xpath(COMMUNITY_TOPIC_PAGE_TITLE_XPATH.getValue())).getText();
    }
}