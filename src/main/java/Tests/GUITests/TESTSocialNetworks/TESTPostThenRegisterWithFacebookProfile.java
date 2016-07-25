package Tests.GUITests.TESTSocialNetworks;

import Entities.Post;
import Entities.User;
import PageObjects.MainPage;
import PageObjects.PostPage;
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
public class TESTPostThenRegisterWithFacebookProfile extends BaseTest {

    @Test
    public void postThenRegisterWithFacebookProfile() throws AWTException, InterruptedException, IOException {
        Properties props = new ResourcesFactory().getResources("PostThenRegisterWithFacebookProfile");
        Post post = new Post(props);
        User user = new User(props.getProperty("Email") , props.getProperty("password"));

        MainPage mainPage = new MainPage(driver);
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        SuccessPostedPage successPostedPage = makeNewPost(postPage.clickOnAddPostTopMenuButton(), post)
                .clickOnSubmitButton();
        String advertId = successPostedPage.getHrefValue();
        UserAccountPage userAccountPage = registerUserThroughFacebook(driver , user);

        Assert.assertTrue(checkMyAdvertsToHavePostedAdvert(userAccountPage.clickOnUserAdvertsTab().getMyAdverts(), advertId));
        successPostedPage.clickOnUserSettingsTopMenuLinkWhenLoggedIn().deleteAccount();

    }
}
