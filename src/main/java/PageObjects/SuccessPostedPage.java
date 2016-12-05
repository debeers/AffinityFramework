package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Actions.GENERAL.TrimAdvertsInformation.trimAdvertIdFromUrl;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 10.03.2016.
 */
public class SuccessPostedPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//div[@class='title']")
    public WebElement successMessage;

    @FindBy(xpath = ".//*[@id='make_vip']")
    public WebElement makeVipPost;

    @FindBy(xpath = ".//*[@id='mark_up']")
    public WebElement markPost;

    @FindBy(xpath = ".//*[@id='preview_post_title']")
    public WebElement previewYourPostTitle;

    @FindBy(xpath = ".//tr[@class='account-ads-row']/td/a[@class='name']")
    public List<WebElement> myAdverts;

    public YourPostPage clickOnPreviewYourPost() throws InterruptedException {

        $(previewYourPostTitle).shouldBe(visible).click();
        YourPostPage yourPostPage = new YourPostPage(driver);
        $(yourPostPage.sendMessageButton).should(visible);
        $(yourPostPage.price).shouldBe(visible);
        return yourPostPage;
    }

    public String getHrefValue() {
        return $(previewYourPostTitle).getAttribute("href");
    }

    public String getAdvertIdFromHref() {
        System.out.println(trimAdvertIdFromUrl(getHrefValue()));
        return trimAdvertIdFromUrl(getHrefValue());
    }

    public ElementsCollection getMyAdverts() {
        return $$(myAdverts);
    }

    public SuccessPostedPage(WebDriver driver) {
        super(driver);
    }
}
