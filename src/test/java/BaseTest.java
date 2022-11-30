import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.BaseClass;

import java.util.concurrent.TimeUnit;

public class BaseTest extends BaseClass {


    @Before
    public void setUp() {
        WebDriver driver = getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
      driver.manage().addCookie(new Cookie("Cartoshka", "true"));
      driver.manage().addCookie(new Cookie("Cartoshka-legacy", "true"));
    }

    @After
    public void tearDown() {
// Закрыть браузер
        driver.quit();
    }




}
