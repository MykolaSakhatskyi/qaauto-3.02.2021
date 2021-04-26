package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parentPackages.ParentClass;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends ParentClass {

    private final SelenideElement usernameField = $(By.id("user-name"));

    private final SelenideElement passwordField = $(By.id("password"));

    private final SelenideElement loginButton = $(By.id("login-button"));

    private final SelenideElement errorMassage = $(By.xpath("//h3"));

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
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");
        if (passedValues == "usernameFieldIsEmpty")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Username is required","Error massage has mistake");
        if (passedValues == "passwordFieldIsEmpty")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Paseeeesword is required","Error massage has mistake");
        if (passedValues == "wrongValues")
            Assert.assertEquals(errorMassage.getText(),"Epic sadface: Username and password do not match any user in this service","Error massage has mistake");
    }

}
