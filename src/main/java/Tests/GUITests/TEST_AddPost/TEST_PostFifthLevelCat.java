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
import static UtilsGUI.PropertiesLoader.propertyXMLoader;

/**
 * Created by Dem on 30.03.2016.
 */
public class TEST_PostFifthLevelCat extends BaseTest {

    @Test
    public void Add_Post_To_Fifth_Category() throws IOException, AWTException, InterruptedException {

        Properties props = new ResourcesFactory().getResources("Add_Post_To_Fifth_Category");

        Post post = new Post(props);
        int countForPhotoUploads = 0;

        //Go to main page
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //Go to compose new post page
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing page");

        //Create new post
        YourPostPage yourPostPage = makeNewPost(postPage, post, countForPhotoUploads)
                .clickOnSubmitButton()
                .clickOnPreviewYourPost();
        log.info("We are on the preview page of your post. Checking data for consistence:::");

        //Verify data on preview page
        Assert.assertEquals(yourPostPage.getPrice(), post.getPrice(), "Price is not correct");
        Assert.assertEquals(yourPostPage.getCurrency(), "$", "Currency is not correct");
        Assert.assertEquals(yourPostPage.getPostTitle(), props.getProperty("PostTitle"), "Name is not correct");
        Assert.assertEquals(yourPostPage.getDescription().toLowerCase().trim(), post.getDescription().toLowerCase().trim(), "Description is not correct");
        log.info("Data on preview page is consistent. Post is correct");
    }
}
