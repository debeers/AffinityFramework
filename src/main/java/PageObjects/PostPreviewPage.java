package PageObjects;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 10.03.2016.
 */
public class PostPreviewPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//*[@id='photos']//img")
    public List<WebElement> previewPhotos;

    @FindBy(xpath = ".//*[@id='second-step']/div/h3")
    public WebElement previewTitle;

    @FindBy(xpath = ".//ul[contains(@class,'posting-steps')]/li[contains(@class,'step-2 active')]")
    public WebElement previewStepTab;

    @FindBy(xpath = ".//*[@id='price-val']/span")
    public WebElement previewPrice;

    @FindBy(xpath = ".//*[@id='second-step']//dd[2]")
    public WebElement previewSellerName;

    @FindBy(xpath = ".//*[@id='second-step']//dd[3]")
    public WebElement previewSellerCity;

    @FindBy(xpath = ".//*[@id='second-step']//p")
    public WebElement previewDescription;

    @FindBy(xpath = ".//*[@id='edit-ad']")
    public WebElement editButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addPostButton;

    public final By addPost = By.xpath("//button[@type='submit']");

    @FindBy(xpath = "*//div[@class='details']/a[@class='name']")
    public WebElement postedAdName;

    public String getTextFromPreviewStepTab(){
        return $(previewStepTab).
                shouldBe(Condition.visible).
                getText();
    }

    public int getUploadedPhotosCount(){
        return $$(previewPhotos).size();
    }

    public String getTextFromPreviewPrice(){
        return $(previewPrice).
                shouldBe(Condition.visible).
                getText();
    }

    public String getTextFromPreviewSellerName(){
        return StringUtils.substringBefore($(previewSellerName).
                shouldBe(Condition.visible).getText(), "\n").trim();
    }

    public String getTextFromPreviewSellerCity(){
        return $(previewSellerCity).
                shouldBe(Condition.visible).
                getText();
    }

    public String getTextFromPreviewDescription(){
        return $(previewDescription).
                shouldBe(Condition.visible).
                getText();
    }

    public String getTextFromTitle(){
        return $(previewTitle).
                shouldBe(Condition.visible).
                getText();
    }

    public PostPage clickOnEditButton(){
        $(editButton).
                shouldBe(Condition.visible).
                click();
        return new PostPage(driver);
    }

    public SuccessPostedPage clickOnAddPostButton() throws InterruptedException, AWTException {
        driver.findElement(By.id("update-ad")).click();
        /*$(addPostButton).
                shouldBe(Condition.visible).hover().click();*/
        return new SuccessPostedPage(driver);
    }

    public YourPostPage clickOnPostedAdName(){
        $(postedAdName).
                shouldBe(Condition.visible).
                click();
        return new YourPostPage(driver);
    }

    public PostPreviewPage(WebDriver driver) {
        super(driver);
    }
}
