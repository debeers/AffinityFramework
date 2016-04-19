package Actions.GENERAL;

import PageObjects.MainPage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 01.04.2016.
 */
public class URLWorker {

    public static void checkForURL(WebDriver driver, String URL, MainPage mainPage){

        driver.get(URL);
        try{
           if(     $(mainPage.addNewPostButtonTop).shouldBe(Condition.visible).isDisplayed()
                   &&
                   $(mainPage.searchField).shouldBe(Condition.visible).isDisplayed())

               System.out.println("URL " + URL + " IS ONLINE");

        }catch (Exception e){
            System.out.println("URL =====>>> " + URL + " <<<===== IS OFFLINE");

        }
    }






}
