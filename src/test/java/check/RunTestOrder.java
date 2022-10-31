package check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import pageobject.HomePage;
import pageobject.OrderPage;
import steps.Profile;
import services.Service;

@RunWith(Parameterized.class)
public class RunTestOrder {

    public ChromeDriver driver;


    public Service objService;
    public OrderPage objOrderPage;
    public HomePage objHomePage;
    public Profile objProfile;

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String comment;
    private final By clickOrderButton;

    public RunTestOrder(String name, String surname, String address, String phoneNumber, String station, String comment, By clickOrderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.comment = comment;
        this.clickOrderButton = clickOrderButton;
    }


    @Parameterized.Parameters

    public static Object[][] getData() {
        HomePage homePage = new HomePage();
        return new Object[][]{
                {"Антон", "Чехов", "119049, г Москва, ул Донская, д 18", "89001002030", "Сокол", "Комментарий в тесте № 1", homePage.ORDER_BUTTON_TOP},
                {"Александр", "Пушкин", "101000, г Москва, ул Пушкина, д 7", "+79991002039", "Лубянка", " Комментарий в тесте № 2", homePage.ORDER_BUTTON_DOWN}
        };

    }

    @Before
    public void setUpOrder() {
        driver = new ChromeDriver();

        objOrderPage = new OrderPage(driver);
        objHomePage = new HomePage(driver);
        objProfile = new Profile(driver);
        objService = new Service(driver);

        System.out.println("test start");

        objService.inInputWebsite()
                .click(objHomePage.getCookie())
                .waitPageElement(objHomePage.getImage());
    }


    @Test // Создание заказа
    public void checkingOrderCompletion() {

        objService.click(clickOrderButton);
        objProfile.profileData(name, surname, address, phoneNumber, station);
        objService.click(objOrderPage.getNextButton());
        objProfile.orderrer();
        objService.click(objOrderPage.getColorScooter())
                .inputText(objOrderPage.getComment(), comment)
                .click((objOrderPage.getOrderButton()))
                .click((objOrderPage.getPlaceAnOrderYes()));

        assertTrue("Отсутствует сообщение об успешном завершении заказа",
                objService.isElementPresent(objOrderPage.ORDER_PLACED_HEADER));

    }

    @After
    public void teardown() {
        System.out.println("test close");
        driver.quit();

    }
}