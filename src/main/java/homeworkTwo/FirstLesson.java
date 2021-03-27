package homeworkTwo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstLesson {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement loginText = driver.findElement(By.id("login_credentials"));
        String login = loginText.getText();
        String[] log = login.split("\n");
        usernameField.sendKeys(log[1]);

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement passwordText = driver.findElement(By.className("login_password"));
        String password = passwordText.getText();
        String[] pass = password.split("\n");
        passwordField.sendKeys(pass[1]);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

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

        driver.quit();

    }
}
