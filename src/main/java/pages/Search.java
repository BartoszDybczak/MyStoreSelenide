package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;

public class Search {

    private By searchLocator = By.xpath("//*[@class='page-heading  product-listing']");
    private By dressTextLocator = By.xpath("//*[@class='lighter']");
    private By searchResultsLocator = By.xpath("//*[@class='heading-counter']");

    public void assertSearchCaptionVisible(String searchText) {
        $(searchLocator).shouldHave(text(searchText));
    }

    public void assertDressHeaderVisible(String dressText) {
        $(dressTextLocator).shouldHave(text(dressText));
    }

    public void assertSearchResultsVisible(String resultsText) {
        $(searchResultsLocator).shouldHave(text(resultsText));
    }
}