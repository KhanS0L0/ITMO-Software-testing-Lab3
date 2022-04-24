package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.lamoda.ru/
public class LamodaLoginPage {

    @FindBy(xpath = "//button[contains(text(),'Хорошо')]")
    public WebElement sessionCookieButton;

    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    public WebElement logInButton;

    @FindBy(xpath = "//div[@class='d-modal__content d-modal__content-only d-modal__content_paddings']")
    public WebElement singInBox;

    @FindBy(xpath = "(//input[contains(@placeholder,'Введите свой email')])[1]")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[contains(@placeholder,'Введите пароль')]")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    public WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'Профиль')]")
    public WebElement profile;

    @FindBy(xpath = "//a[contains(text(),'Мои данные')]")
    public WebElement profileData;

    @FindBy(xpath = "//div[contains(text(),'')]")
    public WebElement emailField;

    public LamodaLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
