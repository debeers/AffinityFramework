
package PageObjects;

import GeneralHelpers.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

/**
 * Created by CMG_TEST on 31.08.2015.
 */
public abstract class BasePageObject implements BasePageObjectInterface{

    protected static WebDriver driver;
    protected static org.slf4j.Logger log;

    public WebDriver getDriver() {
        return driver;
    }

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.init(driver);
        log = LoggerFactory.getLogger(Logger.class);
    }

    protected void init(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
}