package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HomePage {

    private String pageUrl = "http://automationpractice.com/index.php";

    private By phoneNumberLocator = By.cssSelector("nav  strong");
    private By shortSleeveLocator = By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']");
    private By contactUs = By.xpath("//*[@title='Contact Us']");
    private By signInLocator = By.xpath("//*[@title='Log in to your customer account']");
    private By searchBarLocator = By.id("search_query_top");
    private By searchButtonLocator = By.xpath("//*[@class='btn btn-default button-search']");

    public void runHomePage() {
        open(pageUrl);
    }

    public ItemDetailPage clickOnItemCard() {
        $x("//h5/a[@title='Faded Short Sleeve T-shirts']").click();

        return new ItemDetailPage();
    }

    public Search searchForItem(String itemName) {
        $(searchBarLocator).sendKeys(itemName);
        $(searchButtonLocator).click();

        return new Search();
    }

    public ContactUsPage clickOnContactUs() {
        $(contactUs).click();

        return new ContactUsPage();
    }

    public SignInPage clickOnSignIn() {
        $(signInLocator).click();

        return new SignInPage();
    }

    public void assertPhoneNumberDisplayed(String contactNumber) {
        $(phoneNumberLocator).shouldHave(exactText(contactNumber));
    }
}