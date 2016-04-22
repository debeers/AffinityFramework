package Tests.GUITests.TESTRegistration;

import Entities.User;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderMobileOperators;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUser;

/**
 * Created by Dem on 20.04.2016.
 */
public class TESTRegistrationWithAllOperators extends BaseTest {

    @Test(dataProvider = "mobileOperators_registration", dataProviderClass = DataProviderMobileOperators.class)
    public void mobileOperators_registration(String mobileOperatorsCode) throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("RegistrationPositive");

        String userPhone    = mobileOperatorsCode + props.getProperty("mobilePhoneNumber");
        String email        = "GUI_TEST_" + RandomStringUtils.randomAlphabetic(9) + props.getProperty("emailDomain");
        String password     = props.getProperty("password");

        User user = new User(userPhone , email , password);
        registerNewUser(driver, user)
                .clickOnUserSettingsTopMenuLink()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);

    }
}

