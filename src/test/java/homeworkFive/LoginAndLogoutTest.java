package homeworkFive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import parentPackages.ParentClass;

public class LoginAndLogoutTest extends ParentClass {

    @Test
    public void lesson() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        WebElement confirmingClass = driver.findElement(By.className("product_label"));
        String confirmingText = confirmingClass.getText();
        Assert.assertEquals(confirmingText,"Products");

        InventoryPage logoutAct = new InventoryPage(driver);
        logoutAct.logout();
    }
}
