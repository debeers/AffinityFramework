package Tests.GUITests.TESTDeactivationUserAccount;

import Entities.User;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUserUsingEmail;

/**
 * Created by DeBeers on 12.04.2016.
 */
public class TESTDeactivationUserAccount extends BaseTest {

    @Test
    public void DeactivationUserAccount() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("DeactivationUserAccount");

        String userPhone    = "70" + props.getProperty("mobilePhoneNumber");
        props.getProperty("email");
        String password     = "TEST_USER_" + RandomStringUtils.randomNumeric(7) + "_@gmail.com";

        User user = new User(userPhone , props , password);
        registerNewUserUsingEmail(driver, user)
                .clickOnUserSettingsTopMenuLinkWhenLoggedIn()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);

    }
}
