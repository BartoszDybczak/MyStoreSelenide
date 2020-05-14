package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage {

    private By customerServiceHeaderLocator = By.xpath("//*[@class='page-heading bottom-indent']");
    private By dropdownId = By.id("id_contact");
    private By userMailLocator = By.id("email");
    private By userOrderLocator = By.id("id_order");
    private By messageLocator = By.id("message");
    private By fileUploadLocator = By.id("fileUpload");
    private By submitButtonId = By.id("submitMessage");
    private By successMessageLocator = By.xpath("//*[@class='alert alert-success']");

    public void selectSubject(String text) {
        $(dropdownId).selectOption(text);
    }

    public void typeEmail(String username) {
        $(userMailLocator).sendKeys(username);
    }

    public void typeOrder(String orderNumber) {
        $(userOrderLocator).sendKeys(orderNumber);
    }

    public void typeMessage(String messageText) {
        $(messageLocator).sendKeys(messageText);
    }

    public void clickOnUploadFile() {
        String filePath = "/Users/bartosz.dybczak/Desktop/Rare pepe2.jpg";
        $(fileUploadLocator).sendKeys(filePath);
    }

    public void clickOnSubmitButton() {
        $(submitButtonId).click();
    }

    public void assertCustomerServiceHeaderDisplayed(String customerServiceHeader) {
        $(customerServiceHeaderLocator).shouldHave(text(customerServiceHeader));
    }

    public void assertCorrectSubjectSelected(String dropdownText) {
        $(dropdownId).getSelectedOption().shouldHave(text(dropdownText));
    }

    public void assertCorrectEmailTyped(String userMail) {
        $(userMailLocator).shouldHave(value(userMail));
    }

    public void assertCorrectOrderTyped(String userOrder) {
        $(userOrderLocator).shouldHave(exactValue(userOrder));
    }

    public void assertCorrectMessageTyped(String userMessage) {
        $(messageLocator).shouldHave(Condition.exactValue(userMessage));
    }

    public void assertCorrectFileUploaded(String fileName) {
        $(fileUploadLocator).shouldHave(value(fileName));
    }

    public void assertUserMessageSent(String successMessage) {
        $(successMessageLocator).shouldHave(text(successMessage));
    }
}