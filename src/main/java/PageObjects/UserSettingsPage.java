package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 13.04.2016.
 */
public class UserSettingsPage extends TopMenuGeneralPage{

    @FindBy(xpath = ".//*[@id='delete_profile']")
    public WebElement deleteCabinetAccordion;

    @FindBy(xpath = ".//*[@id='deleteAccount']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//a[@class = 'btn dblue btn-confirm']")
    public WebElement confirmButtonInPopUp;

    @FindBy(xpath = ".//*[@id='change_password']")
    public WebElement changePasswordAccordion;

    @FindBy(xpath = ".//*[@id='change_password_new']")
    public WebElement newPasswordField;

    @FindBy(xpath = ".//*[@id='change_password_confirm']")
    public WebElement confirmPasswordField;

    @FindBy(xpath = ".//*[@id='change-password-button']")
    public WebElement passwordChangingButton;

    @FindBy(xpath = ".//div[@class='successful_block']/span")
    public WebElement passwordWasChangedMessage;


    public UserSettingsPage clickOnDeleteCabinetAccordion(){
        $(deleteCabinetAccordion).shouldBe(Condition.visible).click();
        return this;
    }

    public UserSettingsPage clickOnDeleteAccountButton(){
        $(deleteAccountButton).shouldBe(Condition.visible).click();
        return this;
    }

    public UserSettingsPage clickOnConfirmButtonInPopUp(){
        $(confirmButtonInPopUp).should(Condition.appear).click();
        return this;
    }

    public UserSettingsPage clickOnChangePasswordAccordion(){
        $(changePasswordAccordion).shouldBe(Condition.visible).click();
        return this;
    }

    public UserSettingsPage setNewPassword(String newPassword){
        $(newPasswordField).shouldBe(Condition.visible).clear();
        $(newPasswordField).shouldBe(Condition.visible).sendKeys(newPassword);
        return this;
    }

    public UserSettingsPage confirmNewPassword(String newPassword){
        $(confirmPasswordField).shouldBe(Condition.visible).clear();
        $(confirmPasswordField).shouldBe(Condition.visible).sendKeys(newPassword);
        return this;
    }

    public UserSettingsPage clickOnPasswordConfirmationButton(){
        $(passwordChangingButton).shouldBe(Condition.visible).click();
        return this;
    }

    public void deleteAccount(){
        clickOnDeleteCabinetAccordion();
        clickOnDeleteAccountButton();
        clickOnConfirmButtonInPopUp();
    }

    public UserSettingsPage changePassword(String newPassword){
        clickOnChangePasswordAccordion();
        setNewPassword(newPassword);
        confirmNewPassword(newPassword);
        clickOnPasswordConfirmationButton();
        return new UserSettingsPage(driver);
    }

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }
}
