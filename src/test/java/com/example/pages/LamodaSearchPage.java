package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.lamoda.ru/catalogsearch/result/
public class LamodaSearchPage {

    @FindBy(xpath = "//button[contains(text(),'Хорошо')]")
    public WebElement sessionCookieButton;

    @FindBy(xpath = "//div[@class='sub-popup-feb18__close']")
    public WebElement closeSpecialSalesBox;

    @FindBy(xpath = "//div[contains(@class, 'icon icon__search-white icon_direction-down')]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='menu-wrapper']/div/div/div/div/input")
    public WebElement searchInput;

    @FindBy(xpath = "//div[contains(@class, 'grid__catalog')]")
    public WebElement catalog;

    @FindBy(xpath = "//a[@href='/p/rtlaax095601/shoes-jordan-krossovki/']")
    public WebElement searchItem;

    @FindBy(xpath = "//span[contains(text(),'Кроссовки ZION 1')]")
    public WebElement itemName;

    public LamodaSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
