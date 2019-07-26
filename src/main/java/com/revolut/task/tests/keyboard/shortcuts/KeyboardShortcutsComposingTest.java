package com.revolut.task.tests.keyboard.shortcuts;

import com.revolut.task.core.pageobject.pages.CommunityPage;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.revolut.task.core.pageobject.enums.Locator.TOPIC_REPLY_ELEMENT_XPATH;

public class KeyboardShortcutsComposingTest extends BaseKeyboardShortcutsConfigurator {

    @Test
    public void replyToTopic() {
        CommunityPage communityPage = openAnyTopicInCommunityPage();
        communityPage.holdKey(Keys.SHIFT).sendShortcut(R_REPLY_TO_TOPIC);
        Assertions.assertThat(communityPage.isOpened(TOPIC_REPLY_ELEMENT_XPATH)).isTrue();
    }
}