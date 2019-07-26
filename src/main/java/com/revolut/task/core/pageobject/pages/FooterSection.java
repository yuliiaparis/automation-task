package com.revolut.task.core.pageobject.pages;

import com.revolut.task.core.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.revolut.task.core.pageobject.enums.Locator.FOOTER_COUNTRY_NAME_XPATH;

public class FooterSection extends BasePageObject {

    private static String countryXpath = FOOTER_COUNTRY_NAME_XPATH.getValue();

    FooterSection(WebDriver driver) {
        super(driver);
    }

    public boolean isCountryFound() {
        return isElementDisplayed(By.xpath(countryXpath));
    }

    public String getCountryName() {
        return findElementWithWait(By.xpath(countryXpath)).getText();
    }

    public ChangeCountryPage clickOnChangeCountry() {
        WebElement element = findElementWithWait(By.xpath(countryXpath));
        new Actions(driver).moveToElement(element).click(element).perform();
        return new ChangeCountryPage(driver);
    }
}