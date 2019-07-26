package com.revolut.task.core.waiter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class Waiter {

    private static Logger logger = LoggerFactory.getLogger(Waiter.class);

    private static long implicitWaitTimeout = Long.valueOf(System.getProperty("implicit.wait"));

    public static void untilPageLoadComplete(WebDriver driver) {
        until(driver, (d) -> {
            boolean isPageLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) {
                logger.debug("Document is loading");
            }
            return isPageLoaded;
        });
    }

    public static Object until(WebDriver driver, Function<WebDriver, ?> waitCondition) {
        try {
            return new WebDriverWait(driver, implicitWaitTimeout).until(waitCondition);
        } catch (Exception e) {
            logger.error("Unable to wait for condition {}", waitCondition, e);
        }
        return null;
    }
}