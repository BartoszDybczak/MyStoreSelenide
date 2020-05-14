package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TwitterPopUpPage {

    private By twitterLoginButtonLocator = By.xpath("//*[@value='Log in and Tweet']");

    public void assertTwitterPopUpOpened() {
        $(twitterLoginButtonLocator).shouldHave(value("Log in and Tweet"));
    }
}