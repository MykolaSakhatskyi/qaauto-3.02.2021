package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstLesson {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

//1.Открыть сайт https://www.saucedemo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

//2-3.Ввести логин, пароль и залогинится.

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement loginText = driver.findElement(By.id("login_credentials"));
        String login = loginText.getText();
        String[] log = login.split("\n");
        usernameField.sendKeys(log[1]);

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement passwordText = driver.findElement(By.className("login_password"));
        String password = passwordText.getText();
        String[] pass = password.split("\n");
        passwordField.sendKeys(pass[1]);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

// 4.Добавить в корзину товар под номером 2
        List<WebElement> list = driver.findElements(By.xpath("//button"));
        WebElement addToCart = list.get(3);
        addToCart.click();

//5.Отсортировать товар в обратном порядке
        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);
        select.selectByVisibleText("Name (Z to A)");

//6.Добавить в корзину товар под номером 3
        List<WebElement> newlist = driver.findElements(By.xpath("//button"));
        WebElement addToCarts = newlist.get(4);
        addToCarts.click();

//7.Вылогинится с сайта
        WebElement menu = driver.findElement(By.className("bm-burger-button"));
        menu.click();

        WebElement logout = driver.findElement(By.id("react-burger-menu-btn"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); //неявное ожидание 1 секунда
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //явное ожидание 1 секунда, но так чего-то не сработало
        logout.click();

        driver.quit();

    }
}
