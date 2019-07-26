package com.revolut.task.core.pageobject.pages;

import com.revolut.task.core.waiter.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.revolut.task.core.pageobject.enums.Locator.*;
import static com.revolut.task.core.utils.Formatters.xpathCommunityNavigationBarSelection;

public class CommunityPage extends WebPage {

    public static final String COMMUNITY_URL = System.getProperty("community.url");
    private static final String SLASH = "/";

    public CommunityPage(WebDriver driver) {
        super(driver);

        url = COMMUNITY_URL;
    }

    public SearchSection openSearchTab() {
        WebElement search = findElementWithWait(By.xpath(COMMUNITY_SEARCH_BUTTON_XPATH.getValue()));
        new Actions(driver)
                .moveToElement(search)
                .click()
                .build()
                .perform();
        return new SearchSection(driver);
    }

    public void login() {
        new Actions(driver)
                .moveToElement(findElementWithWait(By.xpath(COMMUNITY_PAGE_LOGIN_BUTTON_XPATH.getValue())))
                .click()
                .sendKeys(System.getProperty("user.name"))
                .sendKeys(Keys.TAB)
                .sendKeys(System.getProperty("user.password"))
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        Waiter.until(driver, d -> isElementDisplayed(By.xpath(COMMUNITY_PAGE_ICON_FOR_CURRENT_USER_XPATH.getValue())));
    }

    public CommunityPage sendShortcut(CharSequence... keys) {
        new Actions(driver).sendKeys(keys).build().perform();
        return this;
    }

    public CommunityPage holdKey(CharSequence key) {
        new Actions(driver).keyDown(key).build().perform();
        return this;
    }

    public void openAnyTopic(String topicName) {
        sendShortcut(SLASH).sendShortcut(topicName);
        Waiter.until(driver, d -> isElementDisplayed(By.xpath(COMMUNITY_TOPIC_TITLE_XPATH.getValue())));
        sendShortcut(Keys.ARROW_DOWN).sendShortcut(Keys.ARROW_DOWN).sendShortcut(Keys.ENTER);
        Waiter.until(driver, d -> isElementDisplayed(By.xpath(COMMUNITY_TOPIC_PAGE_TITLE_XPATH.getValue())));
        Waiter.untilPageLoadComplete(driver);
    }

    public String getTextButtonTopicNotifications() {
        sendShortcut(Keys.END);
        WebElement elementWithWait = findElementWithWait(By.xpath(TOPIC_BUTTON_CHANGE_WATCH_OPTIONS_XPATH.getValue()));
        return elementWithWait != null ? elementWithWait.getAttribute("data-name") : "";
    }

    public boolean isMenuItemSelected(String menuItemText) {
        return isElementDisplayed(By.xpath(xpathCommunityNavigationBarSelection(menuItemText)));
    }
}