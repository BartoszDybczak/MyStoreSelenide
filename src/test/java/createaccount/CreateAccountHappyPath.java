package createaccount;

import Base.TestBase;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.RegisterFormPage;
import pages.SignInPage;

public class CreateAccountHappyPath extends TestBase {

    @Test
    public void userCanRegister() {
        SignInPage signInPage = new SignInPage();
        //Open SignIn Page
        signInPage.openSignInPage();

        //Type new user email
        signInPage.createAccountEmail("johnKowalski2138@wp.pl");
        //Click on create account button
        RegisterFormPage registerFormPage = signInPage.clickOnCreateAccount();

        //Select user gender
        registerFormPage.chooseGender();
        //Assert gender is selected
        registerFormPage.isGenderSelected();

        //Type user first name
        registerFormPage.typeName("John");
        //Assert that user's first name was typed
        registerFormPage.verifyFirstName("John");

        //Type user last name
        registerFormPage.typeLastName("Kowalski");
        ////Assert that user's last name was typed
        registerFormPage.verifyLastName("Kowalski");

        //Type user password
        registerFormPage.typePassword("tttttt");
        //Assert that user's password was typed
        registerFormPage.verifyPassword("tttttt");

        //Select user birth day
        registerFormPage.selectBirthDay("2  ");
        //Assert birth day is selected
        registerFormPage.verifyBirthDaySelected("2");

        //Select user birth month
        registerFormPage.selectBirthMonth("April ");
        //Assert birth month is selected
        registerFormPage.verifyMonthSelected("April");

        //Select user birth year
        registerFormPage.selectBirthYear("2005  ");
        //Assert birth year is selected
        registerFormPage.verifyYearSelected("2005");

        //Type user address
        registerFormPage.typeAddress("Cherry Avn. 2");
        //Assert that user's address was typed
        registerFormPage.verifyAddress("Cherry Avn. 2");

        //Type user city
        registerFormPage.typeCity("Las Vegas");
        //Assert that user's city was typed
        registerFormPage.verifyCity("Las Vegas");

        //Select user country
        registerFormPage.selectCountry("United States");
        //Assert country is selected
        registerFormPage.verifyCountry("United States");

        //Select user state
        registerFormPage.selectState("Oregon");
        //Assert user state is selected
        registerFormPage.verifyState("Oregon");

        //Type user post code
        registerFormPage.typePostalCode("02137");
        //Assert that user's postcode was typed
        registerFormPage.verifyPostCode("02137");

        //Type user mobile phone
        registerFormPage.typeMobilePhone("8822335566");
        //Assert that user's mobile was typed
        registerFormPage.verifyPhoneNumber("8822335566");

        //Assert that user's alias address is correct
        registerFormPage.verifyAlias("My address");

        //Click on submit button
        MyAccountPage myAccountPage = registerFormPage.clickOnSubmitButton();

        //Assert that headers are displayed
        myAccountPage.assertAccountInfoTextDisplayed("Welcome to your account.");
        myAccountPage.assertMyAccountCaptionVisible("My account".toUpperCase());
    }
}