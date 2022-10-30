package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// Класс содержит локаторы и вебэлементы главной странице
public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) { this.driver = driver; }

    // Локаторы на главной странице
    private final By cookie = By.id("rcc-confirm-button");  // кнопка закрыть куки
    private final By img = By.xpath("//img[@alt='Scooter blueprint']"); // элемент на главной станице картинка
    private final By modQuest = By.xpath("//div[text() = 'Вопросы о важном']"); // элемент заголовка Вопросы о важном
    private final By orderedTop = By.className("Button_Button__ra12g"); // кнопка заказать вверху сайта
    private final By orderedDown = By.xpath("//button[contains(@class, 'Button_Middle')]"); // кнопка заказать внизу сайта

    // Локаторы из списка вопросов и ответов
    private final By listQuestions = By.xpath("//*[@class='accordion__button']"); // элемент вопросов
    private final By listAnswer = By.xpath("//div[@data-accordion-component='AccordionItemPanel']"); // элемент ответов



    // Преобразование локаторов в вебэлементы
    public By getImg() {
        return img;
    }
    public WebElement getCookie() {
        return driver.findElement(cookie);
    }
    public WebElement getmodQuest() {
        return driver.findElement(modQuest);
    }
    public WebElement getOrderedTop() { return driver.findElement(orderedTop); }
    public WebElement getOrderedDown() { return driver.findElement(orderedDown); }

    // Коллекция из элементов вопросов
    public List<WebElement> getListQuestions() {
        return driver.findElements(listQuestions);
    }

    // Коллекция из элементов ответов
    public List<WebElement> getListAnswer() {
        return driver.findElements(listAnswer);
    }

}