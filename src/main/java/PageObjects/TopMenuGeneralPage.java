package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class TopMenuGeneralPage extends BasePageObject {


    @FindBy(xpath = ".//div[contains(@class,'logo pull-left')]/a")
    public WebElement lalafoTopMenuLink;

    @FindBy(xpath = ".//a[contains(@class,'account-link')]/../../div")
    public WebElement userAccountTopMenuLink;

    @FindBy(xpath = ".//ul[contains(@class,'user-nav')]/li[2]/a")
    public WebElement localizationTopMenuLink;

    @FindBy(xpath = ".//ul[contains(@class,'user-nav')]/following-sibling::a[contains(@class,'post-free-ad btn green')]")
    public WebElement postAddTopMenuButton;

    @FindBy(xpath = ".//*[@id='account-nav']/ul/li[1]/a")
    public WebElement myAddsTopMenuUserMenuLink;

    @FindBy(xpath = ".//*[@id='account-nav']/ul/li[2]/a")
    public WebElement myMessagesTopMenuUserMenuLink;

    @FindBy(xpath = ".//*[@id='account-nav']/ul/li[3]/a")
    public WebElement mySettingsTopMenuUserMenuLink;

    @FindBy(xpath = ".//*[@id='account-nav']/ul/li[4]/a")
    public WebElement exitTopMenuUserMenuLink;



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
