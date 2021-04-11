package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPackages.ParentClass;

public class LoginPage extends ParentClass {


    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")
    public WebElement errorMassage;

    private String logCorrect;
    private String logIncorrect;
    private String pass;
    private String mistake;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginPositive() {
        valuesToEnter();
        usernameField.sendKeys(logCorrect);
        passwordField.sendKeys(pass);
        loginButton.click();
    }

    public void loginWithoutEmailAndPassword() {
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        loginButton.click();
    }

    public void logonWithoutEmail() {
        valuesToEnter();
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        usernameField.clear();
        passwordField.clear();
        passwordField.sendKeys("");
        loginButton.click();
    }

    public void logonWithoutPassword() {
        valuesToEnter();
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        passwordField.clear();
        usernameField.clear();
        usernameField.sendKeys(logCorrect);
        loginButton.click();
    }

    public void logonWithIncorrectValues() {
        valuesToEnter();
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        passwordField.clear();
        usernameField.clear();
        usernameField.sendKeys(logIncorrect);
        passwordField.sendKeys("uiiii");
        loginButton.click();
    }

    public void valuesToEnter() {
        String loginClass = "login_credentials";
        String passwordClass = "login_password";
        int indexCorrectLoginPassword = 1;
        int indexIncorrectLogin = 2;

        logCorrect = getLoginPassword(loginClass, indexCorrectLoginPassword);
        logIncorrect = getLoginPassword(loginClass, indexIncorrectLogin);
        pass = getLoginPassword(passwordClass, indexCorrectLoginPassword);
    }

    private String getLoginPassword(String className, int index) {
        WebElement values = driver.findElement(By.className(className));
        String[] valuesLoginPassword = values.getText().split("\n");

        return  valuesLoginPassword[index];
    }

}
