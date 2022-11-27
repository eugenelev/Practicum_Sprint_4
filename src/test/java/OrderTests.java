import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderPage;
import pages.MainPage;
import pages.OrderPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;



public class OrderTests {

    private final String STATUS_ORDER_TEXT = "Заказ оформлен";

    private WebDriver driver;

//    @Before
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://qa-scooter.praktikum-services.ru/");
        // ПОЧЕМУ КАРТОШКА УСТАНАВЛИВАЕТСЯ, НО ОКНО С ПРИНЯТИЕМ КУК ВСЕ РАВНО ВЫЛЕЗХАЕТ? ЧТО ДЕЛАЮ НЕ ТАК?
//      driver.manage().addCookie(new Cookie("Cartoshka", "true"));
//      driver.manage().addCookie(new Cookie("Cartoshka-legacy", "true"));
//        driver.findElement(By.xpath("//button[contains(text(), 'да все привыкли')]")).click();
//    }


    @Test
    public void checkSuccesfullOrderOfSamokat_Chrome() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath("//button[contains(text(), 'да все привыкли')]")).click();
        OrderPage orderPage = new OrderPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        driver.findElement(headerPage.buttonOrderInHeader).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPage.fieldName));
        orderPage.feelOnTheAllFieldInOrder("Илон", "Маск", "МОСКВА", "черкизовская", "79111234567", 1);
        assertEquals(STATUS_ORDER_TEXT, orderPage.getStatusOrder());
    }


    @Test
    public void checkSuccesfullOrderOfSamokat_Firefox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath("//button[contains(text(), 'да все привыкли')]")).click();
        OrderPage orderPage = new OrderPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        driver.findElement(headerPage.buttonOrderInHeader).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPage.fieldName));
        orderPage.feelOnTheAllFieldInOrder("Алексей", "Кондрашов", "Санкт-Петербург", "сокольники", "89111234567", 3);
        assertEquals(STATUS_ORDER_TEXT, orderPage.getStatusOrder());

    }

    @Test
    public void moveToOrderPageByButtonOrderFromCentreOfPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.findElement(By.xpath("//button[contains(text(), 'да все привыкли')]")).click();
        driver.findElement(mainPage.buttonOrderOnMainPage).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPage.fieldName));
        assertEquals("https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());





    }


    @After
    public void tearDown() {
// Закрыть браузер
        driver.quit();
    }
}


