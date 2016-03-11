package GeneralHelpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by DeBeers on 11.03.2016.
 */
public class JSTools {

    public static void jsDeleteClasses(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementById('currencies').style.display = 'block';";
        js.executeScript(script);
    }
}
