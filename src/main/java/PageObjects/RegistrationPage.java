package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class RegistrationPage extends TopMenuGeneralPage implements ErrorHandler {


    @FindBy(xpath = ".//*[@id='phone_number']")
    public WebElement mobilePhoneNumberField;

    @FindBy(xpath = ".//*[@id='user_email']")
    public WebElement emailField;

    @FindBy(xpath = ".//*[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[@id='password_confirm']")
    public WebElement passwordConfirmField;

    @FindBy(xpath = ".//*[@id='register_btn']")
    public WebElement registrationButton;

    @FindBy(xpath = ".//*[@id='Register form']//div[contains(@class,'error-message')]/ul/li[1]")
    public List<WebElement> errorMessages;


    public RegistrationPage enterMobilePhoneNumber(String mobilePhoneNumber) {
        $(mobilePhoneNumberField).
                shouldBe(visible).
                clear();
        $(mobilePhoneNumberField).
                shouldBe(visible).
                sendKeys(mobilePhoneNumber);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterEmail(String email) {
        $(emailField).
                shouldBe(visible).
                clear();
        $(emailField).
                shouldBe(visible).
                sendKeys(email);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterPassword(String password) {
        $(passwordField).
                shouldBe(visible).
                clear();
        $(passwordField).
                shouldBe(visible).
                sendKeys(password);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterConfirmationPassword(String password) {
        $(passwordConfirmField).
                shouldBe(visible).
                clear();
        $(passwordConfirmField).
                shouldBe(visible).
                sendKeys(password);
        return new RegistrationPage(driver);
    }

    public UserAccountPage clickOnRegisterButton() {
        $(registrationButton).
                shouldBe(visible).
                click();
        if (getAllFieldsErrors().isEmpty()){
            return new UserAccountPage(driver);
        } else {
            System.out.println(
                    "Oops, some errors were detected in entering registration data and you take a null pointer)");
            return null;
        }
    }

    public UserAccountPage enterRegistrationData(String mobilePhoneNumber, String email, String password) throws InterruptedException {

        enterMobilePhoneNumber(mobilePhoneNumber);
        enterEmail(email);
        enterPassword(password);
        enterConfirmationPassword(password);
        Thread.sleep(3500);
        return clickOnRegisterButton();
    }

    public UserAccountPage enterRegistrationDataUsingEmail(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        enterConfirmationPassword(password);
        Thread.sleep(3500);
        return clickOnRegisterButton();
    }

    public UserAccountPage enterRegistrationDataShort(String mobilePhoneNumber, String password) throws InterruptedException {
        enterMobilePhoneNumber(mobilePhoneNumber);
        enterPassword(password);
        enterConfirmationPassword(password);
        Thread.sleep(2500);
        return clickOnRegisterButton();
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getAllFieldsErrors() {
        List<String> errorsList = new ArrayList<>();
        try {
            if ($$(errorMessages).isEmpty()) {
                errorMessages.stream().forEach((p) ->{
                    errorsList.add(p.getText());
                    System.out.println("ERRORS EXIST IN ENTERING REGISTRATION DATA:: " + p.getText());
                });
                return errorsList;
            }

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering post data");
        }
        return errorsList;
    }
}
