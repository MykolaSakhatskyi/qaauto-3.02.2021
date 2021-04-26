package homework;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import parentPackages.BaseTest;


@Feature("Test")
@Story("Negative")
public class LoginNegativeTest extends BaseTest {

    @DataProvider(name = "valuesToEnter")
    private Object[][] valuesToEnter() {
        String password = "secret_sauce";
        return new Object[][]{{"","","emptyFields"},{"",password,"usernameFieldIsEmpty"},{"standard_user","","passwordFieldIsEmpty"},
                {"wrong_username","wrong_password","wrongValues"}};
    }

    @Test(dataProvider = "valuesToEnter")
    public void loginWithDifferentUserNames(String username, String password, String passedValues) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.setLoginButton();
        loginPage.setErrorMassage(passedValues);
    }


}