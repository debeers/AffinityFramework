package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class LoginPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//input[contains(@name,'email')]")
    public WebElement loginPageEmailField;

    @FindBy(xpath = ".//input[contains(@name,'password')]")
    public WebElement loginPagePasswordField;

    @FindBy(xpath = ".//input[contains(@class,'btn blue middle login-btn full-input')]")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = ".//*[@id='Login form']//div[contains(@class,'login-help-links')]/a")
    public WebElement loginPageForgotpasswordLink;

    @FindBy(xpath = ".//*[@id='Login form']//h4[contains(@class,'login-reg-msg')]/a")
    public WebElement loginPageRegistrationLink;

    @FindBy(xpath = ".//*[@id='Login form']//div[contains(@class,'error-message')]/ul/li[1]")
    public List<WebElement> errorMessagesLoginForm;


    public LoginPage enterEmail(String email) {
        $(loginPageEmailField).shouldBe(visible).clear();
        $(loginPageEmailField).shouldBe(visible).sendKeys(email);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        $(loginPagePasswordField).shouldBe(visible).clear();
        $(loginPagePasswordField).shouldBe(visible).sendKeys(password);
        return new LoginPage(driver);
    }

    public UserAccountPage clickOnLoginButton() {

        $(loginPageLoginButton).shouldBe(visible).click();

        try {
            if ($$(errorMessagesLoginForm).size() != 0) {
                errorMessagesLoginForm.stream().forEach((p) ->
                        System.out.println("ERRORS EXIST IN ENTERING LOGIN DATA:: " + p.getText()));
            }
            return null;

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering login data");
        }

        return new UserAccountPage(driver);
    }

    public RegistrationPage clickOnRegistrationLink() {
        $(loginPageRegistrationLink).shouldBe(visible).click();
        return new RegistrationPage(driver);
    }

    public UserAccountPage loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickOnLoginButton();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
