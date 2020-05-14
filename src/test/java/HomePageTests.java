import Base.TestBase;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ItemDetailPage;
import pages.Search;

public class HomePageTests extends TestBase {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        homePage.runHomePage();
    }

    @Test
    public void verifyIfUserCanSeeContactNumber() {
        homePage.assertPhoneNumberDisplayed("0123-456-789");
    }

    @Test
    public void verifyIfItemPriceIsDisplayed() {
        ItemDetailPage itemDetailPage = homePage.clickOnItemCard();
        itemDetailPage.assertPriceDisplayed();
    }

    @Test
    public void userCanSearchForAnItem() {
        Search search = homePage.searchForItem("dress");
        search.assertSearchCaptionVisible("SEARCH");
        search.assertDressHeaderVisible("\"DRESS\"");
        search.assertSearchResultsVisible("7 results have been found.");
    }

    @Test
    public void userCanWriteEmailMessage() {
        ContactUsPage contactUsPage = homePage.clickOnContactUs();

        contactUsPage.selectSubject("Customer service");
        contactUsPage.assertCorrectSubjectSelected("Customer service");
        contactUsPage.assertCustomerServiceHeaderDisplayed("Customer service - Contact us");

        contactUsPage.typeEmail("johnKowalski2137@wp.pl");
        contactUsPage.assertCorrectEmailTyped("johnKowalski2137@wp.pl");
        contactUsPage.typeOrder("Order66");

        contactUsPage.assertCorrectOrderTyped("Order66");

        contactUsPage.typeMessage("Generic message with complaint");
        contactUsPage.assertCorrectMessageTyped("Generic message with complaint");

        contactUsPage.clickOnUploadFile();
        contactUsPage.assertCorrectFileUploaded("Rare pepe2.jpg");

        contactUsPage.clickOnSubmitButton();
        contactUsPage.assertUserMessageSent("Your message has been successfully sent to our team.");
    }
}