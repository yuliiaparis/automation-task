package com.revolut.task.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    public static void loadProperties(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(input);
            properties.forEach((key, value) -> System.setProperty(key.toString(), value.toString()));
        } catch (IOException ex) {
            logger.error("Unable to load properties {}", filePath, ex);
        }
    }
}