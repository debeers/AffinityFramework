package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class LoginPage extends TopMenuGeneralPage implements ErrorHandler {


    @FindBy(xpath = ".//input[@id='user_login']")
    public WebElement loginPageEmailField;

    @FindBy(xpath = ".//input[@id='user_password']")
    public WebElement loginPagePasswordField;

    @FindBy(xpath = ".//input[@id='login_btn']")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = ".//*[@class='login-page']//div[@class='login-help-links']/a")
    public WebElement loginPageForgotPasswordLink;

    @FindBy(xpath = ".//*[@id='Login form']/div/div[1]/div/div/div/h4/a")
    public WebElement loginPageRegistrationLink;

    @FindBy(xpath = ".//*[@id='Login form']//div[contains(@class,'error-message')]/ul/li[1]")
    public List<WebElement> errorMessagesLoginForm;

    @FindBy(xpath = ".//*[@id='fb-link']")
    public WebElement facebookLoginButton;

    @FindBy(xpath = ".//*[@id='google-link']")
    public WebElement googlePlusLoginButton;


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

    public LoginPage enterUserPhone(String userPhone) {
        $(loginPageEmailField).shouldBe(visible).clear();
        $(loginPageEmailField).shouldBe(visible).sendKeys(userPhone);
        return new LoginPage(driver);
    }

    public UserAccountPage clickOnLoginButton(WebDriver driver) {
        $(loginPageLoginButton).shouldBe(visible).click();

        if (getAllFieldsErrors().isEmpty()){
            return new UserAccountPage(driver);
        } else {
            System.out.println(
                    "Oops, some errors were detected in entering login data and you take a null pointer)");
            return null;
        }
    }

    public RegistrationPage clickOnRegistrationLink(WebDriver driver) throws InterruptedException {
        $(loginPageRegistrationLink).shouldBe(visible).click();
        return new RegistrationPage(driver);
    }

    public PasswordRecoveryPage clickOnForgotPasswordLink(WebDriver driver) throws InterruptedException {
        $(loginPageForgotPasswordLink).click();
        return new PasswordRecoveryPage(driver);
    }

    public FacebookLoginPage clickOnFacebookLoginButton(WebDriver driver) {
        $(facebookLoginButton).shouldBe(visible).click();
        return new FacebookLoginPage(driver);
    }

    public GooglePlusLoginPage clickOnGooglePlusLoginButton(WebDriver driver) throws InterruptedException {
        $(googlePlusLoginButton).shouldBe(visible).hover().click();
        /*Thread.sleep(3000);
        if ($(googlePlusLoginButton).is(visible)){
            try {
                $(googlePlusLoginButton).shouldBe(visible).hover().click();
            } catch (Exception e) {
                log.info("Already pressed the button and got to the login page");
            }*/

        return new GooglePlusLoginPage(driver);
    }

    public UserAccountPage loginAs(WebDriver driver, String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        Thread.sleep(3500);
        return clickOnLoginButton(driver);
    }

    public UserAccountPage loginViaPhone(WebDriver driver, String userPhone, String password) throws InterruptedException {
        enterUserPhone(userPhone);
        enterPassword(password);
        Thread.sleep(3500);
        return clickOnLoginButton(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getAllFieldsErrors() {
        List<String> errorsList = new ArrayList<>();
        try {
            if (!$$(errorMessagesLoginForm).isEmpty()) {
                errorMessagesLoginForm.stream().forEach((p) ->{
                    errorsList.add(p.getText());
                    System.out.println("ERRORS EXIST IN ENTERING LOGIN DATA:: " + p.getText());
                });
                return errorsList;
            }

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering login data");
        }
        return errorsList;
    }
}
