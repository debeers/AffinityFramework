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

public class TESTAddPostLalafoTJ extends BaseTest {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        //wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void postad() throws InterruptedException {
        //wd.get("http://lalafo.tj/");
        wd.findElement(By.id("post")).click();
        wd.findElement(By.linkText("Интихоби дараҷа")).click();
        wd.findElement(By.xpath("//div[@id='categoryId_chosen']//li[.='Велосипеды']")).click();
        wd.findElement(By.id("title")).click();
        wd.findElement(By.id("title")).clear();
        wd.findElement(By.id("title")).sendKeys("Houston we have a problem");
        wd.findElement(By.id("title")).click();
        wd.findElement(By.id("title")).clear();
        wd.findElement(By.id("title")).sendKeys("Houston we have a problem");
        wd.findElement(By.id("description")).click();
        wd.findElement(By.id("description")).clear();
        wd.findElement(By.id("description")).sendKeys("Houston we have a problem");
        wd.findElement(By.id("price")).click();
        wd.findElement(By.id("price")).clear();
        wd.findElement(By.id("price")).sendKeys("1234");
        wd.findElement(By.linkText("$, US Dollar")).click();
        wd.findElement(By.xpath("//div[@id='currencies_chosen']//li[.='$, US Dollar']")).click();
        wd.findElement(By.id("select2-postadform-city_id-container")).click();
        wd.findElement(By.cssSelector("input.select2-search__field")).click();
        wd.findElement(By.cssSelector("input.select2-search__field")).clear();
        wd.findElement(By.cssSelector("input.select2-search__field")).sendKeys("Хорог");
        wd.findElement(By.cssSelector("input.select2-search__field")).sendKeys(Keys.RETURN);
        wd.findElement(By.cssSelector("span.select2-selection.select2-selection--single")).click();
        wd.findElement(By.cssSelector("span.select2-selection.select2-selection--single")).sendKeys("\n");
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).clear();
        wd.findElement(By.id("username")).sendKeys("Houston");
        wd.findElement(By.id("phone_number")).click();
        wd.findElement(By.id("phone_number")).clear();
        wd.findElement(By.id("phone_number")).sendKeys("+2222222222222");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("lalafotestuser@mail.com");
        wd.findElement(By.id("preview-ad")).click();
        Thread.sleep(2000);
        if (!wd.findElement(By.tagName("html")).getText().contains("Houston we have a problem")) {
            System.out.println("verifyTextPresent failed");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("Шаҳр Хорог")) {
            System.out.println("verifyTextPresent failed");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("$ 1234")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.id("update-ad")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Houston we have a problem")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.linkText("Houston we have a problem")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
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

