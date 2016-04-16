package Tests.GUITests.TEST_Registration;

import Entities.User;
import PageObjects.UserAccountPage;
import TEST_RESOURCES.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerNewUser;
import static UtilsGUI.PropertiesLoader.propertyXMLoader;
import static com.codeborne.selenide.Selenide.$;


/**
 * Created by DeBeers on 08.03.2016.
 */
public class TEST_Registration_Positive extends BaseTest{

    @Test
    public void TEST_Registration_Positive() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_Registration_Positive");

        //
        // Prepearing user data and create new user entity
        //
        String mobilePhone = props.getProperty("phonePrefix") + RandomStringUtils.randomNumeric(6);
        String email = "GUI_TEST_" + RandomStringUtils.randomAlphabetic(9) + props.getProperty("emailDomain");
        String emailSubSequence = (String) email.subSequence(0, 11); // user account link (email subsequence) for assertion
        String password = props.getProperty("password");

        User user = new User(mobilePhone, email, password);

        //
        // Registering new user
        //
        UserAccountPage userAccountPage = registerNewUser(driver, user);

        //
        // Check user page for consistance and that user email is displaing in user account menu link
        //
        Assert.assertTrue($(userAccountPage.successRegistrationAllert).isDisplayed(), "Success registration allert is not appear");
        Assert.assertTrue($(userAccountPage.messagesCounter).isDisplayed(), "Message counter is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.myMessagesUserNav).isDisplayed(), "My messages tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.myPostsUserNav).isDisplayed(), "Posts tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.mySettingsUserNav).isDisplayed(), "Settings tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.userAccountTopMenuLink).getText().contains(emailSubSequence), "User email is not contains in user account menu link!");
    }
}
