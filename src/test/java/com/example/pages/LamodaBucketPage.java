package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.lamoda.ru/
public class LamodaBucketPage {

    @FindBy(xpath = "//button[contains(text(),'Хорошо')]")
    public WebElement sessionCookieButton;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    public WebElement bucketButton;

    @FindBy(xpath = "//div[contains(text(),'В корзине нет товаров')]")
    public WebElement emptyBucketInfo;

    @FindBy(xpath = "//div[contains(@class,'swiper-slide-visible swiper-slide-active')]")
    public WebElement randomItem;

    @FindBy(xpath = "//span[contains(text(),'Добавить в корзину')]")
    public WebElement addToBucket;

    @FindBy(xpath = "//div[contains(@class,'ui-product-page-sizes-chooser-item_enabled ui-product-page-sizes-chooser-item')]")
    public WebElement itemSize;

    @FindBy(xpath = "//a[contains(text(),'Перейти в корзину')]")
    public WebElement redirectToBucket;

    @FindBy(xpath = "//div[contains(text(),'1 товар')]")
    public WebElement filledBucketInfo;

    @FindBy(xpath = "(//span[contains(text(),'1 товар')])[1]")
    public WebElement filledBucketButton;

    public LamodaBucketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
