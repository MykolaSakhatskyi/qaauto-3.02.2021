package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import parentPackages.ParentClass;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPage extends ParentClass {

    private final SelenideElement menuButton = $(By.id("react-burger-menu-btn"));

    private final SelenideElement logoutButton = $(By.id("logout_sidebar_link"));

    private final SelenideElement confirmingClass = $(By.className("title"));

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        menuButton.click();
        Configuration.timeout = 10000; // не ждет это время
        logoutButton.should(Condition.enabled);
        logoutButton.click();
    }

    public SelenideElement getConfirmingClass() {
        return confirmingClass;
    }

}
