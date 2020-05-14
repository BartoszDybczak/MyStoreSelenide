package Base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUpConfig(@Optional("chrome") String browser) {
        Configuration.startMaximized = true;
        Configuration.browser = browser;
    }
}
