package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }
}
