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
 * Created by Dem on 25.03.2016.
 */
public class TESTPostThirdLevelCat extends BaseTest {

    @Test
    public void AddPostToThirdCategory() throws IOException, AWTException, InterruptedException {

        Properties props = new ResourcesFactory().getResources("AddPostToThirdCategory");

        Post post = new Post(props);
        int countForPhotoUploads = 0;

        //lets go hello motorolla
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
        YourPostPage yourPostPage = makeNewPost(postPage, post)
                .clickOnSubmitButton()
                .clickOnPreviewYourPost();
        log.info("We are on the preview of your post page, checking data for consistance:::");

        //
        //Verify data on preview your post page
        //
        Assert.assertEquals(yourPostPage.getPrice(), post.getPrice(), "Price is not correct");
        Assert.assertEquals(yourPostPage.getCurrency(), "$", "Currency is not correct");
        Assert.assertEquals(yourPostPage.getPostTitle(), props.getProperty("PostTitle"), "Name is not correct");
        Assert.assertEquals(yourPostPage.getDescription().toLowerCase().trim(), post.getDescription().toLowerCase().trim(), "Description is not correct");
       // Assert.assertTrue(yourPostPage.checkForYourBreadcrumbExsistByHREFValue("/agdam/drugoe/"));
        log.info("Data on preview page is consistant, post is correct");

    }
}