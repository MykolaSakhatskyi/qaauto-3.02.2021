package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import parentPackages.ParentClass;

public class LoginPage extends ParentClass {


    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")
    private WebElement errorMassage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    @Step
    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    @Step
    public void setLoginButton() {
        loginButton.click();
    }

    @Step
    public void setErrorMassage(String passedValues) {
        if (passedValues == "emptyFields")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Userndwdame is required","Error massage has mistake");
        if (passedValues == "usernameFieldIsEmpty")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");
        if (passedValues == "passwordFieldIsEmpty")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Password is required","Error massage has mistake");
        if (passedValues == "wrongValues")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Username and password do not match any user in this service","Error massage has mistake");
    }

}
