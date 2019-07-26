package com.revolut.task.core.utils;

public class Formatters {

    public static String xpathWithText(String text) {
        return String.format("//*[contains(text(),'%s')]", text);
    }

    public static String xpathCommunityNavigationBarSelection(String text) {
        return String.format(
                "//*[@class='active ember-view' " +
                        "or @class='active has-icon ember-view'" +
                        "or @class='main-nav nav nav-pills user-nav ember-view']" +
                        "//*[contains(text(),'%s')]",
                text);
    }

    public static String xpathForTopicText(String text) {
        String[] words = text.split(" ");
        String xpath = "//*[";

        boolean atLeastOneChildAdded = false;
        for (String word : words) {
            if (atLeastOneChildAdded) xpath = xpath.concat(" and ").intern();
            xpath = xpath.concat(String.format("child::*/text()='%s'", word)).intern();
            atLeastOneChildAdded = true;
        }

        xpath = xpath.concat("]").intern();
        return xpath;
    }
}