package Tests.AddPost;

import Entities.Post;
import PageObjects.MainPage;
import PageObjects.PostPage;
import PageObjects.PostPreviewPage;
import PageObjects.SuccessPostedPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Properties;
import static Actions.PostAdd.makeNewPost;
import static Utils.PropertiesLoader.propertyXMLoader;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class AddNewPost extends BaseTest{

    @Test
    public void Add_Post() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/Tests/AddPost/Post.xml");

        Post post = new Post(props);
        int countForPhotoUploads = 3;

        //Hurray!!!2
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
        PostPreviewPage postPreviewPage = makeNewPost(postPage, post, countForPhotoUploads).clickOnPreviewButton();
        log.info("We are on the preview post page, checking data for consistance:::");

        //
        //Verify data on preview page
        //
        Assert.assertEquals($$(postPreviewPage.previewPhotos).size(), countForPhotoUploads + 1);
        Assert.assertTrue(postPreviewPage.previewStepTab.isDisplayed());
        Assert.assertEquals(postPreviewPage.getTextFromPreviewPrice().subSequence(2, 4), post.getPrice(), "Price is not correct");
        Assert.assertEquals(postPreviewPage.getTextFromPreviewPrice().subSequence(0, 1), "$", "Currency is not correct");
        Assert.assertEquals(postPreviewPage.getTextFromPreviewSellerName(), post.getName(), "Name is not correct");
        Assert.assertEquals(postPreviewPage.getTextFromPreviewDescription(), post.getDescription(), "Description is not correct");
        log.info("Data on preview page is consistant, post is correct");

        //
        //Publish post and verify result
        //
        SuccessPostedPage successPostedPage = postPreviewPage.clickOnAddPostButton();
        log.info("We are on the success post page, checking data for consistance:::");

        Assert.assertTrue(successPostedPage.makeVipPost.isDisplayed());
        Assert.assertTrue(successPostedPage.markPost.isDisplayed());
        String tmp = new String($(successPostedPage.successMessage).getText().getBytes(Charset.forName("utf-8")));
        Assert.assertEquals(tmp,
                "Ваше объявление было отправлено на проверку",
                "Success message is different!");
        log.info("Test passed, new post posted, with correct data entered during formiong process: YoouuuHHuuu!!!");
    }
}
