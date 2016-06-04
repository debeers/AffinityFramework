package Tests.GUITests.TESTLogin;

import Entities.User;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.Login.loginViaPhone;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dem on 04.06.2016.
 */
public class TESTLoginWithFullPhoneNumber extends BaseTest {

    @Test
    public void LoginWithFullPhoneNumber() throws InterruptedException, IOException {
        Properties props = new ResourcesFactory().getResources("LoginWithFullPhoneNumber");

        User user = new User(props.getProperty("mobilePhoneNumber"), props.getProperty("password"));
        UserAccountPage userAccountPage = loginViaPhone(driver, user);

        Assert.assertTrue(userAccountPage.adsCounter.isDisplayed(), "Message counter is not displaing on user account page");
        Assert.assertTrue(userAccountPage.myMessagesUserNav.isDisplayed(), "My messages tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.myPostsUserNav).isDisplayed(), "Posts tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.mySettingsUserNav).isDisplayed(), "Settings tab is not displaing on user account page");
    }
}
