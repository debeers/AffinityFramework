package Tests;

import DBUtils.DBConnection;
import Entities.LoginObject;
import GeneralHelpers.Logger;
import com.codeborne.selenide.WebDriverRunner;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static FirefoxDriver driver;
    public static WebDriverWait wait;
    public static String baseUrl;
    public static StringBuffer verificationErrors = new StringBuffer();
    public static LoginObject clientLogin;
    public static org.slf4j.Logger log;
    public static java.sql.Connection jdbcConnection;
    public static BrowserMobProxyServer server;
    public static final String DATA_SOURCE_DIR = System.getProperty("user.dir") +
            "/src/main/java/TESTResources/DataSources/";


    @Parameters({"DB_DRIVER", "DB_CONNECTION", "DB_USER", "DB_PASSWORD"})
    @BeforeSuite(alwaysRun = true)
    public void preCondition(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD)
            throws IOException, ClassNotFoundException, SQLException {

        jdbcConnection = new DBConnection().initDBConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        Registry.Registry.set("dbConnection", jdbcConnection);
        /*server = new BrowserMobProxyServer();
        try {
            server.start();
            int por = server.getPort();
        } catch (Exception e) {
            log.info("We are already using this server");
        }*/
    }

    @Parameters({"URL", "clientLoginParam", "clientPasswordParam"})
    @BeforeTest(alwaysRun = true)
    public void testSetup(String URL, String clientLoginParam, String clientPasswordParam) {

        clientLogin = new LoginObject(clientLoginParam, clientPasswordParam);
        baseUrl = URL;
    }

    @Parameters({"URL", "clientLoginParam", "clientPasswordParam"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String URL, String clientLoginParam, String clientPasswordParam)
            throws ClassNotFoundException, IOException, SQLException, InterruptedException {

        String TestClassName = this.getClass().getName();
        System.out.println(TestClassName);

        log = LoggerFactory.getLogger(Logger.class);

        //Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\Downloaded_Files";
        File downloadDir = new File(path);
        FirefoxProfile fProfile = new FirefoxProfile();
        fProfile.setAcceptUntrustedCertificates(true);
        //fProfile.setPreference("webdriver.load.strategy", "unstable");
        //fProfile.setPreference("network.proxy.http", "http://127.0.0.1");
        //fProfile.setPreference("network.proxy.http_port", 8082);

        fProfile.setPreference("browser.download.dir", downloadDir.getAbsolutePath());
        fProfile.setPreference("browser.download.folderList", 2);
        fProfile.setPreference("browser.download.manager.showWhenStarting", false);
        fProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        fProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
        fProfile.setPreference("network.http.connection-timeout", 5);

        DesiredCapabilities dc = DesiredCapabilities.firefox();
        //dc.setCapability(CapabilityType.PROXY, fProfile);
        dc.setJavascriptEnabled(true);
        dc.setCapability(FirefoxDriver.PROFILE, fProfile);
        dc.setCapability("marionette", true);

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");

        driver = new FirefoxDriver(dc);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterTest(ITestResult result) throws Exception {

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Create reference of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                Calendar calendar = Calendar.getInstance();

                // Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./Screenshots/"
                        + "_"
                        + result.getName()
                        + "_"
                        + calendar.get(Calendar.MONTH)
                        + "_"
                        + calendar.get(Calendar.DAY_OF_MONTH)
                        + "_"
                        + calendar.get(Calendar.HOUR_OF_DAY)
                        + "_"
                        + calendar.get(Calendar.MINUTE)
                        + "_"
                        + calendar.get(Calendar.SECOND)
                        + ".png"));

                System.out.println("Screenshot taken");
            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        } else {
        driver.manage().deleteAllCookies();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
        }
        driver.quit();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        /*try {

            Calendar calendar = Calendar.getInstance();
            Har har = server.getHar();

            File file = new File("./HarReports/" + "Test"
                    + "_"
                    + calendar.get(Calendar.MONTH)
                    + "_"
                    + calendar.get(Calendar.DAY_OF_MONTH)
                    + "_"
                    + calendar.get(Calendar.HOUR_OF_DAY)
                    + "_"
                    + calendar.get(Calendar.MINUTE)
                    + "_"
                    + calendar.get(Calendar.SECOND)
                    + ".har");

            FileOutputStream fos = new FileOutputStream(file);
            try {
                har.writeTo(fos);
            } catch (IOException e) {
                log.info("HOUSTON, WE HAVE A PROBLEM - INFO WAS NOT WRITTEN INTO HAR FILE:::" + file);
            }
        } catch (Exception e) {
            log.info("HOUSTON, WE HAVE A PROBLEM - DEBUG PLEASE TO CHECK IF A HAR FILE WAS CREATED");
        }
*/
        /*if (driver.getCurrentUrl() != baseUrl) {
            driver.get(baseUrl + "user/logout");
        }*/


    }

    @AfterSuite
    public void terminate() throws Exception {


        /*if (!server.isStopped()) {
            server.stop();
        } else {
            log.info("Server is already stopped");

        }*/
        if (!jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }

    }
}
