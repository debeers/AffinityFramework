package Tests.GUITests.TESTRegistration;

import Entities.User;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Registration.registerUserThroughGooglePlus;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 28.06.2016.
 */
public class TESTRegistrationThroughGooglePlus extends BaseTest {

    @Test
    public void registrationThroughGooglePlus() throws InterruptedException, IOException {
        Properties props = new ResourcesFactory().getResources("RegistrationThroughGooglePlus");
        User user = new User(props.getProperty("email") , props.getProperty("password"));
        UserAccountPage userAccountPage = registerUserThroughGooglePlus(driver , user , props.getProperty("cityName"));

        Assert.assertTrue(userAccountPage.adsCounter.isDisplayed(), "Message counter is not displaying on user account page");
        Assert.assertTrue(userAccountPage.myMessagesUserNav.isDisplayed(), "My messages tab is not displaying on user account page");
        Assert.assertTrue($(userAccountPage.myPostsUserNav).isDisplayed(), "Posts tab is not displaying on user account page");
        Assert.assertTrue($(userAccountPage.mySettingsUserNav).isDisplayed(), "Settings tab is not displaying on user account page");

        userAccountPage
                .clickOnUserSettingsTopMenuLinkWhenLoggedIn()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl() , baseUrl);
    }
}