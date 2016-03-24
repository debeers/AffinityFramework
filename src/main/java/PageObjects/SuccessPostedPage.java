package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 10.03.2016.
 */
public class SuccessPostedPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//*[@id='third-step']/div[contains(@class,'_ta-center posting-success')]/div[contains(@class,'title')]")
    public WebElement successMessage;

    @FindBy(xpath = ".//*[@class='sell_faster--item _make_vip']")
    public WebElement makeVipPost;

    @FindBy(xpath = ".//*[@class='sell_faster--item _highlight']")
    public WebElement markPost;

    @FindBy(xpath = ".//*[@id='third-step']//div[@class='details']/a")
    public WebElement previewYourPostTitle;


    public YourPostPage clickOnPreviewYourPost(){

        $(previewYourPostTitle).shouldBe(Condition.visible).click();
        return new YourPostPage(driver);
    }

    public SuccessPostedPage(WebDriver driver) {
        super(driver);
    }
}
