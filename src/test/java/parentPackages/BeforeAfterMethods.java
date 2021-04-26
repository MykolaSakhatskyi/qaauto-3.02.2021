/*package parentPackages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public abstract class BeforeAfterMethods {

    public static ThreadLocal<WebDriver> treadLocalWebDriver = new ThreadLocal<>();
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void start() {
        PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setDriverForScreenshotParentClass();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void endTest() {
        softAssert.assertAll();
        driver.quit();
    }

    private void setDriverForScreenshotParentClass() {
        treadLocalWebDriver.set(driver);
    }
}*/
