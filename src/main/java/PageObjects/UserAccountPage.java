package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public UserAccountPage(WebDriver driver) {
        super(driver);
    }
}
