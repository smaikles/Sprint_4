package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// Класс содержит локаторы и вебэлементы для оформления заказа
public class OrderPage {
    private WebDriver driver;


    // Локаторы для проверки второго сценария
    private final By titleOrder = By.xpath("//div[(text()= 'Для кого самокат')]"); // элемент страницы заполнения данных
    private final By titleRent = By.xpath("//div[(text()= 'Про аренду')]"); // элемент страницы заполнения данных
    private final By name = By.xpath("//input[@placeholder ='* Имя']"); // поле имя
    private final By surname = By.xpath("//input[@placeholder ='* Фамилия']"); // поле фамилия
    private final By address = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']"); // поле адреса
    private final By station = By.xpath("//input[@placeholder ='* Станция метро']"); // поле метро
    private final By phoneNumber = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']"); // поле телефон
    private final By calendar = By.xpath("//input[@placeholder ='* Когда привезти самокат']"); // поле календаря
    private final By date = By.xpath("//div[contains(@class, 'day--today')]"); // поле выбора даты доставки
    private final By leaseTime = By.className("Dropdown-placeholder"); // элемент выбора срока аренды
    private final By RentalTimeOneDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']"); // элемнт выбора срока аренды
    private final By greyScooter = By.id("grey"); // элемент выбора цвета
    private final By comment = By.xpath("//input[@placeholder ='Комментарий для курьера']"); // поле коментария
    private final By next = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // кнопка далее
    private final By order = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]"); // кнопка заказать
    private final By placeAnOrderYes = By.xpath("//button[contains(text(), 'Да')]"); // кнопка подтверждения заказа
    public final By orderPlaced = By.xpath("//div[(text()= 'Заказ оформлен')]");  // элемент страницы подтвержденного заказа

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    // Преобразование локаторов в вебэлементы
    public WebElement getName() {
        return driver.findElement(name);
    }

    public WebElement getSurname() {
        return driver.findElement(surname);
    }

    public WebElement getAddress() {
        return driver.findElement(address);
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(phoneNumber);
    }

    public WebElement getStation() {
        return driver.findElement(station);
    }

    public WebElement getCalendar() {
        return driver.findElement(calendar);
    }

    public WebElement getDate() {
        return driver.findElement(date);
    }

    public WebElement getLeaseTime() {
        return driver.findElement(leaseTime);
    }

    public WebElement getRentalTimeOneDay() {
        return driver.findElement(RentalTimeOneDay);
    }

    public WebElement getGreyScooter() {
        return driver.findElement(greyScooter);
    }

    public WebElement getComment() {
        return driver.findElement(comment);
    }

    public WebElement getNext() {
        return driver.findElement(next);
    }

    public WebElement getOrder() {
        return driver.findElement(order);
    }

    public WebElement getPlaceAnOrderYes() {
        return driver.findElement(placeAnOrderYes);
    }

    public By getTitleOrder() {
        return titleOrder;
    }

    public By getTitleRent() {
        return titleRent;
    }

}