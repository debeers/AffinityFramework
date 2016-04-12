package GeneralHelpers;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class DropdownMenuWorker {


    public static void selectFromDropdawnMenuByIndex(WebElement element, List<WebElement> list, String index)
            throws InterruptedException {

        $(element).shouldBe(visible).click();
        Thread.sleep(1000);
        try {
            list
                    .stream()
                    .filter(el -> el.getAttribute("data-option-array-index").equals(index))
                    .forEach(el -> $(el).shouldBe(visible).click());
        }catch (Exception e){
            System.out.println("We`re catched Stale element ApiWorker.exception, but fuck it!)");
        }
    }



}
