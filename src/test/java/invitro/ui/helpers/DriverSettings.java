package invitro.ui.helpers;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSettings {
    public static void configure() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=ru-ru");
    }
}
