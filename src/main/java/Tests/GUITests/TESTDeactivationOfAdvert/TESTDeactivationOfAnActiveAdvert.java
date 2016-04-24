package Tests.GUITests.TESTDeactivationOfAdvert;

import Entities.User;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.API_Actions.PostWorker.createNewPostViaAPI;
import static Actions.GUI_Actions.Login.loginViaPhone;

/**
 * Created by Dem on 24.04.2016.
 */
public class TESTDeactivationOfAnActiveAdvert extends BaseTest {

    @Test
    public void DeactivationOfAnActiveAdvert() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("DeactivationOfAnActiveAdvert");

        String postId    = createNewPostViaAPI(props);

        String userPhone = props.getProperty("mobilePrefix") + props.getProperty("phoneNumber");
        String email     = "GUI_TEST_" + RandomStringUtils.randomAlphabetic(9) + props.getProperty("emailDomain");
        String password  = props.getProperty("password");

        User user        = new User(userPhone, email, password);

        UserAccountPage userAccountPage = loginViaPhone(driver, user);
        userAccountPage.deactivate(postId);

        Assert.assertTrue(!userAccountPage.getConfirmationMessage().isEmpty());
    }
}
