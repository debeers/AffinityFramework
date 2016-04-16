package Tests.GUITests.TEST_AddPost;

import Entities.Post;
import PageObjects.MainPage;
import PageObjects.PostPage;
import PageObjects.YourPostPage;
import TEST_RESOURCES.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

import static Actions.GUI_Actions.PostAdd.makeNewPost;

public class TEST_PostToOtherCat extends BaseTest{

    @Test
    public void TEST_Add_Post_To_Another_Category() throws IOException, AWTException, InterruptedException {

        Properties props = new ResourcesFactory().getResources("TEST_Add_Post_To_Another_Category");

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
        YourPostPage yourPostPage = makeNewPost(postPage, post, countForPhotoUploads)
                .clickOnSubmitButton()
                .clickOnPreviewYourPost();
        log.info("We are on the preview of your post page, checking data for consistance:::");

        //
        //Verify price field
        //
        Assert.assertTrue(yourPostPage.checkForYourBreadcrumbExsistByHREFValue(baseUrl, props.getProperty("CategoryApi")));
        log.info("Data on preview page is consistant, post is correct");

    }

}
