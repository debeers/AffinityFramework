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

    public static void jsSelectUndercategory(WebDriver driver, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var selectobject=document.getElementById(\"subcategory_2\")\n" +
                "\n" +
                "for (var i=0; i<selectobject.length; i++){\n" +
                "\n" +
                "  if (selectobject.options[i].value == '"+value+"') {\n" +
                "\n" +
                "     selectobject.options[i].setAttribute('selected',\"\")\n" +
                "\n" +
                "  }\n" +
                "\n" +
                "}";
        js.executeScript(script);

    }
}
