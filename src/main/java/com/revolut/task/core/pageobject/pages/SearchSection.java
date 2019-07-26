package com.revolut.task.core.pageobject.pages;

import com.revolut.task.core.pageobject.BasePageObject;
import com.revolut.task.core.utils.Formatters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchSection extends BasePageObject {

    SearchSection(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchSection search(String text) {
        new Actions(driver).sendKeys(text).build().perform();
        return this;
    }

    public TopicPage selectTopic(String text) {
        WebElement element = findElementWithWait(By.xpath(Formatters.xpathForTopicText(text)));
        new Actions(driver).moveToElement(element).click().build().perform();
        return new TopicPage(driver);
    }
}