package homework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import parentPackages.BeforeAfterMethods;


public class LoginPositiveTest extends BeforeAfterMethods {

    @DataProvider(name = "valuesToEnter")
    private Object[][] valuesToEnter() {
        String password = "secret_sauce";
        return new Object[][]{{"standard_user",password},{"problem_user",password},{"performance_glitch_user",password}};
    }

    @Test(dataProvider = "valuesToEnter")
    public void loginWithDifferentUserNames(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
        InventoryPage logoutAct = new InventoryPage(driver);
        String confirmingText = logoutAct.getConfirmingClass().getText();
        Assert.assertEquals(confirmingText,"PRODUCTS");
    }
}
