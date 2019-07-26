package com.revolut.task.core.pageobject.enums;

public enum Locator {
    MAIN_MENU_HELP_BUTTON_XPATH(getProperty("main.menu.help.xpath")),

    BANNER_XPATH(getProperty("banner.xpath")),
    BANNER_TEST_WRAPPER_XPATH(getProperty("banner.text.wrapper.xpath")),
    BANNER_CLOSE_ICON_XPATH(getProperty("banner.close.icon.xpath")),

    BURGER_MENU_SECTION_XPATH(getProperty("burger.menu.section.xpath")),

    FOOTER_COUNTRY_NAME_XPATH(getProperty("footer.country.name.xpath")),

    COMMUNITY_SEARCH_BUTTON_XPATH(getProperty("community.search.button.xpath")),
    COMMUNITY_SEARCH_INPUT_ELEMENT_XPATH(getProperty("community.search.element.xpath")),
    COMMUNITY_TOPIC_TITLE_XPATH(getProperty("community.topic.title.xpath")),
    COMMUNITY_TOPIC_PAGE_TITLE_XPATH(getProperty("community.topic.page.title.xpath")),
    COMMUNITY_PAGE_LOGIN_BUTTON_XPATH(getProperty("community.page.login.button.xpath")),
    COMMUNITY_PAGE_ICON_FOR_CURRENT_USER_XPATH(getProperty("community.page.current.user.icon.xpath")),
    COMMUNITY_PAGE_USER_MENU_SECTION_XPATH(getProperty("community.section.user.menu.section.xpath")),
    COMMUNITY_PAGE_HELP_SECTION_SHORTCUTS_XPATH(getProperty("help.section.for.shortcuts.help")),
    TOPIC_REPLY_ELEMENT_XPATH(getProperty("topic.reply.to.element.xpath")),
    TOPIC_SHARE_LINK_POPUP_ELEMENT_XPATH(getProperty("topic.share.link.popup.element.xpath")),
    TOPIC_BUTTON_CHANGE_WATCH_OPTIONS_XPATH(getProperty("topic.button.change.watch.options"));

    private static String getProperty(String s) {
        return System.getProperty(s);
    }

    private final String value;

    Locator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}