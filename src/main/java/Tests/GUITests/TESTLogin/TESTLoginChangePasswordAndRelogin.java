package Tests.GUITests.TESTLogin;

import Entities.User;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUser;

/**
 * Created by Dem on 25.04.2016.
 */
public class TESTLoginChangePasswordAndRelogin extends BaseTest {

    @Test
    public void LoginChangePasswordAndRelogin() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("LoginChangePasswordAndRelogin");

        String userPhone = props.getProperty("phonePrefix") + props.getProperty("mobilePhoneNumber");
        props.getProperty("email");
        String password = "11111";
        props.getProperty("newPassword");

        User user = new User(userPhone, props, password);

        registerNewUser(driver, user)
                .clickOnUserSettingsTopMenuLinkWhenLoggedIn()
                .changePassword(props.getProperty("newPassword"))
                .clickOnExitFromAccountLink()
                .clickOnUserAccountUnAutorizedLink()
                .enterUserPhone(userPhone)
                .enterPassword(props.getProperty("newPassword"))
                .clickOnLoginButton(driver)
                .clickOnUserSettingsTopMenuLinkWhenLoggedIn()
                .deleteAccount();

        Assert.assertTrue(true, String.valueOf(driver.getCurrentUrl().contains(baseUrl)));

    }
}
