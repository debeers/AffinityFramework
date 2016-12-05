package Tests.GUITests.TESTAddPost.NEGATIVE;

import Entities.Post;
import PageObjects.*;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GUI_Actions.PostAdd.makeNewPost;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 02.04.2016.
 */
public class TESTSuiteASCIITitleCheck extends BaseTest {
    @Test
    public void AdPostWithASCIITitle() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("AdPostWithASCIITitle");

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
        PostPreviewPage postPreviewPage = makeNewPost(postPage, post, driver)
                .clickOnPreviewButtonAndLoadPage();
        log.info("We are on the preview post page, checking data for consistance:::");

        //
        //Verify data on preview page
        //
        //Assert.assertEquals($$(postPreviewPage.previewPhotos).size(), countForPhotoUploads);
//        Assert.assertTrue($(postPreviewPage.previewStepTab).isDisplayed());
        Assert.assertEquals(postPreviewPage.getTextFromTitle(), props.getProperty("PostTitle"), "Title is not correct");
        log.info("Data on preview page is consistent, post is correct");

        //
        //Publish post and verify result
        //
        SuccessPostedPage successPostedPage = postPreviewPage.clickOnAddPostButton();
        log.info("We are on the success post page, checking data for consistence:::");

        Assert.assertTrue(successPostedPage.makeVipPost.isDisplayed());
        Assert.assertTrue(successPostedPage.markPost.isDisplayed());
        String tmp = new String($(successPostedPage.successMessage).getText().getBytes(Charset.forName("utf-8")));
        String assertMessage = new String(props.getProperty("AssertErrorMessage").getBytes(Charset.forName("utf-8")));
        Assert.assertEquals(tmp,
                assertMessage,
                "Success message is different!");
        log.info("Test passed, new post posted, with correct data entered during forming process: YoouuuHHuuu!!!");

        YourPostPage postPreview = postPreviewPage.clickOnPostedAdName();
        log.info("We are on the posted Advert page");

        //Assert.assertEquals(postPreview.getTextFromTitle(), post.getTitle(), "Title is not correct");

    }


}
