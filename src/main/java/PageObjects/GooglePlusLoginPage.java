package PageObjects;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 22.06.2016.
 */
public class GooglePlusLoginPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//div/input[@id='Email']")
    public WebElement googlePlusEmailInput;

    @FindBy(xpath = ".//input[@id='Passwd']")
    public WebElement googlePlusPasswordInput;

    @FindBy(xpath = ".//input[@id='next']")
    public WebElement nextButton;

    @FindBy(xpath = ".//*[@id='signIn']")
    public WebElement googlePlusAccessApproveButton;

    @FindBy(xpath = ".//*[@id='answer']")
    public WebElement googlePlusCityConfirm;

    @FindBy(xpath = ".//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = ".//button[@id='submit_approve_access']")
    public WebElement submitApproveAccess;

    public GooglePlusLoginPage enterGoogleEmail(String googleEmail) {
        $(googlePlusEmailInput).shouldBe(visible).hover().sendKeys(googleEmail);
        $(nextButton).shouldBe(visible).hover().click();
        return new GooglePlusLoginPage(driver);
    }

    public GooglePlusLoginPage enterGoogleEmailPassword(String googlePassword) {
        $(googlePlusPasswordInput).shouldBe(visible).hover().sendKeys(googlePassword);
        return new GooglePlusLoginPage(driver);
    }

    public GooglePlusLoginPage pressOnTheApproveButton() {
        $(googlePlusAccessApproveButton).shouldBe(visible).click();
        return new GooglePlusLoginPage(driver);
    }

    public GooglePlusLoginPage enterCityNameToVerifyLogin(String cityName) {
        if ($(googlePlusCityConfirm).exists()) {
            try {
                $(googlePlusCityConfirm).shouldBe(visible).sendKeys(cityName);
                $(submitButton).shouldBe(visible).click();
            } catch (ElementNotFound elementNotFound) {
                log.info("We have already approved city before");
            }
        }
        return new GooglePlusLoginPage(driver);
    }

    public GooglePlusLoginPage submitApproveAccess(){
        if ($(submitApproveAccess).exists()) {
            try {
                $(submitApproveAccess).shouldBe(visible).click();
            } catch (ElementNotFound elementNotFound) {
                log.info("We have already granted access to the personal data");
            }
        }
        return new GooglePlusLoginPage(driver);
    }

    public void closeGooglePlusPage() {
        try {
            driver.close();
        } catch (Exception e) {
                log.info("Popup window is already closed");
        }
    }


    public GooglePlusLoginPage(WebDriver driver) {
        super(driver);
    }
}
