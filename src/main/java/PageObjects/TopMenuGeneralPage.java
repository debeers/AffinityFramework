package PageObjects;

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

    @FindBy(xpath = ".//a[@id='personal_profile]")
    public WebElement userAccountTopMenuLink;

    @FindBy(xpath = ".//a[@id='language']")
    public WebElement localizationTopMenuLink;

    @FindBy(xpath = ".//a[@id='post_ad_header']")
    public WebElement postAddTopMenuButton;

    @FindBy(xpath = ".//a[@id='my_ads']")
    public WebElement myAddsTopMenuUserMenuLink;

    @FindBy(xpath = ".//a[@id='my_messages']")
    public WebElement myMessagesTopMenuUserMenuLink;

    @FindBy(xpath = ".//a[@id='my_settings']")
    public WebElement mySettingsTopMenuUserMenuLink;

    @FindBy(xpath = ".//a[@id='my_exit']")
    public WebElement exitTopMenuUserMenuLink;


    public UserSettingsPage clickOnUserSettingsTopMenuLink(){
        mouseOver(driver, userAccountTopMenuLink);
        $(mySettingsTopMenuUserMenuLink).shouldBe(visible).click();
        return new UserSettingsPage(driver);
    }

    public MainPage clickOnLalafoTopMenuLink(){
        $(lalafoTopMenuLink).shouldBe(visible).click();
        return new MainPage(driver);
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

    public void clickOnLocalizationTopMenuLink(){
        $(localizationTopMenuLink).shouldBe(visible).click();
    }

    public MainPage clickOnAddPostTopMenuButton(){
        $(postAddTopMenuButton).shouldBe(visible).click();
        return new MainPage(driver);
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
