package Tests.Smoke;

import Entities.User;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUser;

/**
 * Created by DeBeers on 12.04.2016.
 */
public class TESTDeactivationUserAccount extends BaseTest {

    @Test
    public void DeactivationUserAccount() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("DeactivationPositive");

        String userPhone    = props.getProperty("phonePrefix") + RandomStringUtils.randomNumeric(7);
        props.getProperty("email");
        String password     = "11111";

        User user = new User(userPhone , props , password);
        registerNewUser(driver, user)
                .clickOnUserSettingsTopMenuLinkWhenLoggedIn()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/");

    }
}
