package homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import parentPackages.BeforeAfterMethods;

public class LoginNegativeTest extends BeforeAfterMethods {

    @Test
    public void lesson() {
        LoginPage loginPage = new LoginPage(driver);
        softAssert.assertEquals(getErrorTextOrEmpty(loginPage.errorMassage),"","Error massage is displayed on login page");
        loginPage.loginWithoutEmailAndPassword();
        softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");

        loginPage.logonWithoutEmail();
        softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");

        loginPage.logonWithoutPassword();
        softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Password is required","Error massage has mistake");

        loginPage.logonWithIncorrectValues();
        softAssert.assertEquals(loginPage.errorMassage.getText(),"Epic sadface: Username and password do not match any user in this service","Error massage has mistake");

        softAssert.assertAll();

    }
}