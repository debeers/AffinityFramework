package Tests.GUITests.TESTAddPost;

import Entities.Post;
import PageObjects.MainPage;
import PageObjects.PostPage;
import PageObjects.YourPostPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.PostAdd.makeNewPost;

/**
 * Created by DeBeers on 28.03.2016.
 */
public class TESTPostNegotiablePrice extends BaseTest {

    @Test
    public void PostNegotiablePrice() throws IOException, AWTException, InterruptedException {

        Properties props = new ResourcesFactory().getResources("PostNegotiablePrice");

        Post post = new Post(props);
        int countForPhotoUploads = 0;

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        //
        //Create new post
        //
        YourPostPage yourPostPage = makeNewPost(postPage, post, driver)
                .clickOnSubmitButton()
                .clickOnPreviewYourPost();
        log.info("We are on the preview of your post page, checking data for consistance:::");

        //
        //Verify negotiateble price is set
        //
        Assert.assertEquals(yourPostPage.getPriceString().trim(), props.getProperty("PriceFieldAssertion"), "Price is not correct");
        log.info("Data on preview page is consistant, post is correct");
    }

}
