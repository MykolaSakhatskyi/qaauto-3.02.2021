package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPackages.ParentClass;

public class LoginPage extends ParentClass {


    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3")
    public WebElement errorMassage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
