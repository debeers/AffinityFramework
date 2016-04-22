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

    public static void jsDeleteClassesByClass(WebDriver driver, String classname) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementsByClassName('"+classname+"').style.display = 'block';";
        js.executeScript(script);
    }

    public static void jsDisableZopim(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "$('.zopim').remove();";
        js.executeScript(script);
    }



}
