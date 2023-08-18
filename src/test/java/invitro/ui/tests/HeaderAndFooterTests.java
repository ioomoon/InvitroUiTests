package invitro.ui.tests;

import invitro.ui.data.FooterData;
import invitro.ui.data.HeaderData;
import invitro.ui.tests.helpers.AllureAttachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class HeaderAndFooterTests extends BaseTest {

    @DisplayName("Проверка отображения логотипа компании на странице")
    @Tag("Smoke")
    @Test
    public void logoDisplayTest(){
        step("Проверить отображение логотипа компании", () -> {
            AllureAttachment.takeScreenshot();
            mainPage.checkLogo();
        });
    }

    @DisplayName("Проверка автоматически выбранного города, должен быть:" + " '" + HeaderData.cityMoscow + "'")
    @Tag("Smoke")
    @Test
    void cityNameMoscowTest(){
        step("Проверить, что город был корректно выбран автоматически", () -> {
            AllureAttachment.takeScreenshot();
            mainPage.checkCityName(HeaderData.cityMoscow);
        });
    }

    @DisplayName("Проверка отображения корректного номера телефона, должен быть:" + " '" + HeaderData.phoneNumber + "'")
    @Tag("Bug")
    @Test
    void phoneNumberTest(){
        step("Проверить, что номер телефона для связи отображается корректно", () -> {
            AllureAttachment.takeScreenshot();
            mainPage.checkPhoneNumber(HeaderData.phoneNumber);
        });
    }

    @DisplayName("Проверка отображения корректного номера телефона для бесплатных звонков, должен быть:" + " '" + HeaderData.freePhoneNumber + "'")
    @Tag("Smoke")
    @Test
    void freePhoneNumberTest(){
        step("Проверить, что бесплатный номер телефона для связи отображается корректно", () -> {
            AllureAttachment.takeScreenshot();
            mainPage.checkFreePhoneNumber(HeaderData.freePhoneNumber);
        });
    }

    @Tag("Smoke")
    @ValueSource(strings = {
            "глюкоза", "впч"
    })
    @ParameterizedTest(name = "Проверка наличия результатов поиска на сайте по слову: {0}")
    void searchTest(String searchText) {
        step("Ввести текст для поиска в поле поиска", () -> {
            mainPage.input(searchText);
            AllureAttachment.takeScreenshot();
        });
        step("Нажать кнопку поиска", () -> {
            mainPage.clickSearch();
        });
        step("Проверить, что вспомогательные кнопки поиска отображаются", () -> {
            AllureAttachment.takeScreenshot();
            searchPage.checkSearchResults();
        });
        step("Проверить, что отображаются результаты поиска", () -> {
            searchPage.checkSearchResults();
        });
    }

    @DisplayName("Проверка отображения элементов главного меню хедера")
    @Tag("Smoke")
    @Test
    void headerMainMenuElementsTest(){
        step("Проверить, что все элементы меню отображаются", () -> {
            AllureAttachment.takeScreenshot();
            mainPage.checkHeaderMainMenuElements(HeaderData.expectedHeaderMainMenuElements);
        });
    }

    @DisplayName("Проверка отображения элементов главного меню футера")
    @Tag("Smoke")
    @Test
    void footerMainMenuTest(){
        step("Проскролить страницу вниз до футера", () -> {
            mainPage.scrollToFooter();
            AllureAttachment.takeScreenshot();
        });
        step("Проверить, что все элементы меню отображаются", () -> {
            mainPage.checkFooterMainMenuElements(FooterData.expectedFooterMainMenuElements);
        });
    }
}
