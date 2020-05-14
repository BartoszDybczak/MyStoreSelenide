package login;

import Base.TestBase;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;

public class LogInNegativePath extends TestBase {

    @Parameters({"email", "password", "expectedMessage", "browser" })
    @Test
    public void LogInNegativePath(String email, String password, String expectedMessage, @Optional("chrome") String browser) {
        HomePage homePage = new HomePage();

        //Open Home Page
        homePage.runHomePage();

        //Click on SignIn button
        SignInPage signInPage = homePage.clickOnSignIn();

        //Type user email
        signInPage.typeUsername(email);

        //Type user password
        signInPage.typePassword(password);

        //Click on LogIn button
        MyAccountPage myAccountPage = signInPage.clickOnLoginButton();

        //Assertions
        signInPage.assertErrorMessageDisplayed(expectedMessage);
    }
}