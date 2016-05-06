package Actions.GUI_Actions;

import com.codeborne.selenide.ElementsCollection;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 28.04.2016.
 */
public class TrimAdvertIDFromTitle {

    public static String getIdAttributeFromAdvertTitle(WebElement element) {
        return $(element).shouldBe(visible).getAttribute("id");
    }

    public static String trimAdvertToGetItsId(WebElement element, Properties props) {
        return StringUtils.substringAfter(getIdAttributeFromAdvertTitle(element), props.getProperty("separator"));
    }

    public static List<String> stackAllIDsToTheList(ElementsCollection elements, Properties props) {
        List<String> listOfIDs = new ArrayList<>();
        if (!elements.isEmpty()) {
            elements.stream().forEach((el) -> listOfIDs.add((trimAdvertToGetItsId(el, props))));
        } else {
            System.out.println("We have got some errors while parsing IDs to the list");
        }
        return listOfIDs;
    }
}
