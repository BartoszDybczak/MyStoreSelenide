package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class RegisterFormPage {

    private By genderButtonLocator = By.id("uniform-id_gender1");
    private By customerFirstNameLocator = By.id("customer_firstname");
    private By customerLastNameLocator = By.id("customer_lastname");
    private By registerFormEmailLocator = By.id("email");
    private By registerFormPasswordLocator = By.id("passwd");
    private By registerFormDayLocator = By.id("days");
    private By registerFormMonthLocator = By.id("months");
    private By registerFormYearLocator = By.id("years");
    private By newsletterCheckboxLocator = By.id("newsletter");
    private By specialOffersCheckboxLocator = By.id("optin");
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By address1 = By.id("address1");
    private By city = By.id("city");
    private By country = By.id("id_country");
    private By mobilePhone = By.id("phone_mobile");
    private By state = By.id("id_state");
    private By postalCodeLocator = By.id("postcode");
    private By aliasAddress = By.id("alias");
    private By submitButton = By.id("submitAccount");

    public void chooseGender() {
        $(genderButtonLocator).click();
    }

    public void typeName(String customerFirstName) {
        $(customerFirstNameLocator).sendKeys(customerFirstName);
    }

    public void typeLastName(String customerLastName) {
        $(customerLastNameLocator).sendKeys(customerLastName);
    }

    public void typePassword(String password) {
        $(registerFormPasswordLocator).sendKeys(password);
    }

    public void selectBirthDay(String value) {
        $(registerFormDayLocator).selectOption(value);
    }

    public void selectBirthMonth(String value) {
        $(registerFormMonthLocator).selectOption(value);
    }

    public void selectBirthYear(String value) {
        $(registerFormYearLocator).selectOption(value);
    }

    public void clickOnNewsletterCheckbox() {
        $(newsletterCheckboxLocator).click();
    }

    public void clickOnSpecialOfferCheckbox() {
        $(specialOffersCheckboxLocator).click();
    }

    public void typeAddress(String address) {
        $(address1).sendKeys(address);
    }

    public void typeCity(String cityName) {
        $(city).sendKeys(cityName);
    }

    public void selectCountry(String value) {
        $(country).selectOption(value);
    }

    public void selectState(String value) {
        $(state).selectOption(value);
    }

    public void typeMobilePhone(String phoneNumber) {
        $(mobilePhone).sendKeys(phoneNumber);
    }

    public void typePostalCode(String postalCode) {
        $(postalCodeLocator).sendKeys(postalCode);
    }

    public MyAccountPage clickOnSubmitButton() {
        $(submitButton).click();

        return new MyAccountPage();
    }

    public void isGenderSelected() {
        $(By.xpath("//*[@id='id_gender1']")).shouldBe(selected);
    }

    public void verifyIfTypedEmailIsCorrect(String email) {
        $(registerFormEmailLocator).shouldHave(exactValue(email));
    }

    public void verifyFirstName(String firstName) {
        $(customerFirstNameLocator).shouldHave(exactValue(firstName));
    }

    public void verifyLastName(String lastName) {
        $(customerLastNameLocator).shouldHave(exactValue(lastName));
    }

    public void verifyPassword(String password) {
        $(registerFormPasswordLocator).shouldHave(exactValue(password));
    }

    public void verifyBirthDaySelected(String selectedDay) {
        $(registerFormDayLocator).getSelectedOption().shouldHave(exactValue(selectedDay));
    }

    public void verifyMonthSelected(String selectedMonth) {
        $(registerFormMonthLocator).getSelectedOption().shouldHave(exactText(selectedMonth));
    }

    public void verifyYearSelected(String selectedYear) {
        $(registerFormYearLocator).getSelectedOption().shouldHave(exactValue(selectedYear));
    }

    public void verifyAddress(String address) {
        $(address1).shouldHave(exactValue(address));
    }

    public void verifyCity(String cityName) {
        $(city).shouldHave(exactValue(cityName));
    }

    public void verifyCountry(String countryName) {
        $(country).getSelectedOption().shouldHave(exactText(countryName));
    }

    public void verifyState(String stateName) {
        $(state).getSelectedOption().shouldHave(exactText(stateName));
    }

    public void verifyPostCode(String postCodeValue) {
        $(postalCodeLocator).shouldHave(exactValue(postCodeValue));
    }

    public void verifyPhoneNumber(String phoneNumber) {
        $(mobilePhone).shouldHave(exactValue(phoneNumber));
    }

    public void verifyAlias(String aliasText) {
        $(aliasAddress).shouldHave(exactValue(aliasText));
    }
}