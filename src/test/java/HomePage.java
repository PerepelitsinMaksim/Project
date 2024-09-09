import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String proforientasiaURL = "https://skillfactory.ru/it-specialist-proforientaciya";
    private static final String proforientasiaPageTitleLocator = "//h2[@field='tn_text_1650022405403']";
    private static final String proforientasiaPageTitleText = "IT-специалист с нуля";
    private static final String partnersFormURL = "https://my.advcake.com/o/skillfactory/affiliate/registration";
    private static final String startURL = "https://skillfactory.ru/";
    private static final String actualFinishText = "Заполните форму ниже, чтобы узнать свой результат и забрать подарки";
    private static final String habrURL = "https://habr.com/ru/companies/skillfactory/articles/";
    private static final String testURL = "https://free.skillfactory.ru/proftest-new-test?utm_source=sf-events&utm_medium=site&utm_campaign=np_all_all_sf-events_site_lp_leadmagnet-111_none_all_sf_none_none&utm_content=none&utm_term=none&_gl=1*3mh1eu*_gcl_au*NzA4OTAzOTI2LjE3MjU3OTg1Mjk.*_ga*MzIzMzcxNTQ5LjE3MjU3OTg0OTA.*_ga_X08SF39ELF*MTcyNTg2Nzc1NS41LjEuMTcyNTg2ODg1My42MC4wLjA.";

    private By slogan = By.xpath("//div[@class = 'column'][1]/h1");
    private By logo = By.xpath("//div[@class = 'main__logo-wrapper']/img");
    private By cards = By.xpath("//ul[@class = 'cards']/li/img");
    private By link = By.xpath("//a[@class = 'directions__list-link directions__list-link_green']");
    private By proforientasia = By.xpath("//a[@href='/it-specialist-proforientaciya']");
    private By partners = By.xpath("//a[@href = 'https://skillfactory.ru/partners-program']");
    private By partnersJoin = By.xpath("//a[@href='https://my.advcake.com/o/skillfactory/affiliate/registration']");
    private By forma = By.xpath("//div [@class = 't-form__inputsbox']/div/div/input");
    private By formTel = By.xpath("//input [@type = 'tel']");
    private By nameField = By.name("name");
    private By mailField = By.name("email");
    private By button = By.xpath("//button[@type = 'submit']");
    public By getErrorTextEmail = By.xpath("//div[@style = 'display: block; opacity: 1;']");
    public By getErrorTextEmpty = By.xpath("//p[@style = 'display: block;']");
    private By iFrame = By.xpath("//iframe[@id = 'carrot-messenger-collapsed-frame']");
    private By goChatWindow = By.xpath("//div[@class = 'container svelte-1qe9gqs']");
    private By forSMI = By.xpath("//div[@class = 't396__elem tn-elem tn-elem__7829184341676988561652 t-sbs-anim_started']");
    private By spisok = By.xpath("//div[@field = 'tn_text_1676997415025']");
    private By hrefHabrButton = By.xpath("//a [@href = 'https://habr.com/ru/company/skillfactory/blog/']");
    private By hrefFreeButton = By.xpath("//a[@href = '/free-events']");
    private By otvet = By.xpath("//ul[@class = 'question__answers']/li");
    private By otvetImg = By.xpath("//ul[@class = 'question__answers question__answers_image']/li");
    private By finishText = By.xpath("//div[@field = 'tn_text_1717680487937']");
    private By buttonNext = By.xpath("//div[@class = 'pagination__button pagination__button_next']");
    private By choiseProgramHref = By.xpath("//a[@class = 'higher-education__link']");
    private By learnMore = By.xpath("//a[@href = '#popup1']");
    private By formLearnMore = By.xpath("//form[@id = 'form721134585']");
    private By backgroundPicture = By.xpath("//div[@class = 'main__pic']/img");
    private By participateButton = By.xpath("//div[@class = 'rentgen__wrapper']/a");
    private By participateForm = By.xpath("//div[@class = 't396__elem tn-elem tn-elem__6575765361698157702527 zero-form-rendered']");
    private By phoneRentgenField = By.name("tildaspec-phone-part[]");
    private By hrefbackStartPage = By.xpath("//a[@class = 'tn-atom internal-link']");
    private By footerText = By.xpath("//div[@field = 'tn_text_1676892134777']");


    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div [@class = 't-form__inputsbox']/div/div/input"))));
    }

    @Step("Получение надписи слогана")
    public String getSloganTitle() {
        return driver.findElement(slogan).getText();
    }


    @Step("Создание коллекции изображений карточек курсов")
    public List<WebElement> getCards() {
        return driver.findElements(cards);
    }

    @Step("Отображение наличия логотипа")
    public Boolean logoPresent() {
        return driver.findElement(logo).isDisplayed();
    }

    @Step("Клик по ссылке")
    public String movingToLink() {
        return driver.findElement(link).getAttribute("href");
    }

    @Step("Переход по ссылке и сравнение заголовка")
    public void goToProforientaciyaPageAndCheck() {
        driver.findElement((proforientasia)).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        assertEquals(proforientasiaURL, driver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = driver.findElement(By.xpath(proforientasiaPageTitleLocator)).getText();
        assertEquals(proforientasiaPageTitleText, pageTitle, "У открытой страницы некорректный заголовок");
    }

    @Step("Переход по ссылкам на форму регистрации партнерской программы")
    public void openPartnerRegistrationForm() {
        driver.findElement(partners).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.findElement(partnersJoin).click();
        driver.switchTo().window(handles.get(1));
        assertEquals(partnersFormURL, driver.getCurrentUrl(), "У открытой страницы некорректный url");
    }

    @Step("Собираем название плейсхолдеров имя и почта")
    public List<String> getPlaceholder() {
        return driver.findElements(forma).stream()
                .map(webElement -> webElement.getAttribute("placeholder"))
                .limit(2)
                .collect(Collectors.toList());
    }

    @Step("Добавляем плейсхолдер телефона")
    public List<String> getAllPlaceholders() {
        String tel = driver.findElement(formTel).getAttribute("placeholder");
        ArrayList<String> array = new ArrayList<>(getPlaceholder());
        array.add(tel);
        return array;
    }

    @Step("Заполнение формы")
    public void fillFormInfo(String name, String mail, String tel) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(nameField))).click();
        driver.findElement(nameField).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(mailField))).click();
        driver.findElement(mailField).sendKeys(mail);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(formTel))).click();
        driver.findElement(formTel).sendKeys(tel);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(button))).click();
    }

    @Step("Вызов чата")
    public void clickChat() {
        driver.switchTo()
                .frame(wait.until(ExpectedConditions.visibilityOf(driver.findElement(iFrame))));
        driver.findElement(goChatWindow).click();
    }

    @Step("Раскрытие скрытой информации")
    public boolean getSpisok() {
        driver.findElement(spisok).click();
        return driver.findElement(forSMI).isDisplayed();
    }

    @Step("Переход по ссылке на страницу компании сайта Habr")
    public void goHrefHabr() {
        driver.findElement(hrefHabrButton).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        assertEquals(habrURL, driver.getCurrentUrl(), "У открытой страницы некорректный url");
    }

    @Step("Прохождение тестирования")
    public void goHrefTest() {
        driver.get(testURL);
        for (int i = 0; i < 18; i++) {
            if (i==3) {
                driver.findElement(otvetImg).click();
            }else driver.findElement(otvet).click();
        }
        String text = driver.findElement(finishText).getAttribute("textContent");
        assertEquals(actualFinishText, text, "Некорректный заголовок");
    }

    @Step("Кликабельность стрелок прокрутки")
    public void clikableRight() {
        driver.findElement(buttonNext).click();
    }

    @Step("Переход по ссылкам на форму выбора программы")
    public void openFormChoise() {
        driver.findElement(choiseProgramHref).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.findElement(learnMore).click();
        driver.switchTo().window(handles.get(1));
        driver.findElement(formLearnMore).isDisplayed();
    }

    @Step("Наличие фонового рисунка")
    public  boolean background() {
        return driver.findElement(backgroundPicture).isDisplayed();
    }

    @Step("Открытие формы IT-рентген")
    public void openFormITrentgen() {
        driver.findElement(participateButton).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.findElement(participateForm).isDisplayed();
    }

    @Step("Заполнение формы")
    public void fillFormITrentgen(String mail, String tel) {
        driver.findElement(participateButton).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(mailField))).click();
        driver.findElement(mailField).sendKeys(mail);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(phoneRentgenField))).click();
        driver.findElement(phoneRentgenField).sendKeys(tel);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(button))).click();
    }

    @Step("Возврат на стартовую страницу")
    public void backStartPage() {
        driver.findElement(hrefFreeButton).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.findElement(hrefbackStartPage).click();
        assertEquals(startURL, driver.getCurrentUrl(), "У открытой страницы некорректный url");
    }

    @Step("Получение текста")
    public String footText() {
        return driver.findElement(footerText).getText();
    }
}