package invitro.ui.tests;

import invitro.ui.tags.Bug;
import invitro.ui.testData.FooterData;
import invitro.ui.testData.HeaderData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class HeaderAndFooterTests extends BaseTest {

    @DisplayName("Проверка отображения логотипа компании на странице")
    @Test
    public void logoDisplayTest(){
        step("Проверить отображение логотипа компании", () -> {
            mainPage.checkLogo();
        });
    }

    @DisplayName("Проверка автоматически выбранного города, должен быть:" + " '" + HeaderData.cityMoscow + "'")
    @Test
    void cityNameMoscowTest(){
        step("Проверить, что город был корректно выбран автоматически", () -> {
            mainPage.checkCityName(HeaderData.cityMoscow);
        });
    }

    @DisplayName("Проверка отображения корректного номера телефона, должен быть:" + " '" + HeaderData.phoneNumber + "'")
    @Bug
    @Test
    void phoneNumberTest(){
        step("Проверить, что номер телефона для связи отображается корректно", () -> {
            mainPage.checkPhoneNumber(HeaderData.phoneNumber);
        });
    }

    @DisplayName("Проверка отображения корректного номера телефона для бесплатных звонков, должен быть:" + " '" + HeaderData.freePhoneNumber + "'")
    @Test
    void freePhoneNumberTest(){
        step("Проверить, что бесплатный номер телефона для связи отображается корректно", () -> {
            mainPage.checkFreePhoneNumber(HeaderData.freePhoneNumber);
        });
    }

    @ValueSource(strings = {
            "глюкоза", "впч"
    })
    @ParameterizedTest(name = "Проверка наличия результатов поиска на сайте по слову: {0}")
    void searchTest(String searchText) throws InterruptedException {
        step("Ввести текст для поиска в поле поиска", () -> {
            mainPage.input(searchText);
        });
        step("Нажать кнопку поиска", () -> {
            mainPage.clickSearch();
        });
        step("Проверить, что вспомогательные кнопки поиска отображаются", () -> {
            searchPage.checkSearchResults();
        });
        step("Проверить, что отображаются результаты поиска", () -> {
            searchPage.checkSearchResults();
        });
    }

    @DisplayName("Проверка отображения елементов главного меню хедера")
    @Test
    void headerMainMenuElementsTest(){
        step("Проверить, что все элементы меню отображаются", () -> {
            mainPage.checkHeaderMainMenuElements(HeaderData.expectedHeaderMainMenuElements);
        });
    }

    @DisplayName("Проверка отображения елементов главного меню футера")
    @Test
    void footerMainMenuTest(){
        step("Проскролить страницу вниз до футера", () -> {
                    mainPage.scrollToFooter();
        });
        step("Проверить, что все элементы меню отображаются", () -> {
            mainPage.checkFooterMainMenuElements(FooterData.expectedFooterMainMenuElements);
        });
    }
}
