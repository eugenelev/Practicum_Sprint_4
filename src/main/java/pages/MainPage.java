package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage{


    private static WebDriver driver;

    // Локатор кнопки принятия кук
    public By acceptCookies = By.xpath("//button[contains(text(), 'да все привыкли')]");

    // Локатор секции "Вовпросы о важном"
    public By sectionQuestionAboutImportant = By.xpath(".//*[@class= 'Home_SubHeader__zwi_E' and text()='Вопросы о важном']");


    // Id для вопроса (текст-стрелка), который раскрывает панель с ответом на вопрос'
    public String itemImportantQuestionInList = "accordion__heading-%s";

    // Id с ответом на вопрос
    public String answerOnTheImportantQuestion = "accordion__panel-%s";

    // Кнопка заказать расположенная на главной странице
    public By buttonOrderOnMainPage = By.xpath("//div[starts-with(@class,'Home_FinishButton')]/button[text()='Заказать']");


    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    // Метод позволяет проскроллить до нужного элемента.
    // По хорошему его стоит вынести в отельный класс, т.к. будет часто переиспользоваться на других страницах
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOneOfTheQuestions(String numberOfQuestion) {
        driver.findElement(By.id(String.format(itemImportantQuestionInList, numberOfQuestion))).click();
        driver.findElement(By.id(String.format(itemImportantQuestionInList, numberOfQuestion))).isDisplayed();
    }

    public String getTextFromElement(String answerOfQuestion) {
        return driver.findElement(By.id(String.format(answerOnTheImportantQuestion, answerOfQuestion))).getText();
    }

    // Клик на кнопку Зазкать расположенную на главной странице
    public void clickButtonOrder() {
        driver.findElement(buttonOrderOnMainPage).click();

    }


    public void clickAcceptCookies() {
        driver.findElement(acceptCookies).click();

    }






}
