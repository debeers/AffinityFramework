package Tests.Smoke;

import Entities.User;
import PageObjects.MainPage;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUser;

/**
 * Created by Dem on 11.12.2016.
 */
public class TESTRegisterAndLogin extends BaseTest {

    @Test
    public void testRegisterAndLogin() throws InterruptedException, IOException {

        Properties props = new ResourcesFactory().getResources("RegisterAndLogin");

        //
        // Preparing user data and create new user entity
        //
        String mobilePhone = props.getProperty("phonePrefix") + RandomStringUtils.randomNumeric(13);
        props.getProperty("email");
        String password = props.getProperty("password");

        User user = new User(mobilePhone, props, password);

        //
        // Registering new user
        //
        UserAccountPage userAccountPage = registerNewUser(driver, user);
        MainPage mainPage = userAccountPage.logoutFromAccount();
    }
}
