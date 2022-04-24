package com.example.tests;

import com.example.pages.LamodaSortPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private LamodaSortPage sortPage;

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
        sortPage = new LamodaSortPage(driver);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("sort by discount test")
    public void sortByDiscountTest() throws InterruptedException {
        sortPage.sessionCookieButton.click();
        sortPage.closeSpecialSalesBox.click();

        sortPage.sortButton.click();
        sortPage.sortByDiscount.click();

        wait.until(ExpectedConditions
                .visibilityOfAllElements(
                        sortPage.firstDiscountValue,
                        sortPage.lastDiscountValue)
        );

        Thread.sleep(3000);

        String firstDiscount = sortPage.firstDiscountValue.getText();
        String lastDiscount = sortPage.lastDiscountValue.getText();

        System.out.println("1: " + firstDiscount + "\n" + "2: " + lastDiscount);

        int firstValue = Integer.parseInt(firstDiscount.replaceAll("%", "").replaceAll("−", ""));
        int secondValue = Integer.parseInt(lastDiscount.replaceAll("%", "").replaceAll("−", ""));

        assertTrue(firstValue > secondValue);
    }

    @Test
    @DisplayName("sort by cost ascending test")
    public void sortByAscCostTest() throws InterruptedException {
        sortPage.sessionCookieButton.click();
        sortPage.closeSpecialSalesBox.click();

        sortPage.sortButton.click();
        sortPage.sortByCostAsc.click();

        wait.until(ExpectedConditions
                .visibilityOfAllElements(
                        sortPage.firstCostValue,
                        sortPage.lastCostValue)
        );

        Thread.sleep(3000);

        String firstCost = sortPage.firstCostValue.getText();
        String lastCost = sortPage.lastCostValue.getText();

        System.out.println("1: " + firstCost + "\n" + "2: " + lastCost);

        int firstValue = Integer.parseInt(firstCost.replaceAll(" ₽", "").replaceAll(" ", ""));
        int secondValue = Integer.parseInt(lastCost.replaceAll(" ₽", "").replaceAll(" ", ""));

        assertTrue(firstValue < secondValue);
    }

    @Test
    @DisplayName("sort by cost descending test")
    public void sortByDescCostTest() throws InterruptedException {
        sortPage.sessionCookieButton.click();
        sortPage.closeSpecialSalesBox.click();

        sortPage.sortButton.click();
        sortPage.sortByCostDesc.click();

        wait.until(ExpectedConditions
                .visibilityOfAllElements(
                        sortPage.firstCostValue,
                        sortPage.lastCostValue)
        );

        Thread.sleep(3000);

        String firstCost = sortPage.firstCostValue.getText();
        String lastCost = sortPage.lastCostValue.getText();

        System.out.println("1: " + firstCost + "\n" + "2: " + lastCost);

        int firstValue = Integer.parseInt(firstCost.replaceAll(" ₽", "").replaceAll(" ", ""));
        int secondValue = Integer.parseInt(lastCost.replaceAll(" ₽", "").replaceAll(" ", ""));

        assertTrue(firstValue > secondValue);
    }
}