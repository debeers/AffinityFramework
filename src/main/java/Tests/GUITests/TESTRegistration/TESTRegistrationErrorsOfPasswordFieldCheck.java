package Tests.GUITests.TESTRegistration;

import Entities.User;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegistrationPage;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderRegistrationErrors;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUserUsingEmail;

/**
 * Created by Dem on 13.06.2016.
 */
public class TESTRegistrationErrorsOfPasswordFieldCheck extends BaseTest {

    @Test(dataProvider = "passwordFieldErrors" , dataProviderClass = DataProviderRegistrationErrors.class)
    public void registrationErrorsOfPasswordFieldCheck(String userPassword, String passwordFieldError) throws InterruptedException, IOException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountUnAutorizedLink();
        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink(driver);
        Properties props = new ResourcesFactory().getResources("RegistrationErrorsOfEmailFieldCheck");
        User user = new User(props.getProperty("mobilePhoneNumber"), props.getProperty("email") , userPassword);

        registerNewUserUsingEmail(driver, user);

        Assert.assertEquals(registrationPage.getPasswordFieldError(), passwordFieldError);
    }
}
