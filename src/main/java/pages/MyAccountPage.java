package pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MyAccountPage {

    private By accountInfoCaption = By.xpath("//*[@class='info-account']");
    private By myAccountHeader = By.xpath("//*[@class='page-heading']");

    public void assertAccountInfoTextDisplayed(String accountInfoText) {
        $(accountInfoCaption).shouldHave(text(accountInfoText));
    }

    public void assertMyAccountCaptionVisible(String myAccountText) {
        $(myAccountHeader).shouldHave(text(myAccountText));
    }
}