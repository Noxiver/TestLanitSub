package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import page.annotations.Page;

import static com.codeborne.selenide.Selenide.*;
import page.annotations.Element;


@Page(title = "Главная страница", url = "https://dev.n7lanit.ru")
public class MainPage extends AbstractPage {

    @Element("Войти")
    public SelenideElement NavigationBarSignIn() {
        return  $(By.xpath("//button[contains(text(), 'Войти')]/..")).should(Condition.visible);
    }

    @Element("Иконка")
    public SelenideElement checkVisibilityIcons(){
        return $(By.xpath("//*[@id=\"user-menu-mount\"]/ul/li[3]/a/img")).should(Condition.visible);
    }

    @Element("Кнопка подписывания")
    public SelenideElement subscribeMenu(){
        ElementsCollection collection=  $$(By.xpath(
                "//*[@class='list-group-item thread-new']//*[@class='col-sm-2 col-md-2 hidden-xs']//div[@class='col-xs-12 hidden-xs hidden-sm']//*[@class='btn-group']/button"));
        return collection.get((int) (collection.size()*Math.random()));
    }

    @Element("Подписаться")
    public SelenideElement subscribe(){
        return $(By.xpath("//div[@class='col-xs-12 hidden-xs hidden-sm']//*[@class='btn-group open']//button//span[text()='star_half']/.."));
    }

    @Element("Выбранный топик")
    public SelenideElement selectedTopic(){
        return $(By.xpath("//*[@class='btn-group open']/button/ancestor::div[6]//a[@class='item-title thread-title']"));
    }

    @Element("Подписки")
    public SelenideElement subscribed(){
        return $(By.xpath("//ul[@class='nav nav-pills']//a[text()='Подписки']"));
    }



}
