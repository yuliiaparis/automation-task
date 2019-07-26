package com.revolut.task.tests;

import com.revolut.task.core.pageobject.pages.FooterSection;
import com.revolut.task.core.pageobject.pages.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

@Tag("main")
public class HomePageTest extends BaseTestConfigurator {

    private static final String UNITED_STATES = "United States";
    private static final String UNITED_KINGDOM = "United Kingdom";
    private static final String TEST_TEXT_WE_GOT_A_BANKING_LICENCE = "We got a banking licence";

    @Test
    public void homePageTitleIsCorrect() {
        Assertions.assertThat((new HomePage(driver)).open().getPageTitle()).isEqualTo(System.getProperty("homepage.title"));
    }

    @Test
    public void countryNameInFooterHasCorrectName() {
        FooterSection footer = new HomePage(driver)
                .open()
                .getFooter();

        Assertions.assertThat(footer.isCountryFound()).isTrue();
        Assertions.assertThat(footer.getCountryName()).isNotNull().isEqualTo(UNITED_KINGDOM);
    }

    @Test
    public void countryNameSuccessfullyChanged() {
        HomePage homePage = new HomePage(driver);
        String updatedCountryName = homePage
                .open()
                .closeBanner()
                .clickOnChangeCountry()
                .selectCountry(UNITED_STATES)
                .getCountryName();

        Assertions.assertThat(updatedCountryName).isNotNull().isEqualTo(UNITED_STATES);
        Assertions.assertThat(homePage.getCurrentUrl()).isEqualTo(homePage.getDefaultUrl().concat("en-US/"));
    }

    @Test
    public void gotBankingLicenseTopicFoundInCommunitySearchWithMaximizedScreen() {
        String topicTitle =
                ((HomePage) new HomePage(driver).open())
                        .openCommunityPage()
                        .openSearchTab()
                        .search(TEST_TEXT_WE_GOT_A_BANKING_LICENCE)
                        .selectTopic(TEST_TEXT_WE_GOT_A_BANKING_LICENCE)
                        .getTopicTitle();

        Assertions.assertThat(topicTitle).contains(TEST_TEXT_WE_GOT_A_BANKING_LICENCE);
    }
}