package com.revolut.task.tests.keyboard.shortcuts;

import com.revolut.task.core.pageobject.pages.CommunityPage;
import com.revolut.task.tests.BaseTestConfigurator;

class BaseKeyboardShortcutsConfigurator extends BaseTestConfigurator {

    private static final String TEST_TOPIC = "Revolut App";
    static final String REQUIRED_EXPLORATORY_FOR_UPDATED_TOPICS = "Required exploratory for updated topics.";

    static final String TOPIC_WATCHING = "Watching";
    static final String TOPIC_TRACKING = "Tracking";
    static final String TOPIC_NORMAL = "Normal";
    static final String TOPIC_MUTED = "Muted";

    static final String LATEST_TOPIC_G_L = "Latest";
    static final String CATEGORIES_TOPIC_G_H_C = "Categories"; // used both for home and categories
    static final String TOP_TOPIC_G_T = "Top";
    static final String NEW_TOPIC_G_N = "New";
    static final String UNREAD_TOPIC_G_U = "Unread";
    static final String BOOKMARKS_TOPIC_G_B = "Bookmarks";

    static final String QUOTATION_MARK_OPEN_MENU = "?";
    static final String SLASH_OPEN_SEARCH = "/";
    static final String DOT_UPDATED_TOPICS_SHORTCUT = ".";
    static final CharSequence F_SEARCH_CTRL_ALT_F = "f";
    static final String Z_LOG_OUT = "z";

    static final String G_JUMP_TO_ = "g";
    static final String B_JUMP_TO_BOOKMARKS = "b";
    static final String C_JUMP_TO_CATEGORIES = "c";
    static final String H_JUMP_TO_HOME = "h";
    static final String L_JUMP_TO_LATEST = "l";
    static final String N_JUMP_TO_NEW = "n";
    static final String P_JUMP_TO_PROFILE = "p";
    static final String U_JUMP_TO_UNREAD = "u";
    static final String T_JUMP_TO_TOP = "t";

    static final String R_REPLY_TO_TOPIC = "r";
    static final String S_SHARE_TOPIC = "s";
    static final String W_WATCH_TOPIC = "w";

    static final String M_TOPIC_NOTIFICATION_ = "m";
    static final String M_MUTE = "m";
    static final CharSequence R_DEFAULT_TOPIC = "r";
    static final CharSequence T_TRACKING_TOPIC = "t";

    CommunityPage pressShortcut(CharSequence firstKey, CharSequence secondKey) {
        CommunityPage communityPage = openAnyTopicInCommunityPage();
        driver.switchTo().parentFrame();
        communityPage.sendShortcut(firstKey).sendShortcut(secondKey);
        return communityPage;
    }

    CommunityPage openAnyTopicInCommunityPage() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.login();
        communityPage.openAnyTopic(TEST_TOPIC);
        communityPage.captureScreenShot();
        return communityPage;
    }
}