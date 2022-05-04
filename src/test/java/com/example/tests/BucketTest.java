package com.example.tests;

import com.example.pages.LamodaBucketPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class BucketTest {

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
    @DisplayName("Bucket test")
    public void bucketTest(){

        LamodaBucketPage bucketPage = new LamodaBucketPage(driver);

        bucketPage.sessionCookieButton.click();
        bucketPage.bucketButton.click();

        String info = wait.until(ExpectedConditions.elementToBeClickable(bucketPage.emptyBucketInfo)).getText();
        assertEquals(info, "В корзине нет товаров");

        bucketPage.randomItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(bucketPage.addToBucket)).click();
        wait.until(ExpectedConditions.elementToBeClickable(bucketPage.itemSize)).click();
        wait.until(ExpectedConditions.elementToBeClickable(bucketPage.redirectToBucket)).click();

        String tmp1 = wait.until(ExpectedConditions.visibilityOf(bucketPage.filledBucketButton)).getText();
        String tmp2 = wait.until(ExpectedConditions.visibilityOf(bucketPage.filledBucketInfo)).getText();

        assertEquals(tmp1, tmp2);
    }
}
