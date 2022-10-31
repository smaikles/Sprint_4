package services;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public  class InitDriver {
   // public static ChromeDriver driver;
   public static WebDriver driver;


    @Before
    public void setDriver() {
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
         System.setProperty("webdriver.gecko.driver",  "src/main/resources/drivers/geckodriver.exe");
      //   driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        System.out.println("test close");
        driver.quit();

    }
}
