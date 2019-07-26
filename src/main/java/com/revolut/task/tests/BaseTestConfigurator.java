package com.revolut.task.tests;

import com.revolut.task.core.utils.PropertiesLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BaseTestConfigurator {

    private static Logger logger = LoggerFactory.getLogger(BaseTestConfigurator.class);

    protected WebDriver driver;

    private static ChromeOptions options;

    @BeforeClass
    public static void init() {
        PropertiesLoader.loadProperties("src/main/resources/config.properties");
        PropertiesLoader.loadProperties("src/main/resources/locators.properties");
        PropertiesLoader.loadProperties("src/main/resources/log4j.properties");
        BasicConfigurator.configure();

        WebDriverManager
                .chromedriver()
                .setup();
        options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public static void killAllWebDriverProcesses() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}