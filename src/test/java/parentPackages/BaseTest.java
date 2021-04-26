package parentPackages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void start() {
        PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Selenide.open("");
        driver = WebDriverRunner.getWebDriver();
    }
}
