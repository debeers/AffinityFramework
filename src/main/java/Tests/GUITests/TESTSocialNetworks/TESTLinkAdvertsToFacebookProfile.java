package Tests.GUITests.TESTSocialNetworks;

import Entities.Post;
import Entities.User;
import PageObjects.SuccessPostedPage;
import PageObjects.UserAccountPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.PopulateAdverts.checkMyAdvertsToHavePostedAdvert;
import static Actions.GUI_Actions.PostAdd.makeNewPost;
import static Actions.GUI_Actions.Registration.registerUserThroughFacebook;

/**
 * Created by Dem on 28.06.2016.
 */
public class TESTLinkAdvertsToFacebookProfile extends BaseTest {

    @Test
    public void linkAdvertsToGooglePlusProfile() throws AWTException, InterruptedException, IOException {
        Properties props = new ResourcesFactory().getResources("LinkAdvertsToFacebookProfile");
        Post post = new Post(props);
        User user = new User(props.getProperty("Email") , props.getProperty("password"));

        UserAccountPage userAccountPage = registerUserThroughFacebook(driver , user);
        Thread.sleep(10000);
        SuccessPostedPage successPostedPage = makeNewPost(userAccountPage.clickOnAddPostTopMenuButton(), post)
                .clickOnSubmitButton();
        String advertId = successPostedPage.getHrefValue();
        Assert.assertTrue(checkMyAdvertsToHavePostedAdvert(successPostedPage.clickOnUserAdvertsTab().getMyAdverts(), advertId));
        successPostedPage.clickOnUserSettingsTopMenuLinkWhenLoggedIn().deleteAccount();

    }
}
