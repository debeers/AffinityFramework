package PageObjects;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static GeneralHelpers.DropdownMenuWorker.mouseOver;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class TopMenuGeneralPage extends BasePageObject {


    @FindBy(xpath = ".//div[contains(@class,'logo pull-left')]/a")
    public WebElement lalafoTopMenuLink;

    @FindBy(xpath = ".//div[@class='total-adv-count']")
    public WebElement headerCounterOfAds;

    @FindBy(xpath = ".//*[@id='personal_profile']")
    public WebElement userAccountTopMenuLink;

    @FindBy(xpath = ".//a[@class='account-link']")
    public WebElement loggedInAccountLink;

    @FindBy(xpath = ".//*[@id='language']")
    public WebElement localizationTopMenuLink;

    @FindBy(xpath = ".//*[@id='post_ad_header']")
    public WebElement postAddTopMenuButton;

    @FindBy(xpath = ".//*[@id='my_ads']")
    public WebElement myAddsTopMenuUserMenuLink;

    @FindBy(xpath = ".//*[@id='my_messages']")
    public WebElement myMessagesTopMenuUserMenuLink;

    @FindBy(xpath = ".//*[@id='my_settings']")
    public WebElement mySettingsTopMenuUserMenuLink;

    @FindBy(xpath = ".//*[@id='my_exit']")
    public WebElement exitTopMenuUserMenuLink;


    public UserSettingsPage clickOnUserSettingsTopMenuLink(){
        mouseOver(driver, userAccountTopMenuLink);
        $(mySettingsTopMenuUserMenuLink).shouldBe(visible).click();
        return new UserSettingsPage(driver);
    }

    public UserSettingsPage clickOnUserSettingsTopMenuLinkWhenLoggedIn(){
        mouseOver(driver, loggedInAccountLink);
        $(mySettingsTopMenuUserMenuLink).shouldBe(visible).click();
        return new UserSettingsPage(driver);
    }

    public UserAccountPage clickOnUserAdvertsTab(){
        mouseOver(driver, loggedInAccountLink);
        $(myAddsTopMenuUserMenuLink).shouldBe(visible).click();
        return new UserAccountPage(driver);
    }

    public UserAccountPage clickOnMyMessagesTab(){
        mouseOver(driver, userAccountTopMenuLink);
        $(myMessagesTopMenuUserMenuLink).shouldBe(visible).click();
        return new UserAccountPage(driver);
    }

    public MainPage clickOnExitFromAccountLink(){
        mouseOver(driver, loggedInAccountLink);
        $(exitTopMenuUserMenuLink).shouldBe(visible).click();
        return new MainPage(driver);
    }

    public MainPage clickOnLalafoTopMenuLink(){
        $(lalafoTopMenuLink).shouldBe(visible).click();
        return new MainPage(driver);
    }

    public String pullAdvertsCount(){
         return StringUtils.substringBefore($(headerCounterOfAds).shouldBe(visible).getText(), " ");
    }

    public LoginPage clickOnUserAccountUnAutorizedLink(){

        userAccountTopMenuLink.click();
        return new LoginPage(driver);
    }

    public Object clickOnUserAccountLink(String userEmail){

        WebElement accLinc = $(userAccountTopMenuLink).shouldBe(visible);

        if(accLinc.getText().contains(userEmail)){
            accLinc.click();
            return new UserAccountPage(driver);
        }else accLinc.click();

        return new LoginPage(driver);
    }

    public LoginPage clickOnUserAccountLinkEmail(String userEmail) {
        WebElement accLinc = $(userAccountTopMenuLink).shouldBe(visible);

        if (accLinc.getText().contains(userEmail)) {
            accLinc.click();
            return new LoginPage(driver);
        } else accLinc.click();
        return new LoginPage(driver);
    }

    public LoginPage clickOnUserAccountLinkPhone(String userPhone){

        WebElement accLinc = $(userAccountTopMenuLink).shouldBe(visible);

        if(accLinc.getText().contains(userPhone)){
            accLinc.click();
            return new LoginPage(driver);
        }else accLinc.click();

        return new LoginPage(driver);
    }

    public void clickOnLocalizationTopMenuLink(){
        $(localizationTopMenuLink).shouldBe(visible).click();
    }

    public PostPage clickOnAddPostTopMenuButton(){
        $(postAddTopMenuButton).shouldBe(visible).click();
        return new PostPage(driver);
    }

    public MainPage clickOnExitTopMenuLink(){
        $(exitTopMenuUserMenuLink).shouldBe(visible).click();
        return new MainPage(driver);
    }

    public TopMenuGeneralPage(WebDriver driver) {
        super(driver);
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
