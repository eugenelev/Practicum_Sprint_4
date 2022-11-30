import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderPage;
import pages.MainPage;
import pages.OrderPage;
import static org.junit.Assert.assertEquals;



public class OrderTests  extends BaseTest {

    private static final String STATUS_ORDER_TEXT = "Заказ оформлен";


    @Test
    public void checkSuccesfullOrderOfSamokat() {
        OrderPage orderPage = new OrderPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        driver.findElement(headerPage.buttonOrderInHeader).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPage.fieldName));
        orderPage.feelOnTheAllFieldInOrder("Илон", "Маск", "МОСКВА", "Черкизовская", "79111234567", 1);
        assertEquals(STATUS_ORDER_TEXT, orderPage.getStatusOrder());
    }


    @Test
    public void moveToOrderPageByButtonOrderFromCentreOfPage() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.findElement(mainPage.buttonOrderOnMainPage).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPage.fieldName));
        assertEquals("https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());





    }
}


