package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class OrderPage {

    private WebDriver driver;

    // Общая часть локатора полей на форме заказа
    public final String InputContainer = "//input[@placeholder = '* %s']";

    // Элементы в списке периодов аренды
    public final String valuesFromListRentalPeriod = "//div[@class='Dropdown-option'][%d]";

    // Поле - Имя
    public By fieldName = By.xpath(String.format(InputContainer, "Имя"));

    // Поле - Фамилия
    public By fieldSurname = By.xpath(String.format(InputContainer, "Фамилия"));

    // Поле - Адрес
    public By fieldAddress = By.xpath(String.format(InputContainer, "Адрес: куда привезти заказ"));

    // Поле - Телефонный номер
    public By fieldPhoneNumber = By.xpath(String.format(InputContainer, "Телефон: на него позвонит курьер"));

    // Поле - Метро
    public By fieldMetro = By.xpath(String.format(InputContainer, "Станция метро"));;

    // Поле - Когда привезти самокат
    public By deliveryDate = By.xpath(String.format(InputContainer, "Когда привезти самокат"));;

    // Поле - Период аренды
    public By rentalPeriod = By.xpath("//span[@class='Dropdown-arrow']");


    // Кнопка - Далее на форме заказа
    public By buttonNext = By.xpath("//button[text() = 'Далее']");;

    //Текущая дата в календаре
    public By currentDateInCalendar = By.xpath("//div[@tabindex = '0' and starts-with(@class, 'react-datepicker__day')]");

    // Локатор цвет-самоката
    public final String colorOfSamokat = ".//input[@id = '%s']";

    //Кнопка "Заказать" под формой заказа
    public By buttonOrder = By.xpath("//div[starts-with(@class,'Order_Buttons')]/button[text()='Заказать']");

    //Кнопка Да в модальном окне "Вы хотите оформит заказ?"
    public By buttonYes = By.xpath("//div[starts-with(@class,'Order_Modal')]//div/button[text()='Да']");

    // Меню с вариантами выбора длительности проката
    public By menuWithOptionsRentalPeriod = By.xpath("//div[@class='Dropdown-menu']");

    // Модальное окно из которого вытаскиваем текст, например Статус заказа
    public By succesfullStatusOrder = By.xpath("//div[starts-with(@class,'Order_ModalHeader')]");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод заполнения поля - Имя
    public void setName(String name) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
    }

    // Метод заполнения поля - Фамилия
    public void setSurname(String surname) {
        driver.findElement(fieldSurname).click();
        driver.findElement(fieldSurname).clear();
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    // Метод заполнения поля - Адрес
    public void setAddress(String address) {
        driver.findElement(fieldAddress).click();
        driver.findElement(fieldAddress).clear();
        driver.findElement(fieldAddress).sendKeys(address);
    }

    // Метод заполнения поля - Метро
    public void setMetro(String metro) {
        driver.findElement(fieldMetro).click();
        driver.findElement(fieldMetro).sendKeys(metro, Keys.ARROW_DOWN, Keys.RETURN);;


    }

    // Метод заполнения поля - Телефонный номер
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(fieldPhoneNumber).click();
        driver.findElement(fieldPhoneNumber).clear();
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    // Один метод для заполнения всей формы заказа
    public void feelOnTheAllFieldInOrder(String name, String surname, String address, String metro, String phoneNumber, Integer option){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setPhoneNumber(phoneNumber);
        clickButtonNext();
        chooseDeliveryDate();
        chooseRentalPeriod(option);
        clickOrderButton();
        driver.findElement(buttonYes).click();
    }

    // Метод нажатия на кнопку Далее на форме заказа
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    // Метод выбора доставки
    public void chooseDeliveryDate() {
        driver.findElement(deliveryDate).click();
        driver.findElement(currentDateInCalendar).click();

    }

    // Метод выбора срока аренды
    public void chooseRentalPeriod(Integer option){
        driver.findElement(rentalPeriod).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(menuWithOptionsRentalPeriod));
        driver.findElement(By.xpath(String.format(valuesFromListRentalPeriod, option))).click();
    }

    //Нажатие кнопки Заказать
    public void clickOrderButton() {
        driver.findElement(buttonOrder).click();
    }

    // Получаем заголовок из диалогового окна
    public String getStatusOrder() {
        String[] result = driver.findElement(succesfullStatusOrder).getText().split("\n", 2);
        return result[0];
    }



}
