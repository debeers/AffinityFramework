package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class UserAccountPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//a[contains(@class,'post-free-ad btn dblue pull-right')]")
    public WebElement addNewPostButtonFromUserAccount;

    @FindBy(xpath = ".//span[contains(@class,'astat-value')]")
    public WebElement messagesCounter;

    @FindBy(xpath = ".//div[contains(@class,'account-main-nav clearfix')]//li[1]/a")
    public WebElement myPostsUserNav;

    @FindBy(xpath = ".//div[contains(@class,'account-main-nav clearfix')]//li[2]/a")
    public WebElement myMessagesUserNav;

    @FindBy(xpath = ".//div[contains(@class,'account-main-nav clearfix')]//li[3]/a")
    public WebElement mySettingsUserNav;

    @FindBy(xpath = ".//div[contains(@class,'alert alert-success alert-dismissible')]")
    public WebElement successRegistrationAllert;


    public UserAccountPage(WebDriver driver) {
        super(driver);
    }
}
