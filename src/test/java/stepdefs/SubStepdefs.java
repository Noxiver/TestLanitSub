package stepdefs;

import com.codeborne.selenide.Condition;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static page.AbstractPage.getPageByTitle;

public class SubStepdefs {
    List<String> subscribes = new ArrayList<>(); //лист с подписками, в который мы будем скидывать href тех тем, на которые мы подпишемся для дальнейшего сравнивания

    @И("на странице {string} нажать на кнопку подписывания {string}")
    public void нажатьНаКнопкуПодписывания(String str, String inactive) throws ClassNotFoundException, InterruptedException {
        Thread.sleep(1000);
        getPageByTitle(str).getElementByName(inactive).click();

        subscribes.add(getPageByTitle(str).getElementByName("Выбранный топик").getAttribute("href").replaceAll("https:\\/\\/dev.n7lanit.ru",""));
    }


    @И("на странице {string} в меню нажать {string}")
    public void наВВыпадающемМенюНажать(String str, String sub) throws ClassNotFoundException, InterruptedException {
        Thread.sleep(1000);
        getPageByTitle(str).getElementByName(sub).should(visible).click();
    }

    @И("на странице {string} нажать на кнопку {string}")
    public void нажатьНаКнопкуПодписки(String str, String subscribes) throws ClassNotFoundException, InterruptedException {
        Thread.sleep(1000);
        getPageByTitle(str).getElementByName(subscribes).should(visible).click();
    }


    @И("Проверить наличии ранее подписаных")
    public void проверитьЧтоЕстьРанееПодписанные() throws InterruptedException, ClassNotFoundException {
        Thread.sleep(1000);

        for(int i =0; i < subscribes.size(); i++){
            String s = subscribes.get(i);
            $(By.xpath("//*[@href='"+ s +"']")).should(Condition.visible);
        }
        Thread.sleep(3000);
    }

    @И("на странице {string} {string} от ранее подписаных тем")
    public void отписатьсяОтПодписаныхРанее(String str, String unsubscribe) throws ClassNotFoundException, InterruptedException {
        Thread.sleep(1000);

        for(int i =0; i < subscribes.size(); i++){
            String s = subscribes.get(i);
            $(By.xpath("//*[@href='"+ s +"']/ancestor::div[4]//*[@class='col-sm-2 col-md-2 hidden-xs']//*[@class='col-xs-12 hidden-xs hidden-sm']" +
                    "//button[@type='button']")).click();
            getPageByTitle(str).getElementByName(unsubscribe).click();
        }

    }

    @Затем("повторить шаги")
    public void повторитьШаги() {
    }
}