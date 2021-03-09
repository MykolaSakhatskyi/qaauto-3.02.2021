package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstLesson {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // - либо так
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // путь где лежит вебдравер - либо так

//1.Открыть сайт https://www.saucedemo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com"); // открытие сайта

//2-3.Ввести логин, пароль и залогинится. Сделал как на уроке, через .getText()) не понял как, спросить у Жени

        /*WebElement loginText = driver.findElement(By.xpath("//div[@class='login_credentials']")); // находим блок в котором лежит текст с логинами
        String login = loginText.getText(); // собираем весь текст который там лежит
        System.out.println(login); // выводим текст в консоль, хз как выбрать один из вариантов(спросить у Жени)

        WebElement passwordText = driver.findElement(By.xpath("//div[@class='login_password']")); // находим блок в котором лежит текст с паролем
        String password = passwordText.getText(); // собираем весь текст который там лежит
        System.out.println(password); // выводим текст в консоль, хз как выбрать один из вариантов(спросить у Жени)*/

        // пока напишу как на уроке разбирали
        WebElement usernameField = driver.findElement(By.className("form_input")); // поиск поля юзернейм по класу
        usernameField.sendKeys("standard_user"); // ввод логина в поле юзернейм
        WebElement passwordField = driver.findElement(By.xpath("//input[2]")); // поиск поля пасворд по икспасу
        passwordField.sendKeys("secret_sauce"); // ввод пароля в поле пасворд
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']")); // поиск кнопки логин по икспасу
        loginButton.click(); // жмем кнопку логин

// 4.Добавить в корзину товар под номером 2
        List<WebElement> list = driver.findElements(By.xpath("//button")); // нахождение кнопки добавление
        WebElement addToCart = list.get(3); // выбираем 2 кнопку
        addToCart.click(); // жмем вторую кнопку

//5.Отсортировать товар в обратном порядке
        WebElement filter = driver.findElement(By.className("product_sort_container")); // находми кнопку сортировки
        Select select = new Select(filter);
        List<WebElement> listOfOptions = select.getOptions();

        for(int i = 0; i < listOfOptions.size(); i++) {
            System.out.println(listOfOptions.get(i).getText());
        }

        int indexForReversionFilter = 1;
        select.selectByIndex(indexForReversionFilter);
        select.selectByValue("za");
        select.selectByVisibleText("Name (Z to A)");

//6.Добавить в корзину товар под номером 3
        List<WebElement> liSt = driver.findElements(By.xpath("//button")); // нахождение кнопки добавление
        WebElement addToCarts = liSt.get(4); // выбираем 3 кнопку
        addToCarts.click(); // жмем вторую кнопку

//7.Вылогинится с сайта
        WebElement menu = driver.findElement(By.className("bm-burger-button")); //находим кнопку меню
        menu.click(); // жмем на кнопку меню

        WebElement logout = driver.findElement(By.xpath("(//a)[3]")); //находим кнопку меню
        logout.click(); // жмем на кнопку логаут. Не работает выход чего-то

        driver.quit();  //завершение теста, закрывается тестовое окно, если не писать сожрет весь ресурс пк, если тестов будет много*/

    }
}
