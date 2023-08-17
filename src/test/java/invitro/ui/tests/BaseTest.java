package invitro.ui.tests;

import invitro.ui.pages.MainPage;
import invitro.ui.pages.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;


public class BaseTest {
    static final String baseURL = "https://www.invitro.ru/";
    static final String baseTitle = "Медицинская компания ИНВИТРО. Клинико-диагностические лаборатории";

    public static WebDriver driver = new ChromeDriver(setUp());

    public static MainPage mainPage = new MainPage(driver);
    public static SearchPage searchPage = new SearchPage(driver);

    static final String cityMoscow = "Москва";
    static final String phoneNumber = "8 (495) 363-0-364";
    static final String freePhoneNumber = "8 (800) 200-363-0";

    static final List<String> expectedHeaderMainMenuElements = Arrays.asList("Анализы",
            "Запись к врачу",
            "Врачи",
            "Акции",
            "Адреса",
            "Медицинские услуги",
            "Выезд на дом");
    static final List<String> expectedFooterMainMenuElements = Arrays.asList("Медицинские услуги",
            "Комплексные обследования",
            "Запись к врачу",
            "О врачах",
            "Выезд на дом",
            "Адреса медицинских офисов",
            "Библиотека пациента",
            "Вопрос врачу",
            "Об ИНВИТРО",
            "Партнеры",
            "Вакансии",
            "Клиники-партнеры",
            "Юридическая информация",
            "Программа лояльности",
            "Клинические исследования",
            "Результаты СОУТ");

    @BeforeAll
    static void beforeAll() {
        driver.get(baseURL);
        mainPage.checkLogo();
    }

    @BeforeEach
    void beforeEach() {
        if (!driver.getTitle().equals(baseTitle)) {
            driver.get(baseURL);
        }
    }

    @AfterAll
    static void afterAll() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    private static ChromeOptions setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        return options;
    }
}
