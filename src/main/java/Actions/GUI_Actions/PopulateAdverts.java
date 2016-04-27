package Actions.GUI_Actions;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 27.04.2016.
 */
public class PopulateAdverts {

    public static boolean checkIfElementContainsText(WebElement element, String text) {
        return $(element).shouldBe(visible).getText().contains(text);
    }

    public static List<String> populateAdverts(List<WebElement> elements, By element, Properties props) {
        List<String> returnSimpleAdvertsPrices = new ArrayList<>();
        elements.stream().forEach((simple) -> {
            if (simple.findElement(element).isDisplayed()) {
                if (checkIfElementContainsText($(element) , props.getProperty("localCurrency"))) {
                    returnSimpleAdvertsPrices.add(simple.getText());
                    System.out.println("CURRENT PRICE FORMAT IS:::  " + simple.findElement(element).getText());
                } else if (checkIfElementContainsText($(element) , props.getProperty("usdCurrency"))) {
                    returnSimpleAdvertsPrices.add(simple.getText());
                    System.out.println("CURRENT PRICE FORMAT IS:::  " + simple.findElement(element).getText());
                } else if (checkIfElementContainsText($(element) , props.getProperty("negotiablePrice"))) {
                    returnSimpleAdvertsPrices.add(simple.getText());
                    System.out.println("CURRENT PRICE FORMAT IS:::  " + simple.findElement(element).getText());
                } else {
                    System.out.println("WE HAVE GOT AN ERROR ON THE CURRENT ADVERT:::" + simple.getText());
                }

            } else {
                System.out.println("WE HAVE GOT ERRORS WHILE LOOKING FOR ADVERTS");
            }
        });
        return returnSimpleAdvertsPrices;
    }

    public static List<String> pullListText(ElementsCollection elements) {
        List <String> returnAdvertsListWithText = new ArrayList<>();
        elements.stream().forEach((el) -> {
            if (el.isDisplayed()) {
                returnAdvertsListWithText.add(el.getText());
            } else {
                System.out.println("HOUSTON WE HAVE A PROBLEM");
            }
        });
        return returnAdvertsListWithText;
    }
}
