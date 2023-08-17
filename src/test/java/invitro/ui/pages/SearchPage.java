package invitro.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Определение локатора контейнера с вспомогательными кнопками поиска
     */
    @FindBy(xpath = "//*[@class=\"search__button-container\"]")
    private WebElement searchButtonResults;

    /**
     * Определение локатора контейнера с результатами поиска
     */
    @FindBy(xpath = "//*[@class=\"search__results\"]")
    private WebElement searchResults;

    /**
     * Проверка отображения контейнера с вспомогательными кнопками поиска
     */
    public void checkSearchButtonResults(){
        searchButtonResults.isDisplayed();
    }

    /**
     * Проверка отображения контейнера с вспомогательными кнопками поиска
     */
    public void checkSearchResults(){
        searchResults.isDisplayed();
    }

}
