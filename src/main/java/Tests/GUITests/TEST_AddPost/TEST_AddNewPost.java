package Tests.GUITests.TEST_AddPost;

import Entities.Post;
import PageObjects.*;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GUI_Actions.PostAdd.makeNewPost;
import static UtilsGUI.PropertiesLoader.propertyXMLoader;
import static com.codeborne.selenide.Selenide.$;

public class TEST_AddNewPost extends BaseTest {
    @Test
    public void Add_Post() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/Tests/GUITests/TEST_AddPost/DATA/TEST_AddNewPost.xml");

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
        PostPreviewPage postPreviewPage = makeNewPost(postPage, post, countForPhotoUploads)
                .clickOnPreviewButtonAndLoadPage();
        log.info("We are on the preview post page, checking data for consistance:::");

        //
        //Verify data on preview page
        //
        //Assert.assertEquals($$(postPreviewPage.previewPhotos).size(), countForPhotoUploads);
        Assert.assertTrue(postPreviewPage.previewStepTab.isDisplayed());
        Assert.assertEquals(postPreviewPage.getTextFromPreviewPrice().subSequence(2, 4), post.getPrice(), "Price is not correct");
        Assert.assertEquals(postPreviewPage.getTextFromPreviewPrice().subSequence(0, 1), "$", "Currency is not correct");
        Assert.assertEquals(postPreviewPage.getTextFromPreviewSellerName(), post.getName(), "Name is not correct");
        Assert.assertEquals(postPreviewPage.getTextFromPreviewDescription().toLowerCase().trim(), post.getDescription().toLowerCase().trim(), "Description is not correct");
        log.info("Data on preview page is consistent, post is correct");

        //
        //Publish post and verify result
        //
        SuccessPostedPage successPostedPage = postPreviewPage.clickOnAddPostButton();
        log.info("We are on the success post page, checking data for consistence:::");

        Assert.assertTrue(successPostedPage.makeVipPost.isDisplayed());
        Assert.assertTrue(successPostedPage.markPost.isDisplayed());
        String tmp = new String($(successPostedPage.successMessage).getText().getBytes(Charset.forName("utf-8")));
        Assert.assertEquals(tmp,
                "Ваше объявление было отправлено на проверку",
                "Success message is different!");
        log.info("Test passed, new post posted, with correct data entered during forming process: YoouuuHHuuu!!!");

        //SuccessPostedPage postedAd = postPreviewPage.clickOnPostedAdName();
        log.info("We are on the posted Advert page");

    }
}

