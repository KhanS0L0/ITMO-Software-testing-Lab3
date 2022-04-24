package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LamodaFilterPage {

    @FindBy(xpath = "//button[contains(text(),'Хорошо')]")
    public WebElement sessionCookieButton;

    @FindBy(xpath = "//div[@class='sub-popup-feb18__close']")
    public WebElement closeSpecialSalesBox;

    @FindBy(xpath = "(//div[contains(@class,'icon icon__filter_arrow icon_direction-down')])[6]")
    public WebElement filterByCost;

    @FindBy(xpath = "(//div[contains(@class,'icon icon__filter_arrow icon_direction-down')])[5]")
    public WebElement filterByBrand;

    @FindBy(xpath = "//input[contains(@name,'minRange')]")
    public WebElement costMinRange;

    @FindBy(xpath = "//button[contains(text(),'Применить')]")
    public WebElement submitButton;

    @FindBy(xpath = "(//span[contains(text(),' ₽')])[1]")
    public WebElement firstItemCost;

    @FindBy(xpath = "(//span[contains(text(),' ₽')])[30]")
    public WebElement middleItemCost;

    @FindBy(xpath = "(//span[contains(text(),' ₽')])[60]")
    public WebElement lastItemCost;

    @FindBy(xpath = "//input[contains(@name,'searchQuery')]")
    public WebElement brandInput;

    @FindBy(xpath = "//div[contains(text(),'Nike')]")
    public WebElement brandCheckBox;

    @FindBy(xpath = "(//div[contains(@class,'x-product-card-description__brand-name')])[1]")
    public WebElement firstItemBrand;

    @FindBy(xpath = "(//div[contains(@class,'x-product-card-description__brand-name')])[30]")
    public WebElement middleItemBrand;

    @FindBy(xpath = "(//div[contains(@class,'x-product-card-description__brand-name')])[60]")
    public WebElement lastItemBrand;

    public LamodaFilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
