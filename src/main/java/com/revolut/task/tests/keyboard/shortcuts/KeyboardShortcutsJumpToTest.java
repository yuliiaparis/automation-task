package com.revolut.task.tests.keyboard.shortcuts;

import com.revolut.task.core.pageobject.pages.CommunityPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.revolut.task.core.pageobject.pages.CommunityPage.COMMUNITY_URL;


@RunWith(Parameterized.class)
public class KeyboardShortcutsJumpToTest extends BaseKeyboardShortcutsConfigurator {

    @Parameterized.Parameter(0)
    public CharSequence firstKey;
    @Parameterized.Parameter(1)
    public CharSequence secondKey;
    @Parameterized.Parameter(2)
    public String topic;

    @Parameterized.Parameters(name = "{index}: Test with shortcut {0}, {1}. Expected page menu is: {2}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {G_JUMP_TO_, H_JUMP_TO_HOME, CATEGORIES_TOPIC_G_H_C},
                {G_JUMP_TO_, L_JUMP_TO_LATEST, LATEST_TOPIC_G_L},
                {G_JUMP_TO_, C_JUMP_TO_CATEGORIES, CATEGORIES_TOPIC_G_H_C},
                {G_JUMP_TO_, T_JUMP_TO_TOP, TOP_TOPIC_G_T},
                {G_JUMP_TO_, N_JUMP_TO_NEW, NEW_TOPIC_G_N},
                {G_JUMP_TO_, U_JUMP_TO_UNREAD, UNREAD_TOPIC_G_U},
                {G_JUMP_TO_, B_JUMP_TO_BOOKMARKS, BOOKMARKS_TOPIC_G_B}
        };
        return Arrays.asList(data);
    }

    @Test
    public void correctPageIsOpenedAfterShortcut() {
        CommunityPage shortcut = pressShortcut(firstKey, secondKey);

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(shortcut.isMenuItemSelected(topic)).isTrue();
        softy.assertThat(shortcut.getCurrentUrl())
                .contains(COMMUNITY_URL.concat(topic
                        .replaceFirst(CATEGORIES_TOPIC_G_H_C, "") // categories can have same (empty) path in url as home
                        .toLowerCase()
                ).intern());
        softy.assertAll();
    }
}