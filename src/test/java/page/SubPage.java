    package page;

    import com.codeborne.selenide.SelenideElement;
    import org.openqa.selenium.By;
    import page.annotations.Element;
    import page.annotations.Page;

    import static com.codeborne.selenide.Selenide.$;

    @Page(title = "Страница подписок", url =  "https://dev.n7lanit.ru/subscribed/")
    public class SubPage extends AbstractPage{


        @Element("Отписаться")
        public SelenideElement unsubscribe(){
            return $(By.xpath("//div[@class='col-xs-12 hidden-xs hidden-sm']//*[@class='btn-group open']//button//span[text()='star_border']/.."));
        }


    }
