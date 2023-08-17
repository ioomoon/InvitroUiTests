package invitro.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/*
Описывает header и footer сайта
 */
public class BasePage {
    protected WebDriver driver;

    /**
     * Конструктор класса, занимающийся инициализацией полей класса
     */
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Определение локатора логотипа
     */
    @FindBy(xpath = "//*[@class=\"header-logo\"]")
    private WebElement invitroLogo;

    /**
     * Определение локатора элемента с названием выбранного городом
     */
    @FindBy(xpath = "//*[@id=\"city\"]/div/span")
    private WebElement cityName;

    /**
     * Определение локатора элемента номера справочно-информационной службы
     */
    @FindBy(xpath = "//*[@id=\"headerPhone\"]/div/a")
    private WebElement phoneNumber;

    /**
     * Определение локатора элемента бесплатного номера справочно-информационной службы
     */
    @FindBy(xpath = "//*[@id=\"headerPhone\"]/div[2]/span/a")
    private WebElement freePhoneNumber;

    /**
     * Определение локатора элемента поля ввода поиска
     */
    @FindBy(xpath = "//*[@class=\"form-header-search\"]/input")
    private WebElement searchInput;

    /**
     * Определение локатора элемента кнопки поиска
     */
    @FindBy(xpath = "//*[@class=\"form-header-search\"]/button")
    private WebElement searchButton;

    /**
     * Определение локатора элемента нижнего меню
     */
    @FindBy(xpath = "//*[@class=\"invitro_footer-menu\"]")
    private WebElement footerMenu;

    /**
     * Определение локатора элемента обертки футтера
     */
    @FindBy(xpath = "//*[@class=\"invitro_footer-wrapper\"]")
    private WebElement footerWrapper;

    /**
     * Проверка отображения логотипа на странице
     */
    public void checkLogo(){
        invitroLogo.isDisplayed();
    }

    /**
     * Проверка соответствия отображаемого названия города с ожидаемым
     */
    public void checkCityName(String name){
        assertThat(cityName.getText()).isEqualTo(name);
    }

    /**
     * Проверка соответствия отображаемого номера телефона с ожидаемым
     */
    public void checkPhoneNumber(String number){
        assertThat(phoneNumber.getText()).isEqualTo(number);
    }

    /**
     * * Проверка соответствия отображаемого бесплатного номера телефона с ожидаемым
     */
    public void checkFreePhoneNumber(String number){
        assertThat(freePhoneNumber.getText()).isEqualTo(number);
    }

    /**
     * Ввод текста в строку поиска
     * @param searchText Текст для ввода в поисковую строку
     */
    public void input(String searchText){
        searchInput.sendKeys(searchText);
    }

    /**
     * Нажатие на кнопку поиска
     */
    public void clickSearch(){
        searchButton.click();
    }

    /**
     * Проверка отображения элементов главного верхнего меню
     * @param expectedElements Список строк с ожидаемыми названиями элементов меню
     */
    public void checkHeaderMainMenuElements(List<String> expectedElements){
        List<WebElement> headerMainMenuElements = driver.findElements(By.xpath(".//nav[@id='headerMainMenu']/ul/li[contains(@style,'block')]/a"));
        List<String> headerMainMenuElementsAsString = new ArrayList<>();
        for (WebElement element: headerMainMenuElements){
            String a = element.getText();
            headerMainMenuElementsAsString.add(a);
        }
        assertThat(headerMainMenuElementsAsString).isEqualTo(expectedElements);
    }

    /**
     * Скрол до элемента на странице
     * @param element Элемент, до которого будет произведен скрол
     */
    protected void scrollTo(WebElement element){
        new Actions(driver)
                .scrollToElement(element)
                .perform();

    }

    /**
     * Скрола до футтера сайта
     */
    public void scrollToFooter(){
        scrollTo(footerWrapper);
    }

    /**
     * Проверка отображения элементов главного нижнего меню
     * @param expectedElements Список строк с ожидаемыми названиями элементов меню
     */
    public void checkFooterMainMenuElements(List<String> expectedElements){
        List<WebElement> footerMainMenuElements = driver.findElements(By.xpath(".//*[@id=\"footerMenu\"]/div/div/a"));
        List<String> footerMainMenuElementsAsString = new ArrayList<>();
        for (WebElement element: footerMainMenuElements){
            String a = element.getText();
            footerMainMenuElementsAsString.add(a);
        }
        assertThat(footerMainMenuElementsAsString).isEqualTo(expectedElements);
    }



}
