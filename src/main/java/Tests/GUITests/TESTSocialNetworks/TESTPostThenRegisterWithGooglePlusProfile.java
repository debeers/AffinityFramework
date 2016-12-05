package Tests.GUITests.TESTSocialNetworks;

import Entities.Post;
import Entities.User;
import PageObjects.MainPage;
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
import static Actions.GUI_Actions.PostAdd.makeNewPost2;
import static Actions.GUI_Actions.Registration.registerUserThroughGooglePlus;

/**
 * Created by Dem on 28.06.2016.
 */
public class TESTPostThenRegisterWithGooglePlusProfile extends BaseTest {

    @Test
    public void linkAdvertsToGooglePlusProfile() throws AWTException, InterruptedException, IOException {
        Properties props = new ResourcesFactory().getResources("PostThenRegisterWithGooglePlusProfile");
        Post post = new Post(props);
        User user = new User(props.getProperty("Email") , props.getProperty("password"));

        MainPage mainPage = new MainPage(driver);

        SuccessPostedPage successPostedPage = makeNewPost2(mainPage.clickOnAddPostTopMenuButton(), post, driver)
                .clickOnSubmitButton();
        String advertId = successPostedPage.getHrefValue();
        UserAccountPage userAccountPage = registerUserThroughGooglePlus(driver , user , props.getProperty("cityName"));
        Thread.sleep(10000);

        Assert.assertTrue(checkMyAdvertsToHavePostedAdvert(userAccountPage.clickOnUserAdvertsTab().getMyAdverts(), advertId));
        successPostedPage.clickOnUserSettingsTopMenuLinkWhenLoggedIn().deleteAccount();

    }
}
