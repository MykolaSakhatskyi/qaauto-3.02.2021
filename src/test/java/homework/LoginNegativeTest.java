package homework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import parentPackages.BeforeAfterMethods;

public class LoginNegativeTest extends BeforeAfterMethods {

    @DataProvider(name = "valuesToEnter")
    private Object[][] valuesToEnter() {
        String password = "secret_sauce";
        return new Object[][]{{"","","emptyFields"},{"",password,"usernameFieldIsEmpty"},{"standard_user","","passwordFieldIsEmpty"},
                {"wrong_username","wrong_password","wrongValues"}};
    }

    @Test(dataProvider = "valuesToEnter")
    public void loginWithDifferentUserNames(String username, String password, String passedValues) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
        if (passedValues == "emptyFields")
            softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");
        if (passedValues == "usernameFieldIsEmpty")
            softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");
        if (passedValues == "passwordFieldIsEmpty")
            softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Password is required","Error massage has mistake");
        if (passedValues == "wrongValues")
            softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Username and password do not match any user in this service","Error massage has mistake");
    }


}