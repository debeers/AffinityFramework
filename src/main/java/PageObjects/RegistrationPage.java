package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class RegistrationPage extends TopMenuGeneralPage {


    @FindBy(xpath = ".//input[contains(@name,'mobile')]")
    public WebElement mobilePhoneNumberField;

    @FindBy(xpath = ".//input[contains(@name,'email')]")
    public WebElement emailField;

    @FindBy(xpath = ".//input[contains(@name,'password')]")
    public WebElement passwordField;

    @FindBy(xpath = ".//input[contains(@name,'passwordConfirm')]")
    public WebElement passwordConfirmField;

    @FindBy(xpath = ".//input[contains(@name,'register-submit')]")
    public WebElement registrationButton;

    @FindBy(xpath = ".//*[@id='Register form']//div[contains(@class,'error-message')]/ul/li[1]")
    public List<WebElement> errorMessages;


    public RegistrationPage enterMobilePhoneNumber(String mobilePhoneNumber) {
        $(mobilePhoneNumberField).shouldBe(visible).clear();
        $(mobilePhoneNumberField).shouldBe(visible).sendKeys(mobilePhoneNumber);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterEmail(String email) {
        $(emailField).shouldBe(visible).clear();
        $(emailField).shouldBe(visible).sendKeys(email);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterPassword(String password) {
        $(passwordField).shouldBe(visible).clear();
        $(passwordField).shouldBe(visible).sendKeys(password);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterConfirmationPassword(String password) {
        $(passwordConfirmField).shouldBe(visible).clear();
        $(passwordConfirmField).shouldBe(visible).sendKeys(password);
        return new RegistrationPage(driver);
    }

    public UserAccountPage clickOnRegisterButton() {
        $(registrationButton).shouldBe(visible).click();

        try {
            if ($$(errorMessages).shouldBe().size() != 0) {
                errorMessages.stream().forEach((p) ->
                        System.out.println("ERRORS EXIST IN ENTERING REGISTRATION DATA:: " + p.getText()));
            }
            return null;

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering registration data");
        }
        return new UserAccountPage(driver);
    }

    public UserAccountPage enterRegistrationData(String mobilePhoneNumber, String email, String password) {

        enterMobilePhoneNumber(mobilePhoneNumber);
        enterEmail(email);
        enterPassword(password);
        enterConfirmationPassword(password);

        return clickOnRegisterButton();
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}
