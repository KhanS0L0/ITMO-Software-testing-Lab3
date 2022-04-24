package com.example.tests;

import com.example.pages.LamodaRegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegistrationTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

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
    public void registration() {
        LamodaRegistrationPage registrationPage = new LamodaRegistrationPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.sessionCookieButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.logInButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.createAccount)).click();

        wait.until(ExpectedConditions.visibilityOf(registrationPage.registrationBox));

        registrationPage.inputEmail.sendKeys("test@email.com");
        registrationPage.inputPassword.sendKeys("password");
        registrationPage.confirmPassword.sendKeys("password");
        registrationPage.inputUsername.sendKeys("username");

        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.submitButton)).click();
    }

}
