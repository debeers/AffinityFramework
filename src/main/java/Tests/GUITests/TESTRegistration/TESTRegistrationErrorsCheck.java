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

import static Actions.GUI_Actions.Registration.registerNewUserUsingPhone;

/**
 * Created by Dem on 13.06.2016.
 */
public class TESTRegistrationErrorsCheck extends BaseTest {

    @Test(dataProvider = "phoneNumberErrors" , dataProviderClass = DataProviderRegistrationErrors.class)
    public void registrationErrorsCheck(String userPhone, String phoneNumberError) throws InterruptedException, IOException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountUnAutorizedLink();
        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink(driver);
        Properties props = new ResourcesFactory().getResources("RegistrationErrorsCheck");
        User user = new User(userPhone , props.getProperty("password"));
        registerNewUserUsingPhone(driver, user);
        Assert.assertEquals(registrationPage.getPhoneNumberError(), phoneNumberError);

    }
}
