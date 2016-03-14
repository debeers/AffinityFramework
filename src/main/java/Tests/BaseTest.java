package Tests;

import Entities.LoginObject;
import GeneralHelpers.Logger;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String baseUrl;
    public static StringBuffer verificationErrors = new StringBuffer();
    public static LoginObject clientLogin;
    public static org.slf4j.Logger log;

    @BeforeSuite(alwaysRun = true)
    public void preCondition() throws IOException, ClassNotFoundException, SQLException {

        //DB section
    }

    @Parameters({"URL", "clientLoginParam", "clientPasswordParam"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String URL, String clientLoginParam, String clientPasswordParam, String mainTitleRU)
            throws ClassNotFoundException, IOException, SQLException {

        String TestClassName = this.getClass().getName();
        System.out.println(TestClassName);

        clientLogin      = new LoginObject(clientLoginParam, clientPasswordParam);
        baseUrl          = URL;
        log              = LoggerFactory.getLogger(Logger.class);

        String path = System.getProperty("user.dir") + "\\src\\main\\java\\Downloaded_Files";
        File downloadDir = new File(path);
        FirefoxProfile fProfile = new FirefoxProfile();
        fProfile.setAcceptUntrustedCertificates(true);
        fProfile.setPreference("browser.download.dir", downloadDir.getAbsolutePath());
        fProfile.setPreference("browser.download.folderList", 2);
        fProfile.setPreference("browser.download.manager.showWhenStarting", false);
        fProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        fProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");

        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setJavascriptEnabled(true);
        dc.setCapability(FirefoxDriver.PROFILE, fProfile);

        driver = WebDriverFactory.getDriver(dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);


        try {
            driver.get(URL);
            Assert.assertTrue(driver.getCurrentUrl().contains(URL), "We are not on main page!"
                    + driver.getCurrentUrl() + "  " + "But expected:::: " + URL);
        }catch (Exception e){
            System.out.println("<<<<< We are not on the MAIN PAGE >>>>>");
        }
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {

        if (driver.getCurrentUrl() != baseUrl) {
            driver.get("http://lalafo.az/ru/user/logout");
        }

        driver.manage().deleteAllCookies();
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
}