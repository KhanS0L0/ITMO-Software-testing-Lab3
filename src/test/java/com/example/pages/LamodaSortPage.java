package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LamodaSortPage {

    @FindBy(xpath = "//button[contains(text(),'Хорошо')]")
    public WebElement sessionCookieButton;

    @FindBy(xpath = "//div[@class='sub-popup-feb18__close']")
    public WebElement closeSpecialSalesBox;

    @FindBy(xpath = "(//div[contains(@class,'icon icon__filter_arrow icon_direction-down')])[1]")
    public WebElement sortButton;

    @FindBy(xpath = "//span[contains(text(),'По возрастанию цены')]")
    public WebElement sortByCostAsc;

    @FindBy(xpath = "//span[contains(text(),'По убыванию цены')]")
    public WebElement sortByCostDesc;

    @FindBy(xpath = "//span[contains(text(),'По скидкам')]")
    public WebElement sortByDiscount;

    @FindBy(xpath = "(//span[starts-with(text(),'−')])[1]")
    public WebElement firstDiscountValue;

    @FindBy(xpath = "(//span[starts-with(text(),'−')])[60]")
    public WebElement lastDiscountValue;

    @FindBy(xpath = "(//span[contains(text(),' ₽')])[1]")
    public WebElement firstCostValue;

    @FindBy(xpath = "(//span[contains(text(),' ₽')])[60]")
    public WebElement lastCostValue;

    public LamodaSortPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
