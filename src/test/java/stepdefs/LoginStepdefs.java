package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.Также;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static page.AbstractPage.getPageByTitle;
import static page.AbstractPage.getUrlByTitle;
import static test.strings.userLogin;
import static test.strings.userPassword;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginStepdefs {

    @И("начинаем тест")
    public void начинаемТест() {
        System.out.println("Тест начат");
    }

    @И("открываем страницу {string}")
    public void открываемСайт(String site) throws ClassNotFoundException, InterruptedException  {
        open(getUrlByTitle(site));
    }

    @И("на странице {string} находим кнопку {string}")
    public void находимКнопкуВойти(String str, String nameEL) throws ClassNotFoundException,InterruptedException {
        getPageByTitle(str).getElementByName(nameEL).click();
    }

    @Затем("на странице {string} ввести логин {string}")
    public void вводимЛогин(String str, String login) throws ClassNotFoundException, InterruptedException {
        getPageByTitle(str).getElementByName(login).val(userLogin);

    }

    @Также("на странице {string} ввести пароль {string}")
    public void вводимПароль(String str, String pass) throws ClassNotFoundException, InterruptedException {
        getPageByTitle(str).getElementByName(pass).val(userPassword).pressEnter();
    }


    @И("на странице {string} проверить наличие иконки {string}")
    public void проверяемАвторизацию(String str, String icon) throws ClassNotFoundException, InterruptedException {
        System.out.println("Проверяем авторизацию");
        getPageByTitle(str).getElementByName(icon).should(Condition.image);
    }

}
