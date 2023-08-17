package invitro.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/*
Включает header и footer
 */
public class BasePage {
    protected WebDriver driver;

    /*
    Конструктор класса, занимающийся инициализацией полей класса
     */
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /*
    Определение локатора логотипа
     */
    @FindBy(xpath = "//*[@class=\"header-logo\"]")
    private WebElement invitroLogo;

    /*
    Определение локатора элемента с названием выбранного городом
     */
    @FindBy(xpath = "//*[@id=\"city\"]/div/span")
    private WebElement cityName;

    /*
    Определение локатора элемента номера справочно-информационной службы
    */
    @FindBy(xpath = "//*[@id=\"headerPhoneMobile\"]/div/a")
    private WebElement phoneNumber;

    /*
    Определение локатора элемента номера справочно-информационной службы
    */
    @FindBy(xpath = "//*[@id=\"headerPhoneMobile\"]/div[2]/span/a")
    private WebElement freePhoneNumber;

    /*
    Определение локатора элемента поля ввода поиска
    */
    @FindBy(xpath = "//*[@class=\"form-header-search\"]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@class=\"form-header-search\"]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class=\"search-dropdown\"]")
    private WebElement searchDropdown;

    @FindBy(xpath = "//*[@class=\"invitro_footer-menu\"]")
    private WebElement footerMenu;

    @FindBy(xpath = "//*[@class=\"invitro_footer-wrapper\"]")
    private WebElement footerWrapper;
//    WebElement iframe = driver.findElement(By.xpath("//*[@class=\"invitro_footer-wrapper\"]"));


    /*
    Метод проверки отображения логотипа на странице
     */
    public void checkLogo(){
        invitroLogo.isDisplayed();
    }

    /*
    Метод проверки соответствия отображаемого названия города с ожидаемым
     */
    public void checkCityName(String name){
        assertThat(cityName.getText()).isEqualTo(name);
    }

    /*
    Метод проверки соответствия отображаемого номера с ожидаемым
    */
    public void checkPhoneNumber(String number){
        assertThat(phoneNumber.getText()).isEqualTo(number);
    }

    /*
    Метод проверки соответствия отображаемого номера с ожидаемым
    */
    public void checkFreePhoneNumber(String number){
        assertThat(freePhoneNumber.getText()).isEqualTo(number);
    }

    /*
    Метод ввода
    */
    public void input(String searchText){
        searchInput.sendKeys(searchText);
    }

    /*
    Метод нажатия на кнопку поиска
     */
    public void clickSearch(){
        searchButton.click();
    }

    public void checkSearchDropdownIsVisible(){
        assertThat(searchDropdown.getCssValue("visibility")).isEqualTo("visible");
    }

    public void checkHeaderMainMenuElements(List<String> expectedElements){
        List<WebElement> headerMainMenuElements = driver.findElements(By.xpath(".//nav[@id='headerMainMenu']/ul/li[contains(@style,'block')]/a"));
        List<String> headerMainMenuElementsAsString = new ArrayList<>();
        for (WebElement element: headerMainMenuElements){
            String a = element.getText();
            headerMainMenuElementsAsString.add(a);
        }
        assertThat(headerMainMenuElementsAsString).isEqualTo(expectedElements);
    }

    protected void scrollTo(WebElement element){
        new Actions(driver)
                .scrollToElement(element)
                .perform();

    }

    public void scrollToFooter(){
        scrollTo(footerWrapper);
    }

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
