package com.revolut.task.core.pageobject;

import com.revolut.task.core.pageobject.enums.Locator;
import com.revolut.task.core.waiter.Waiter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public abstract class BasePageObject {

    private Logger logger = LoggerFactory.getLogger(BasePageObject.class);

    protected WebDriver driver;

    public BasePageObject(WebDriver webDriver) {
        this.driver = webDriver;
    }

    protected WebElement findElementWithWait(By locator) {
        return (WebElement) Waiter.until(driver, ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> findElementsWithWait(By locator) {
        return (List<WebElement>) Waiter.until(driver, ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return findElementsWithWait(locator) != null && findElementsWithWait(locator).size() != 0;
        } catch (WebDriverException e) {
            logger.error("Element is not displayed, thrown error:\n" + e.getMessage());
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void moveToSlidingElement(By locator) {
        WebElement element = findElementWithWait(locator);
        while (element.getLocation().x < driver.manage().window().getPosition().x
                || element.getLocation().y < driver.manage().window().getPosition().y
                || element.getLocation().x > driver.manage().window().getPosition().x + driver.manage().window().getSize().width
                || element.getLocation().y > driver.manage().window().getPosition().y + driver.manage().window().getSize().height) {
            // doing nothing
        }
        new Actions(driver).moveToElement(element).build().perform();
    }

    protected void switchDriverTab() {
        String mainTab = driver.getWindowHandle();
        driver.switchTo().window(driver
                .getWindowHandles()
                .stream()
                .filter(windowHandle -> !windowHandle.equals(mainTab)).findAny().get());
    }

    public boolean isOpened(Locator locator) {
        return isElementDisplayed(By.xpath(locator.getValue()));
    }

    public void captureScreenShot(String... screenshotName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String time = LocalDateTime.now().format(dtf);
        String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
        File screenshot1 = new File(String.format("target/screenshot_%s_%s_in_test_%s.png",
                time, Arrays.toString(screenshotName), testName));
        File outFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(outFile.toPath(), screenshot1.toPath());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    protected void click(WebElement element) {
        new Actions(driver).click(element).build().perform();
    }
}