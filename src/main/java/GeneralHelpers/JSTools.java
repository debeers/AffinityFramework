package GeneralHelpers;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by DeBeers on 11.03.2016.
 */
public class JSTools {

    public static void jsDeleteClassesById(WebDriver driver, String elementId) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementById('"+elementId+"').style.display = 'block';";
        js.executeScript(script);
    }

    public static void jsDisplayNegotiableCheckbox(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementsByClassName('label-check')[0].className += ' checked';";
        js.executeScript(script);
    }

    public static void jsDeleteClassesByClass(WebDriver driver, String classname) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementsByClassName('"+classname+"').style.display = 'block';";
        js.executeScript(script);
    }

    public static void jsEnableSelectDropdown(WebDriver driver, String idOfTheElement) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementById('"+idOfTheElement+"').style.display = 'block';";
        js.executeScript(script);
    }

    public static void jsDisableZopim(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "$('.zopim').remove();";
        js.executeScript(script);
    }

    public static void jsDisableDropdownCompactView(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "$('#categoryId_chosen .chosen-results')[0].style.maxHeight = \"5000px\";";
        js.executeScript(script);
    }

    public static void jsDisableDropdownCompactViewForSubcategories(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "$('#1_subcategory_chosen .chosen-results')[0].style.maxHeight = \"5000px\";";
        js.executeScript(script);
    }

    public static void jsSelectUndercategory(WebDriver driver, String value, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var value = $(\"" + value + "+select\").find('option:contains(\"" + text + "\")').val();" +
                "$(\"" + value + "\").select2(\"val\", value);");

    }
}
