import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Owner("Maksim QA")
@Epic("Skillfaktory Test")
public class WebTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://skillfactory.ru");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @Story("Тест1")
    @DisplayName("Проверка наличия логотипоа Skillfaktory")
    public void logoTest() {
        HomePage data = new HomePage(driver);
        assertTrue(data.logoPresent());
    }

    @Test
    @Story("Тест2")
    @DisplayName("Проверка названия слогана")
    public void blockNameTest() {
        HomePage data = new HomePage(driver);
        assertEquals("Обучаться\nIT‑профессиям — в ваших интересах", data.getSloganTitle());
    }

    @Test
    @Story("Тест3")
    @DisplayName("Проверка наличия фонового рисунка")
    public void backgroundPictureTest() {
        HomePage data = new HomePage(driver);
        assertTrue(data.background());
    }

    @Test
    @Story("Тест4")
    @DisplayName("Проверка на переход и возврат на стартовую страницу через клик по иконке компании")
    public void backStartPageTest() {
        HomePage data = new HomePage(driver);
        data.backStartPage();
    }

    @Test
    @Story("Тест5")
    @DisplayName("Проверка наличия изображения карточек курсов")
    public void paymentTest() {
        HomePage data = new HomePage(driver);
        assertFalse(data.getCards().isEmpty());
    }

    @Test
    @Story("Тест6")
    @DisplayName("Проверка наличия ссылки")
    public void linkTest() {
        HomePage data = new HomePage(driver);
        assertEquals("https://skillfactory.ru/courses", data.movingToLink());
    }

    @Test
    @Story("Тест7")
    @DisplayName("Проверка работы ссылки и написание заголовка страницы")
    public void checkMainPageLinksProforientaciyaTest() {
        HomePage data = new HomePage(driver);
        data.goToProforientaciyaPageAndCheck();
    }

    @Test
    @Story("Тест8")
    @DisplayName("Проверка работы ссылки на форму регистрации")
    public void openPartnerRegistrationFormaTest() {
        HomePage data = new HomePage(driver);
        data.openPartnerRegistrationForm();
    }

    @Test
    @Story("Тест9")
    @DisplayName("Проверка работы теста выбора профессии")
    public void hrefFreeTest() {
        HomePage data = new HomePage(driver);
        data.goHrefTest();
    }

    @Test
    @Story("Тест10")
    @DisplayName("Проверка работы стрелок прокрутки")
    public void ClickableButtonTest() {
        HomePage data = new HomePage(driver);
        data.clikableRight();
    }

    @Test
    @Story("Тест11")
    @DisplayName("Проверка ссылки на открытие формы оставить заявку")
    public void OpenFormTest() {
        HomePage data = new HomePage(driver);
        data.openFormChoise();
    }

    @Test
    @Story("Тест12")
    @DisplayName("Проверка на открытие формы IT-рентген")
    public void OpenFormITrentgenTest() {
        HomePage data = new HomePage(driver);
        data.openFormITrentgen();
    }

    @Test
    @Story("Тест13")
    @DisplayName("Проверка негативного сценария заполнения формы IT-рентген на примере неправильной почты")
    public void formITRentgenTest() {
        HomePage data = new HomePage(driver);
        data.fillFormITrentgen("1", "(900) 000-00-00");
        String error = driver.findElement(data.getErrorTextEmail).getText();
        assertEquals("Укажите, пожалуйста, корректный email", error);
    }

    @Test
    @Story("Тест14")
    @DisplayName("Проверка негативного сценария заполнения формы IT-рентген с пустыми полями")
    public void formITRentgenEmptyTest() {
        HomePage data = new HomePage(driver);
        data.fillFormITrentgen("", "");
        String errorEmp = driver.findElement(data.getErrorTextEmpty).getText();
        assertEquals("Пожалуйста, заполните все обязательные поля", errorEmp);
    }

    @Test
    @Story("Тест15")
    @DisplayName("Проверка плейсхолдеров на форме контактов")
    public void placeholdersTest() {
        String[] expected = new String[]{"Имя", "Почта", "(999) 999-99-99",};
        HomePage data = new HomePage(driver);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], data.getAllPlaceholders().get(i));
        }
    }

    @Test
    @Story("Тест16")
    @DisplayName("Проверка негативного сценария заполнения формы контактов на примере неправильной почты")
    public void formTest() {
        HomePage data = new HomePage(driver);
        data.fillFormInfo("Максим", "1", "(900) 000-00-00");
        String error = driver.findElement(data.getErrorTextEmail).getText();
        assertEquals("Укажите, пожалуйста, корректный email", error);
    }

    @Test
    @Story("Тест17")
    @DisplayName("Проверка негативного сценария заполнения формы контактов с пустыми полями")
    public void formEmptyTest() {
        HomePage data = new HomePage(driver);
        data.fillFormInfo("", "", "");
        String errorEmp = driver.findElement(data.getErrorTextEmpty).getText();
        assertEquals("Пожалуйста, заполните все обязательные поля", errorEmp);
    }

    @Test
    @Story("Тест18")
    @DisplayName("Тест фрейма открытия чата")
    public void openChatTest() {
        HomePage data = new HomePage(driver);
        data.clickChat();
    }

    //Тесты в разделе footer сайта

    @Test
    @Story("Тест19")
    @DisplayName("Проверка работы кнопки показать больше")
    public void hiddenTextTest() {
        HomePage data = new HomePage(driver);
        data.getSpisok();
    }

    @Test
    @Story("Тест20")
    @DisplayName("Проверка работы ссылки на habr")
    public void hrefHabrTest() {
        HomePage data = new HomePage(driver);
        data.goHrefHabr();
    }

    @Test
    @Story("Тест21")
    @DisplayName("Надпись в конце страницы содержит актуальную информацию о названии компании и текущий год")
    public void footerTextTest() {
        HomePage data = new HomePage(driver);
        assertEquals("Skillfactory, 2024", data.footText());
    }
}