package homeworkFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentClass {

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private String log;
    private String pass;
    private String mistake;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernameField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));
    }

    public void login() {
        usernameField.sendKeys("Типа логин");
        passwordField.sendKeys("Типа пароль");
        loginButton.click();

        WebElement errorMassage = driver.findElement(By.xpath("//h3"));
        mistake = errorMassage.getText();
        chooseTruelogin(mistake);
    }

    private void chooseTruelogin(String mistake) {
        if (mistake.contains("Epic sadface: Username and password do not match any user in this service")) {
            valuesToEnter();
            usernameField.clear();
            usernameField.sendKeys(log);
            passwordField.clear();
            passwordField.sendKeys(pass);
        }
        loginButton.click();
    }

    public void valuesToEnter() {
        String loginClass = "login_credentials";
        String passwordClass = "login_password";
        int indexLoginPassword = 1;

        log = getLoginPassword(loginClass, indexLoginPassword);
        pass = getLoginPassword(passwordClass, indexLoginPassword);
    }

    private String getLoginPassword(String className, int index) {
        WebElement values = driver.findElement(By.className(className));
        String[] valuesLoginPassword = values.getText().split("\n");

        return  valuesLoginPassword[index];
    }
}
