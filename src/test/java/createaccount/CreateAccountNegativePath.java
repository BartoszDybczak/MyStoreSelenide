package createaccount;

import Base.TestBase;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;

public class CreateAccountNegativePath extends TestBase {

    @Parameters({"email", "expectedMessage"})
    @Test
    public void createAccountNegative(String email, String expectedMessage) {
        SignInPage signInPage = new SignInPage();

        //Open SignInPage
        signInPage.openSignInPage();
        //Type user email
        signInPage.createAccountEmail(email);
        //Click on create account button
        signInPage.clickOnCreateAccount();
        //Assertion
        signInPage.assertErrorMessageDisplayed(expectedMessage);
    }
}