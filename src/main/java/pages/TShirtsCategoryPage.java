package pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TShirtsCategoryPage {

    private By tShirtsText = By.xpath("//*[@class='category-name']");

    public void assertTShirtsCategoryPageOpened() {
        $(tShirtsText).shouldHave(text("T-shirts"));
    }
}