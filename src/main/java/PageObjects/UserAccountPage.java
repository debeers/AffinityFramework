package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class UserAccountPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//a[@id='post_add_blue_btn']")
    public WebElement addNewPostButtonFromUserAccount;

    @FindBy(xpath = ".//span[@id='ads_counter']")
    public WebElement adsCounter;

    @FindBy(xpath = ".//a[@id='my_ads_tab']")
    public WebElement myPostsUserNav;

    @FindBy(xpath = ".//a[@id='my_messages_tab']")
    public WebElement myMessagesUserNav;

    @FindBy(xpath = ".//a[@id='my_settings_tab']")
    public WebElement mySettingsUserNav;

    @FindBy(xpath = ".//div[contains(@class,'alert alert-success alert-dismissible')]")
    public WebElement successRegistrationAllert;

    @FindBy(xpath = ".//td/a[contains(@id,'ad_")
    public WebElement myAdvert;

    @FindBy(xpath = "_deactivate']")
    public WebElement deactivateAd;

    @FindBy(xpath = ".//div[@class='container']/div[@role='alert']")
    public WebElement successDeactivationMessage;

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public void deactivate(String postId){
        if ($(myAdvert).has(Condition.attribute("id", "ad_" + postId))) {
            $($(myAdvert) + postId + $(deactivateAd)).click();
        }
    }

    public String getConfirmationMessage() {
        return $(successDeactivationMessage).shouldBe(Condition.visible).getText();
    }
}
