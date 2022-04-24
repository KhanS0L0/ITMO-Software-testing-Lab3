package com.example.tests;

import com.example.pages.LamodaSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest {

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
        driver.get("https://www.lamoda.ru/catalogsearch/result/");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("test of search function")
    public void searchTest() {
        LamodaSearchPage searchPage = new LamodaSearchPage(driver);

        searchPage.sessionCookieButton.click();
        searchPage.closeSpecialSalesBox.click();


        wait.until(ExpectedConditions.elementToBeClickable(searchPage.searchButton)).click();
        searchPage.searchInput.sendKeys("Jordan zion 1");
        searchPage.searchInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(searchPage.catalog));
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.searchItem)).click();

        String text = wait.until(ExpectedConditions.visibilityOf(searchPage.itemName)).getText();
        assertEquals(text, "Кроссовки ZION 1");
    }
}
