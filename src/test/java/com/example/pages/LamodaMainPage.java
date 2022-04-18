package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.lamoda.ru/
public class LamodaMainPage {

    @FindBy(css = "body > div.page.index-page > div.vue-widget._2iLgRnNCb_TzR34bnEcNeD > div._12Etfw_uoPOmXzyAfvKXds > div > button")
    public WebElement sessionCookieButton;

    @FindBy(css = "body > div.page.index-page > div.logo-line-wrapper.width-wrapper > div > div > a.wCjUeog4KtWw64IplV1e6._3A5-9K2JrODjfTiazRr7pk.BLS-hOSrikRnPX76_f5Xr")
    public WebElement logInButton;

    @FindBy(css = "body > div.page.index-page > div.logo-line-wrapper.width-wrapper > nav > a.wCjUeog4KtWw64IplV1e6._3A5-9K2JrODjfTiazRr7pk._28VKkeFsrUqull6_FS0I7_")
    public WebElement forMan;

    @FindBy(css = "#menu-wrapper > div > div > nav > a.wCjUeog4KtWw64IplV1e6._3dch7Ytt3ivpea7TIsKVjb._32MQA-gIaGxNU0uTG1yKum._2eC6QpSnwGw-85fI8rtng0")
    public WebElement clothes;

    public LamodaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}