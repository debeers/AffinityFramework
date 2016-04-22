package Tests.Smoke;

import Entities.User;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
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

        String userPhone    = props.getProperty("phonePrefix") + props.getProperty("mobilePhoneNumber");
        String email        = "GUI_TEST_" + RandomStringUtils.randomAlphabetic(9) + "@mail.com";
        String password     = "11111";

        User user = new User(userPhone , email , password);
        registerNewUser(driver, user)
                .clickOnUserSettingsTopMenuLink()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);

    }
}
