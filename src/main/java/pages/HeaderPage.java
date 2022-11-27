package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderPage {

    private WebDriver driver;

    // Локатор кнопки "Заказать" в хидере
    public By buttonOrderInHeader = By.xpath("//div[@class ='Header_Header__214zg']//button[text()= 'Заказать']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

}
