package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;


public class BaseClass {

    public final String URL = "https://qa-scooter.praktikum-services.ru/";

    public WebDriver driver;



    public WebDriver getDriver(String name){
        if (Objects.equals(name, "chrome")){
            driver = new ChromeDriver();
        } if (Objects.equals(name, "firefox")) {
            driver = new FirefoxDriver();
        }

        return driver;

    }
}
