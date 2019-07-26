package com.revolut.task.tests.keyboard.shortcuts;

import com.revolut.task.core.pageobject.pages.CommunityPage;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.revolut.task.core.pageobject.enums.Locator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardShortcutsApplicationTest extends BaseKeyboardShortcutsConfigurator {

    @Test
    public void hamburgerMenuOpenedByShortcut() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.sendShortcut(Keys.EQUALS);
        assertThat(communityPage.isOpened(BURGER_MENU_SECTION_XPATH)).isTrue();
    }

    @Test
    public void userMenuNotOpenedByShortcutWithoutLogin() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.sendShortcut(P_JUMP_TO_PROFILE);
        assertThat(communityPage.isOpened(COMMUNITY_PAGE_USER_MENU_SECTION_XPATH)).isFalse();
    }

    @Test
    public void userMenuOpenedByShortcutAfterLogin() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.login();
        communityPage.sendShortcut(P_JUMP_TO_PROFILE);
        assertThat(communityPage.isOpened(COMMUNITY_PAGE_USER_MENU_SECTION_XPATH)).isTrue();
    }

    @Ignore(REQUIRED_EXPLORATORY_FOR_UPDATED_TOPICS)
    @Test
    public void showUpdatedTopicByShortcut() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.sendShortcut(DOT_UPDATED_TOPICS_SHORTCUT);
    }

    @Test
    public void searchMenuOpenedUsingSlashByShortcut() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.sendShortcut(SLASH_OPEN_SEARCH);
        assertThat(communityPage.isOpened(COMMUNITY_SEARCH_INPUT_ELEMENT_XPATH)).isTrue();
    }

    @Test
    public void searchMenuOpenedUsingKeysCombinationByShortcut() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.holdKey(Keys.CONTROL).holdKey(Keys.ALT).sendShortcut(F_SEARCH_CTRL_ALT_F);
        assertThat(communityPage.isOpened(COMMUNITY_SEARCH_INPUT_ELEMENT_XPATH)).isTrue();
    }

    @Test
    public void keyboardHelpOpenedByShortcut() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.sendShortcut(QUOTATION_MARK_OPEN_MENU);
        assertThat(communityPage.isOpened(COMMUNITY_PAGE_HELP_SECTION_SHORTCUTS_XPATH)).isTrue();
    }

    @Test
    public void logOutByDoubleShiftZShortcut() {
        CommunityPage communityPage = new CommunityPage(driver);
        communityPage.open();
        communityPage.login();
        communityPage.holdKey(Keys.SHIFT).sendShortcut(Z_LOG_OUT).holdKey(Keys.SHIFT).sendShortcut(Z_LOG_OUT);
        assertThat(communityPage.isOpened(COMMUNITY_PAGE_USER_MENU_SECTION_XPATH)).isFalse();
    }
}