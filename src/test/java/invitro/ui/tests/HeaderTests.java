package invitro.ui.tests;

import invitro.ui.tags.Bug;
import invitro.ui.tests.steps.AllureSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static io.qameta.allure.Allure.step;

@DisplayName("Тестирование хедера")
public class HeaderTests extends BaseTest {

    @DisplayName("Проверка отображения логотипа компании на странице")
    @Test
    public void logoDisplayTest(){
        step("Проверить отображение логотипа компании", () -> {
            mainPage.checkLogo();
            AllureSteps.takeScreenshot();
        });
    }

    @DisplayName("Проверка автоматически выбранного города, должен быть:" + " '" + cityMoscow + "'")
    @Test
    void cityNameMoscowTest(){
        step("Проверить, что город был корректно выбран автоматически", () -> {
            mainPage.checkCityName(cityMoscow);
            AllureSteps.takeScreenshot();
        });
    }

    @DisplayName("Проверка отображения корректного номера телефона, должен быть:" + " '" + phoneNumber + "'")
    @Bug
    @Test
    void phoneNumberTest(){
        step("Проверить, что номер телефона для связи отображается корректно", () -> {
            mainPage.checkPhoneNumber(phoneNumber);
            AllureSteps.takeScreenshot();
        });
    }

    @DisplayName("Проверка отображения корректного номера телефона для бесплатных звонков, должен быть:" + " '" + freePhoneNumber + "'")
    @Test
    void freePhoneNumberTest(){
        step("Проверить, что бесплатный номер телефона для связи отображается корректно", () -> {
            mainPage.checkFreePhoneNumber(freePhoneNumber);
            AllureSteps.takeScreenshot();
        });
    }

    @ValueSource(strings = {
            "глюкоза", "впч"
    })
    @ParameterizedTest(name = "Проверка наличия результатов поиска на сайте по слову: {0}")
    void searchTest(String searchText) throws InterruptedException {
        step("Ввести текст для поиска в поле поиска", () -> {
            mainPage.input(searchText);
            AllureSteps.takeScreenshot();
        });
        step("Проверить, что при вводе текста в окно поиска появился dropdown с подсказками", () -> {
            mainPage.checkSearchDropdownIsVisible();
            AllureSteps.takeScreenshot();
        });
        step("Нажать кнопку поиска", () -> {
            mainPage.clickSearch();
            AllureSteps.takeScreenshot();
        });
        //TODO доделать поиск
    }



    /*
    Набор тестов:
    1 Проверка отображения логотипа на странице
    2 Проверка города
    3 Проверка номеров телефонов
    4 Проверка поиска
    5 Проверка отображения элементов мидл-хеадера
    6 Проверка элементов футер-меню
     */
}
