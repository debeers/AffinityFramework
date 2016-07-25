package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 20.06.2016.
 */
public class FacebookLoginPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//*[@id='email']")
    public WebElement facebookUserLogin;

    @FindBy(xpath = ".//*[@id='pass']")
    public WebElement facebookPassword;

    @FindBy(xpath = ".//*[@id='dialog_buttons']//label[@id='loginbutton']//input")
    public WebElement facebookLoginButton;

    @FindBy(xpath = ".//*[@id='u_0_3']/div[2]/div[3]/button")
    public WebElement continueButton;


    public FacebookLoginPage enterUsername(String username) {
        $(facebookUserLogin).shouldBe(visible).sendKeys(username);
        return new FacebookLoginPage(driver);
    }

    public FacebookLoginPage enterUserPassword(String password) {
        $(facebookPassword).shouldBe(visible).sendKeys(password);
        return new FacebookLoginPage(driver);
    }

    public FacebookLoginPage clickOnLoginButton() {
        $(facebookLoginButton).shouldBe(visible).click();
        return new FacebookLoginPage(driver);
    }

    public FacebookLoginPage clickOnContinueButton() {
        if ($(continueButton).isDisplayed()) {
            try {
                $(continueButton).click();
            } catch (Exception e) {
            log.info("We have already pressed this button before. No need to press it twice");
            }
        }
        return new FacebookLoginPage(driver);
    }

    public void closeFacebookLoginPage() {
        try {
            driver.close();
        } catch (Exception e) {
            log.info("Popup window is already closed");
        }
    }





    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }
}
