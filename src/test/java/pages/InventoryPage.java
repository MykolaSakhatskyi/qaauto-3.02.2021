package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPackages.ParentClass;

import java.util.concurrent.TimeUnit;

public class InventoryPage extends ParentClass {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(className = "title")
    private WebElement confirmingClass;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        menuButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        logoutButton.click();
    }

    public WebElement getConfirmingClass() {
        return confirmingClass;
    }

}
