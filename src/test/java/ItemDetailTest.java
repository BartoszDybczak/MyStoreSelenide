import Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemDetailPage;
import pages.TShirtsCategoryPage;
import pages.TwitterPopUpPage;

public class ItemDetailTest extends TestBase {

    private ItemDetailPage itemDetailPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        itemDetailPage = new ItemDetailPage();
        itemDetailPage.openItemDetailPage();
    }

    @Test
    public void userCanIncreaseItemQuantity() {
        itemDetailPage.clickOnPlusButton();

        itemDetailPage.assertQtyIncreased();
    }

    @Test
    public void userCanDecreaseItemQuantity() {
        itemDetailPage.clickOnMinusButton();

        itemDetailPage.assertQtyDecreased();
    }

    @Test
    public void userCanSelectItemSize() {
        itemDetailPage.selectItemSize("M");

        itemDetailPage.assertSizeSelected();
    }

    @Test
    public void userCanNavigateToTShirtsCategory() {
        TShirtsCategoryPage tShirtsCategoryPage = itemDetailPage.clickOnTShirtsCategory();

        tShirtsCategoryPage.assertTShirtsCategoryPageOpened();
    }

    @Test
    public void userCanShareItemOnTwitter() {
        itemDetailPage.clickOnTwitterButton();
        TwitterPopUpPage twitterPopUpPage = itemDetailPage.switchToTwitterWindow("Post a Tweet on Twitter");

        twitterPopUpPage.assertTwitterPopUpOpened();
    }

    @Test
    public void userCanAddItemToCart() {
        itemDetailPage.clickOnAddToCart();

        itemDetailPage.assertItemAddedToCart();
    }

    @Test
    public void userCanRemoveItemFromCart() {
        itemDetailPage.clickOnAddToCart();
        itemDetailPage.clickOnCloseButton();
        itemDetailPage.removeItemFromCart();

        itemDetailPage.assertItemRemovedFromCart();
    }
}