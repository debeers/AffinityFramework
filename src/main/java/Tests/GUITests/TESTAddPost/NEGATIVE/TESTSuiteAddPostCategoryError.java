package Tests.GUITests.TESTAddPost.NEGATIVE;

import PageObjects.MainPage;
import PageObjects.PostPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Dem on 17.04.2016.
 */
public class TESTSuiteAddPostCategoryError extends BaseTest {

    @Test
    public void EmptyCategory() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("EmptyCategory");

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.clickOnPreviewButton();

        Assert.assertTrue(postPage.getAllFieldsErrors().contains(props.getProperty("AssertCategoryErrorMessage")), "No error was found");

    }
}
