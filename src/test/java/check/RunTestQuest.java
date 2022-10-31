package check;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;
import services.Service;


import java.time.Duration;

import static org.junit.matchers.JUnitMatchers.containsString;

@RunWith(Parameterized.class)
public class RunTestQuest {

    public static ChromeDriver driver;

    public static HomePage objHomePage;
    public static Service objService;

    private final String checkedText;
    private final int index;

    public RunTestQuest(String checkedText, int index) {
        this.checkedText = checkedText;
        this.index = index;


    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Оплата курьеру — наличными или картой.", 0},
                {"можете просто сделать несколько заказов — один за другим.", 1},
                {"Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Зарядка не понадобится.", 5},
                {"Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"И Москве, и Московской области.", 7},

        };
    }

    //Выполнится окрытие браузера и вход на сайт, перемещение к блоку вопросов
    @BeforeClass
    public static void globalSetup() {

        driver = new ChromeDriver();
        objService = new Service(driver);
        objHomePage = new HomePage(driver);
        objService.inInputWebsite();
        objService.click(objHomePage.getCookie());
        objService.click(objHomePage.getModQuest());

    }


    // коллекция тестов для проверки блока Вопросы о важном
    @Test
    public void checkingQuestions() {
        objService.click(objHomePage.getListQuestions().get(index));
        Assert.assertThat("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(index).getText(), containsString(checkedText));
    }

    @AfterClass
    public static void teardown() {
        System.out.println("test close");
        driver.quit();
    }
}