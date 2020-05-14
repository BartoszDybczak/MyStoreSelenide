package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ItemDetailPage {

    private String pageUrl = "http://automationpractice.com/index.php?id_product=1&controller=product";
    private By priceLocator = By.id("our_price_display");
    private By plusButtonLocator = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']");
    private By minusButtonLocator = By.xpath("//*[@class='btn btn-default button-minus product_quantity_down']");
    private By quantityLocator = By.xpath("//*[@id='quantity_wanted']");
    private By sizeDropdownLocator = By.id("group_1");
    private By twitterButtonLocator = By.xpath("//*[@class='btn btn-default btn-twitter']");
    private By tShirtsCategoryLocator = By.xpath("//*[@id='columns']/div[1]/a[4]");
    private By addToCartButtonLocator = By.id("add_to_cart");
    private By addToCartText = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");
    private By orderedItemQtyText = By.xpath("//*[@class='ajax_cart_product_txt ']");
    private By closeWindowLocator = By.xpath("//*[@title='Close window']");
    private By removeFromCartButtonLocator = By.xpath("//*[@class='ajax_cart_block_remove_link']");
    private By shoppingCardPreviewLocator = By.xpath("//*[@title='View my shopping cart']");
    private By emptyCartText = By.xpath("//*[@class='ajax_cart_no_product']");
    private By proceedToCheckoutButton = By.xpath("//*[@class='btn btn-default button button-medium']");

    public void openItemDetailPage() {
        WebDriverRunner.clearBrowserCache();
        open(pageUrl);
    }

    public void clickOnPlusButton() {
        $(plusButtonLocator).click();
    }

    public void clickOnMinusButton() {
        $(minusButtonLocator).click();
    }

    public void clickOnTwitterButton() {
        $(twitterButtonLocator).click();
    }

    public TShirtsCategoryPage clickOnTShirtsCategory() {
        $(tShirtsCategoryLocator).click();

        return new TShirtsCategoryPage();
    }

    public TwitterPopUpPage switchToTwitterWindow(String windowTitle) {
        switchTo().window(windowTitle);

        return new TwitterPopUpPage();
    }

    public void selectItemSize(String itemSize) {
        $(sizeDropdownLocator).selectOption(itemSize);
    }

    public void clickOnAddToCart() {
        $(addToCartButtonLocator).click();
    }

    public void clickOnCloseButton() {
        $(closeWindowLocator).click();
    }

    public void removeItemFromCart() {
        $(shoppingCardPreviewLocator).hover();
        $(removeFromCartButtonLocator).click();
    }

    public OrderSummaryPage clickOnProceedToCheckout() {
        $(proceedToCheckoutButton).click();

        return new OrderSummaryPage();
    }

    public void assertPriceDisplayed() {
        $(priceLocator).shouldHave(text("$16.51"));
    }

    public void assertQtyIncreased() {
        $(quantityLocator).shouldHave(value("2"));
    }

    public void assertQtyDecreased() {
        $(quantityLocator).shouldHave(value("1"));
    }

    public void assertSizeSelected() {
        $(sizeDropdownLocator).shouldHave(text("M"));
    }

    public void assertItemAddedToCart() {
        $(addToCartText).shouldHave(text("Product successfully added to your shopping cart"));
        $(orderedItemQtyText).shouldHave(text("There is 1 item in your cart."));
    }

    public void assertItemRemovedFromCart() {
        $(emptyCartText).shouldHave(text("(empty)"));
    }
}