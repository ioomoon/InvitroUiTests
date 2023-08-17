package invitro.ui.tests;

import invitro.ui.helpers.DriverSettings;
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

    public static WebDriver driver = new ChromeDriver();

    public static MainPage mainPage = new MainPage(driver);
    public static SearchPage searchPage = new SearchPage(driver);

    static final String cityMoscow = "Москва";
    static final String phoneNumber = "8 (495) 363-0-364";
    static final String freePhoneNumber = "8 (800) 200-363-0";

    static final List<String> expectedHeaderMainMenuElements = Arrays.asList("Анализы", "Запись к врачу", "Врачи", "Акции", "Адреса", "Медицинские услуги", "Выезд на дом");

    @BeforeAll
    static void beforeAll() {
//        DriverSettings.configure(driver);
        System.out.println("Тесты пошли!");
        driver.get(baseURL);
        mainPage.checkLogo();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Тест пошел!");
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

    @AfterEach
    void afterEach() {
        System.out.println("Тест прошел!");
    }
}
