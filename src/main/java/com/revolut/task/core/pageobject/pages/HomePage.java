package com.revolut.task.core.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.revolut.task.core.pageobject.enums.Locator.MAIN_MENU_HELP_BUTTON_XPATH;

public class HomePage extends WebPage {

    private static final String LINK_TEXT_COMMUNITY = "Community";

    public HomePage(WebDriver driver) {
        super(driver);

        url = System.getProperty("homepage.url");
    }

    public CommunityPage openCommunityPage() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(MAIN_MENU_HELP_BUTTON_XPATH.getValue())))
                .moveToElement(driver.findElement(By.linkText(LINK_TEXT_COMMUNITY)))
                .click()
                .perform();
        switchDriverTab();
        return new CommunityPage(driver);
    }
}