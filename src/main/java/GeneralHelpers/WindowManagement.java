package GeneralHelpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class WindowManagement {

    public static void windowScale(WebDriver driver, String size, int count){

        Actions builder = new Actions(driver);
        if(size.equals("-")){
            for(int i = 0; i<=count; i++) {
                builder.sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();
            }
            System.out.println("Scale '-' for " +count+ "times");

        }else {
            for (int i = 0; i <= count; i++) {
                builder.sendKeys(Keys.chord(Keys.CONTROL, "+")).perform();
            }
            System.out.println("Scale '+' for " + count + " times");
        }

    }


}
