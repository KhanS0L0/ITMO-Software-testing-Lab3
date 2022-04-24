package com.example.tests;


import com.example.pages.LamodaFilterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FilterTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private LamodaFilterPage filterPage;

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
        driver.get("https://www.lamoda.ru/catalogsearch/result/");
        filterPage = new LamodaFilterPage(driver);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("filter by cost test")
    public void filterCostTest() throws InterruptedException {
        filterPage.sessionCookieButton.click();
        filterPage.closeSpecialSalesBox.click();

        filterPage.filterByCost.click();
        filterPage.costMinRange.sendKeys("1000");
        filterPage.submitButton.click();

        wait.until(ExpectedConditions
                .visibilityOfAllElements(
                        filterPage.firstItemCost,
                        filterPage.middleItemCost,
                        filterPage.lastItemCost)
        );

        Thread.sleep(3000);

        int firstPrice = Integer.parseInt(
                filterPage.firstItemCost.getText()
                        .replaceAll(" ₽", "")
                        .replaceAll(" ", "")
        );

        int secondPrice = Integer.parseInt(
                filterPage.middleItemCost.getText()
                        .replaceAll(" ₽", "")
                        .replaceAll(" ", "")
        );

        int thirdPrice = Integer.parseInt(
                filterPage.lastItemCost.getText()
                        .replaceAll(" ₽", "")
                        .replaceAll(" ", "")
        );

        System.out.println("1: " + firstPrice + " 2: " + secondPrice + " 3: " + thirdPrice);

        assertTrue(1000 < firstPrice && 1000 < secondPrice && 1000 < thirdPrice);
    }

    @Test
    @DisplayName("filter by brand test")
    public void filterBrandTest() throws InterruptedException {
        filterPage.sessionCookieButton.click();
        filterPage.closeSpecialSalesBox.click();

        filterPage.filterByBrand.click();
        filterPage.brandInput.sendKeys("nike");
        filterPage.brandCheckBox.click();
        filterPage.submitButton.click();

        wait.until(ExpectedConditions
                .visibilityOfAllElements(
                        filterPage.firstItemBrand,
                        filterPage.middleItemBrand,
                        filterPage.lastItemBrand)
        );

        Thread.sleep(3000);

        String firstBrand = filterPage.firstItemBrand.getText();
        String secondBrand = filterPage.middleItemBrand.getText();
        String thirdBrand = filterPage.lastItemBrand.getText();

        System.out.println("1: " + firstBrand + " 2: " + secondBrand + " 3: " + thirdBrand);

        assertTrue(firstBrand.equals("Nike") && secondBrand.equals("Nike") && thirdBrand.equals("Nike"));
    }
}
