package invitro.ui.tests;

import invitro.ui.helpers.DriverSettings;
import invitro.ui.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    static final String baseURL = "https://www.invitro.ru/";

    public static WebDriver driver = new ChromeDriver();

    public static MainPage mainPage = new MainPage(driver);

    static final String cityMoscow = "Москва";
    static final String phoneNumber = "8 (495) 363-0-364";
    static final String freePhoneNumber = "8 (800) 200-363-0";

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
        System.out.println("Тесты пошли!");
        driver.get(baseURL);
        mainPage.checkLogo();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Тест пошел!");
        driver.get(baseURL);
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
