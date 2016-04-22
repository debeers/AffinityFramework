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

    public void deleteAccount(){
        clickOnDeleteCabinetAccordion();
        clickOnDeleteAccountButton();
        clickOnConfirmButtonInPopUp();
    }

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }
}
