package com.example.tests;

import com.example.pages.LamodaLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

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
        wait = new WebDriverWait(driver,10);
//        driver = new FirefoxDriver();
        driver.get("https://www.lamoda.ru/");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


    @Test
    @DisplayName("Login test")
    public void loginTest(){
        LamodaLoginPage loginPage = new LamodaLoginPage(driver);

        loginPage.sessionCookieButton.click();
        loginPage.logInButton.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.singInBox));

        loginPage.inputEmail.sendKeys("");
        loginPage.inputPassword.sendKeys("");
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.submitButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.profile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.profileData)).click();

        String email = loginPage.emailField.getText();
        assertEquals(email, "");
    }

}
