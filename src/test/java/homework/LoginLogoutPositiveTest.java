package homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import parentPackages.BeforeAfterMethods;


public class LoginLogoutPositiveTest extends BeforeAfterMethods {

    @Test
    public void lesson() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPositive();

        InventoryPage logoutAct = new InventoryPage(driver);
        String confirmingText = logoutAct.getConfirmingClass().getText();
        Assert.assertEquals(confirmingText,"PRODUCTS");

        logoutAct.logout();
        Assert.assertFalse(driver.getCurrentUrl().contains("/inventory.html"),"User is not logout");
    }
}
