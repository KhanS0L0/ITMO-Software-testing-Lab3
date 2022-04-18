package com.example.tests;

import com.example.pages.LamodaMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegistrationTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private LamodaMainPage mainPage;

    //Общая логика тестирования будет прежней,
    //выбирать драйвер нужно для поддержки различных браузеров

    //Определяем какой драйвер(браузер) будет использоваться для всех тестов
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    //Перед каждым тестом открываем страницу сайта
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
//        driver = new FirefoxDriver();
        driver.get("https://www.lamoda.ru/");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Registration test")
    public void registration() throws InterruptedException {
        //Получаем главную страницу сайта для дальнейшего использования
        mainPage = new LamodaMainPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(mainPage.sessionCookieButton));
        mainPage.sessionCookieButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(mainPage.logInButton));
        mainPage.logInButton.click();

        //driver.switchTo().frame(mainPage.modalWindow);
        // TODO: 18/4/22 problems with modal windows, Selenium can't switch to it
    }

    @Test
    @DisplayName("Filters and sorting test")
    public void filterAndSort() throws InterruptedException {
        mainPage = new LamodaMainPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(mainPage.forMan));
        mainPage.forMan.click();

        //поменять через ссылку
        driver.switchTo().frame(mainPage.forMan);
        mainPage.clothes.click();

        Thread.sleep(10000);
    }


}
