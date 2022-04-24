package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.lamoda.ru/
public class LamodaRegistrationPage {

    @FindBy(xpath = "//button[contains(text(),'Хорошо')]")
    public WebElement sessionCookieButton;

    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    public WebElement logInButton;

    @FindBy(xpath = "//a[contains(text(),'Создать аккаунт')]")
    public WebElement createAccount;

    @FindBy(xpath = "//div[@class='d-modal__content d-modal__content_paddings']")
    public WebElement registrationBox;

    @FindBy(xpath = "(//input[contains(@name,'Электронная почта')])[2]")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[contains(@placeholder,'Придумайте пароль')]")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[contains(@placeholder,'Повторите пароль')]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[contains(@placeholder,'Введите свое имя')]")
    public WebElement inputUsername;

    @FindBy(xpath = "//button[contains(text(),'Зарегистрироваться')]")
    public WebElement submitButton;

    public LamodaRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
