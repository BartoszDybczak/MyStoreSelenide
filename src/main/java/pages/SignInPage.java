package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SignInPage {

    private String pageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    private By createEmailLocator = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By logInEmail = By.id("email");
    private By logInPassword = By.id("passwd");
    private By loginButton = By.id("SubmitLogin");
    private By accountErrorMessage = By.xpath("//ol/li");

    public void openSignInPage() {
        open(pageUrl);
    }

    public void createAccountEmail(String username) {
        $(createEmailLocator).sendKeys(username);
    }

    public RegisterFormPage clickOnCreateAccount() {
        $(createAccountButton).click();

        return new RegisterFormPage();
    }

    public void typeUsername(String username) {
        $(logInEmail).sendKeys(username);
    }

    public void typePassword(String password) {
        $(logInPassword).sendKeys(password);
    }

    public MyAccountPage clickOnLoginButton() {
        $(loginButton).click();

        return new MyAccountPage();
    }

    public void assertErrorMessageDisplayed(String errorText) {
        $(accountErrorMessage).shouldHave(text(errorText));
    }
}