package homework;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import parentPackages.BeforeAfterMethods;

@Feature("Test")
@Story("Positive")
public class LoginPositiveTest extends BeforeAfterMethods {

    @DataProvider(name = "valuesToEnter")
    private Object[][] valuesToEnter() {
        String password = "secret_sauce";
        return new Object[][]{{"standard_user",password},{"pblem_user",password},{"performance_glitch_user",password}};
    }

    @Link(url = "https://google.com", name = "GOOGLE")
    @Test(dataProvider = "valuesToEnter")
    public void loginWithDifferentUserNames(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.setLoginButton();
        InventoryPage logoutAct = new InventoryPage(driver);
        String confirmingText = logoutAct.getConfirmingClass().getText();
        Assert.assertEquals(confirmingText,"PRODUCTS");
    }
}
