package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 10.03.2016.
 */
public class PostPreviewPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//*[@id='photos']//img")
    public List<WebElement> previewPhotos;

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

    @FindBy(xpath = ".//*[@id='update-ad']")
    public WebElement addPostButton;

    @FindBy(xpath = "*//div[@class='details']/a[@class='name']")
    public WebElement postedAdName;

    public String getTextFromPreviewStepTab(){
        return $(previewStepTab).shouldBe(Condition.visible).getText();
    }

    public int getUploadedPhotosCount(){
        return $$(previewPhotos).size();
    }

    public String getTextFromPreviewPrice(){
        return $(previewPrice).shouldBe(Condition.visible).getText();
    }

    public String getTextFromPreviewSellerName(){
        return $(previewSellerName).shouldBe(Condition.visible).getText();
    }

    public String getTextFromPreviewSellerCity(){
        return $(previewSellerCity).shouldBe(Condition.visible).getText();
    }

    public String getTextFromPreviewDescription(){
        return $(previewDescription).shouldBe(Condition.visible).getText();
    }

    public PostPage clickOnEditButton(){
        $(editButton).shouldBe(Condition.visible).click();
        return new PostPage(driver);
    }

    public SuccessPostedPage clickOnAddPostButton(){
        $(addPostButton).shouldBe(Condition.visible).click();
        return new SuccessPostedPage(driver);
    }

    public SuccessPostedPage clickOnPostedAdName(){
        $(postedAdName).shouldBe(Condition.visible).click();
        return new SuccessPostedPage(driver);
    }

    public PostPreviewPage(WebDriver driver) {
        super(driver);
    }
}
