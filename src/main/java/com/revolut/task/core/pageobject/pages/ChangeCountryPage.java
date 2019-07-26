package com.revolut.task.core.pageobject.pages;

import com.revolut.task.core.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.revolut.task.core.utils.Formatters.xpathWithText;

public class ChangeCountryPage extends BasePageObject {

    ChangeCountryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FooterSection selectCountry(String country) {
        findElementWithWait(By.xpath(xpathWithText(country))).click();
        return new FooterSection(driver);
    }
}