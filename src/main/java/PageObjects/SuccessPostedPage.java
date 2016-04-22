package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 10.03.2016.
 */
public class SuccessPostedPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//*[@id='third-step']/div[contains(@class,'_ta-center posting-success')]/div[contains(@class,'title')]")
    public WebElement successMessage;

    @FindBy(xpath = ".//*[@id='make_vip']")
    public WebElement makeVipPost;

    @FindBy(xpath = ".//*[@id='mark_up']")
    public WebElement markPost;

    @FindBy(xpath = ".//*[@id='third-step']//div[@class='details']/a")
    public WebElement previewYourPostTitle;

    public YourPostPage clickOnPreviewYourPost() throws InterruptedException {

        $(previewYourPostTitle).shouldBe(visible).click();
        YourPostPage yourPostPage = new YourPostPage(driver);
        $(yourPostPage.sendMessageButton).should(visible);
        $(yourPostPage.price).shouldBe(visible);
        return yourPostPage;
    }

    public SuccessPostedPage(WebDriver driver) {
        super(driver);
    }
}
