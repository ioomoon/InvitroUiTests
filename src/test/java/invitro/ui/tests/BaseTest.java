package invitro.ui.tests;

import invitro.ui.pages.MainPage;
import invitro.ui.pages.SearchPage;
import invitro.ui.tests.helpers.AllureAttachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    static final String baseURL = "https://www.invitro.ru/";
    static final String baseTitle = "Медицинская компания ИНВИТРО. Клинико-диагностические лаборатории";

    public static WebDriver driver = new ChromeDriver(setUp());

    public static MainPage mainPage = new MainPage(driver);
    public static SearchPage searchPage = new SearchPage(driver);

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
