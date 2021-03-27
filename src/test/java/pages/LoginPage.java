package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    private String logCorrect;
    private String logIncorrect;
    private String pass;
    String mistake;

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

        mistake = errorMassage.getText();
        chooseTruelogin(mistake);
    }

    public void loginFalse() {
        usernameField.sendKeys("Типа логин");
        passwordField.sendKeys("Типа пароль");
        loginButton.click();

        WebElement errorMassage = driver.findElement(By.xpath("//h3"));
        mistake = errorMassage.getText();
        chooseTruelogin(mistake);
    }

    private void chooseTruelogin(String mistake) {
        if (mistake.equals("Epic sadface: Username and password do not match any user in this service")) {
            valuesToEnter();
            usernameField.clear();
            usernameField.sendKeys(logIncorrect);
            passwordField.clear();
            passwordField.sendKeys(pass);}
        else if (mistake.equals("Epic sadface: Sorry, this user has been locked out.")) {
            valuesToEnter();
            usernameField.clear();
            usernameField.sendKeys(logCorrect);}
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
