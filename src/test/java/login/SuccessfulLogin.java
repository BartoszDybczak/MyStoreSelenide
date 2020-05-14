package login;

import Base.TestBase;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;

public class SuccessfulLogin extends TestBase {

    @Test
    public void userCanLogIn() {
        HomePage homePage = new HomePage();

        //Open Home Page
        homePage.runHomePage();

        //Click on SignIn button
        SignInPage signInPage = homePage.clickOnSignIn();

        //Type user email
        signInPage.typeUsername("johnKowalski2137@wp.pl");

        //Type user password
        signInPage.typePassword("tttttt");

        //Click on LogIn button
        MyAccountPage myAccountPage = signInPage.clickOnLoginButton();

        //Assertions
        myAccountPage.assertAccountInfoTextDisplayed("Welcome to your account.");
        myAccountPage.assertMyAccountCaptionVisible("My account".toUpperCase());
    }
}