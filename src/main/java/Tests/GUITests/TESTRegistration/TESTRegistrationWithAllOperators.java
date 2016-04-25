package Tests.GUITests.TESTRegistration;

import Entities.User;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderMobileOperators;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
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
        props.getProperty("Email");
        String password     = props.getProperty("password");

        User user = new User(userPhone , props , password);
        registerNewUser(driver, user)
                .clickOnUserSettingsTopMenuLink()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);

    }
}

