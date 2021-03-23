package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomeWorkTree {

    private WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private String[] log;
    private String[] pass;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void loginToPage() {
        usernameField = driver.findElement(By.id("user-name"));
        WebElement loginText = driver.findElement(By.id("login_credentials"));
        String login = loginText.getText();
        log = login.split("\n");

        passwordField = driver.findElement(By.id("password"));
        WebElement passwordText = driver.findElement(By.className("login_password"));
        String password = passwordText.getText();
        pass = password.split("\n");

        loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement message = driver.findElement(By.xpath("//h3"));

        while (!driver.getCurrentUrl().contains("inventory"))
            chooseTruelogin(message.getText());

        List<WebElement> list = driver.findElements(By.xpath("//button"));
        WebElement addToCart = list.get(3);
        addToCart.click();

        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);
        select.selectByVisibleText("Name (Z to A)");

        List<WebElement> newlist = driver.findElements(By.xpath("//button"));
        WebElement addToCarts = newlist.get(4);
        addToCarts.click();

        WebElement menu = driver.findElement(By.className("bm-burger-button"));
        menu.click();

        WebElement logout = driver.findElement(By.id("react-burger-menu-btn"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        logout.click();
    }

    /*@AfterMethod
    public void endTest() {
        driver.quit();
    } */

    private void chooseTruelogin(String errorMessage) {
            if (errorMessage.contains("Epic sadface: Username is required"))
                usernameField.sendKeys(log[2]);
            else if (errorMessage.contains("Epic sadface: Password is required"))
                passwordField.sendKeys(pass[1]);
            else if (errorMessage.contains("Epic sadface: Sorry, this user has been locked out.")) {
                usernameField.clear();
                usernameField.sendKeys(log[1]);
            }
            loginButton.click();
        }

}
