package Tests.GUITests.TESTAddPost;

/**
 * Created by Dem on 12.10.2016.
 */
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TESTAddPostLalafoAF extends BaseTest {
    //FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void lalafoAF() throws InterruptedException {
        //driver.get("http://lalafo.af/");
        driver.findElement(By.id("post")).click();
        driver.findElement(By.linkText("Select a category")).click();
        driver.findElement(By.xpath("//div[@id='categoryId_chosen']//li[.='Garden & Patio Furniture']")).click();
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("sadasdasd");
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("asdasdasd");
        driver.findElement(By.id("price")).click();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("78");
        driver.findElement(By.linkText("US$, US Dollar")).click();
        driver.findElement(By.xpath("//div[@id='currencies_chosen']//li[.='US$, US Dollar']")).click();
        driver.findElement(By.id("select2-postadform-city_id-container")).click();
        driver.findElement(By.cssSelector("input.select2-search__field")).click();
        driver.findElement(By.cssSelector("input.select2-search__field")).clear();
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("Kandahar");
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single")).click();
        driver.findElement(By.cssSelector("span.select2-selection.select2-selection--single")).sendKeys("\n");
        if (!driver.findElement(By.id("advert_type_2")).isSelected()) {
            driver.findElement(By.id("advert_type_2")).click();
        }
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("adam");
        driver.findElement(By.id("phone_number")).click();
        driver.findElement(By.id("phone_number")).clear();
        driver.findElement(By.id("phone_number")).sendKeys("+2222222222222");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("adam@gmail.com");
        Thread.sleep(1500);
        driver.findElement(By.id("preview-ad")).click();
        Thread.sleep(2500);
        driver.findElement(By.id("update-ad")).click();
        Thread.sleep(7000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

