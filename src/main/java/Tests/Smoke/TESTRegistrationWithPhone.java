package Tests.Smoke;

import Entities.User;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUserUsingPhone;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 08.12.2016.
 */
public class TESTRegistrationWithPhone extends BaseTest {

    @Test
    public void testRegistrationWithPhone() throws IOException, InterruptedException {

        Properties props = new ResourcesFactory().getResources("RegistrationWithPhone");

        //
        // Preparing user data and create new user entity
        //
        String mobilePhone = props.getProperty("phonePrefix") + RandomStringUtils.randomNumeric(11);
        props.getProperty("email");
        String password = props.getProperty("password");

        User user = new User(mobilePhone, props, password);

        //
        // Registering new user
        //
        UserAccountPage userAccountPage = registerNewUserUsingPhone(driver, user);

        //
        // Check user page for consistance and that user email is displaing in user account menu link
        //
        //Assert.assertTrue($(userAccountPage.successRegistrationAllert).isDisplayed(), "Success registration allert is not appear");
        //Assert.assertTrue($(userAccountPage.adsCounter).isDisplayed(), "Message counter is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.myMessagesUserNav).isDisplayed(), "My messages tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.myPostsUserNav).isDisplayed(), "Posts tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.mySettingsUserNav).isDisplayed(), "Settings tab is not displaing on user account page");
    }
}
