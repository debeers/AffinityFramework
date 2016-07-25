package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 19.06.2016.
 */
public class PasswordRecoveryPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//*[@id='user_login']")
    public WebElement userLogin;

    @FindBy(xpath = ".//*[@id='get_password_btn']")
    public WebElement resendPasswordButton;

    @FindBy(xpath = ".//div[@class='error-message']/ul/li[1]")
    public WebElement userLoginError;

    public String getErrorTextOfUserLogin() {
        return $(userLoginError).getText();
    }

    public PasswordRecoveryPage enterUsernameToRecoverPassword(String username) {
        if ($(userLogin).isDisplayed()) {
            $(userLogin).sendKeys(username);
        } else {
            log.info("There were errors finding 'USER LOGIN INPUT'");
        }
        return new PasswordRecoveryPage(driver);
    }

    public PasswordRecoveryPage clickOnSubmitButtonToRestorePassword() {
        if ($(resendPasswordButton).isDisplayed()) {
            $(resendPasswordButton).click();
        } else {
            log.info("There were errors finding 'SUBMIT BUTTON'");
        }
        return new PasswordRecoveryPage(driver);
    }

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }
}
