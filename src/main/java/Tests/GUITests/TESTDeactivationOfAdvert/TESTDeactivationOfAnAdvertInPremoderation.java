package Tests.GUITests.TESTDeactivationOfAdvert;

import Entities.User;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.API_Actions.PostWorker.createNewPostViaAPI;
import static Actions.GUI_Actions.Login.loginViaPhone;

/**
 * Created by Dem on 24.04.2016.
 */
public class TESTDeactivationOfAnAdvertInPremoderation extends BaseTest {

    @Test
    public void DeactivationOfAnAdvertInPremoderation() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("DeactivationOfAnAdvertInPremoderation");

        String postId    = createNewPostViaAPI(props);

        String userPhone = props.getProperty("mobilePrefix") + props.getProperty("phoneNumber");
        props.getProperty("Email");
        String password  = props.getProperty("password");

        User user        = new User(userPhone, props, password);

        UserAccountPage userAccountPage = loginViaPhone(driver, user);
        userAccountPage.deactivate(postId);

        Assert.assertTrue(userAccountPage.getConfirmationMessage().isEmpty());
    }
}
