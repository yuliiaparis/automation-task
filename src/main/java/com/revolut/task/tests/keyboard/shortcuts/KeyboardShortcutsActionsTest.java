package com.revolut.task.tests.keyboard.shortcuts;

import com.revolut.task.core.pageobject.pages.CommunityPage;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.revolut.task.core.pageobject.enums.Locator.TOPIC_SHARE_LINK_POPUP_ELEMENT_XPATH;

public class KeyboardShortcutsActionsTest extends BaseKeyboardShortcutsConfigurator {

    @Ignore("this test will fail as shortcut does not work -- defect")
    @Test
    public void sharePostOpenedByShiftS() {
        CommunityPage CommunityPage = openAnyTopicInCommunityPage();
        CommunityPage.holdKey(Keys.SHIFT).sendShortcut(S_SHARE_TOPIC);
        Assertions.assertThat(CommunityPage.isOpened(TOPIC_SHARE_LINK_POPUP_ELEMENT_XPATH)).isTrue();
    }

    @Test
    public void topicMarkedAsMuted() {
        CommunityPage CommunityPage = openAnyTopicInCommunityPage();
        CommunityPage.sendShortcut(new String[]{M_TOPIC_NOTIFICATION_, M_MUTE});
        Assertions.assertThat(CommunityPage.getTextButtonTopicNotifications()).isEqualTo(TOPIC_MUTED);
    }

    @Test
    public void topicMarkedAsNormal() {
        CommunityPage communityPage = openAnyTopicInCommunityPage();
        communityPage.sendShortcut(M_TOPIC_NOTIFICATION_).sendShortcut(R_DEFAULT_TOPIC);
        Assertions.assertThat(communityPage.getTextButtonTopicNotifications()).isEqualTo(TOPIC_NORMAL);
    }

    @Test
    public void topicMarkedAsTracking() {
        CommunityPage communityPage = openAnyTopicInCommunityPage();
        communityPage.sendShortcut(M_TOPIC_NOTIFICATION_).sendShortcut(T_TRACKING_TOPIC);
        Assertions.assertThat(communityPage.getTextButtonTopicNotifications()).isEqualTo(TOPIC_TRACKING);
    }

    @Test
    public void topicMarkedAsWatching() {
        CommunityPage CommunityPage = openAnyTopicInCommunityPage();
        CommunityPage.sendShortcut(M_TOPIC_NOTIFICATION_).sendShortcut(W_WATCH_TOPIC);
        Assertions.assertThat(CommunityPage.getTextButtonTopicNotifications()).isEqualTo(TOPIC_WATCHING);
    }
}