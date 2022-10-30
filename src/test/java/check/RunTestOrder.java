package check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
    private final String orderButton;

    public RunTestOrder(String name, String surname, String address, String phoneNumber, String station, String comment, String orderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.comment = comment;
        this.orderButton = orderButton;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Антон", "Чехов", "119049, г Москва, ул Донская, д 18", "89001002030", "Сокол", "Комментарий в тесте № 1", "Заказ вверху"},
                {"Александр", "Пушкин", "101000, г Москва, ул Пушкина, д 7", "+79991002039", "Лубянка", " Комментарий в тесте № 2", "Заказ внизу"}
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

        objService.InInput()
                .click(objHomePage.getCookie())
                .waitPageElement(objHomePage.getImg());
    }


    @Test // Создание заказа
    public void orderIn() {

        if (orderButton.equals("Заказ вверху")) {
            objService.click(objHomePage.getOrderedTop());
        } else {
            objService.click(objHomePage.getOrderedDown());
        }

        objProfile.profileData(name, surname, address, phoneNumber, station);
        objService.click(objOrderPage.getNext());
        objProfile.Orderrer();
        objService.click(objOrderPage.getGreyScooter())
                .inputText(objOrderPage.getComment(), comment)
                .click((objOrderPage.getOrder()))
                .click((objOrderPage.getPlaceAnOrderYes()));

        assertTrue("Отсутствует сообщение об успешном завершении заказа",
                objService.isElementPresent(objOrderPage.orderPlaced));

    }

    @After
    public void teardown() {
        System.out.println("test close");
        driver.quit();

    }
}